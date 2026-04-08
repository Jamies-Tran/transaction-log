package com.example.transactionlog.infrastructure.persistence.adapter.transaction.log;

import com.example.transactionlog.domain.entity.transaction.log.TransactionLog;
import com.example.transactionlog.domain.repository.transaction.log.TransactionLogRepository;
import com.example.transactionlog.infrastructure.persistence.entity.transaction.log.TransactionLogDocument;
import com.example.transactionlog.infrastructure.persistence.mapper.transaction.log.TransactionLogMapper;
import com.example.transactionlog.infrastructure.persistence.repository.MongoTransactionLogRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MongoTransactionLogRepositoryAdapter implements TransactionLogRepository {
    MongoTransactionLogRepo mongoTransactionLogRepo;

    TransactionLogMapper transactionLogMapper;

    @Override
    public TransactionLog upsert(TransactionLog transactionLog) {
        if (Objects.nonNull(transactionLog.transactionId())) {
            Optional<TransactionLogDocument> transactionLogDocument = mongoTransactionLogRepo
                    .findById(transactionLog.id());

            return transactionLogDocument
                    .map(t -> {
                        TransactionLogDocument transactionLogDocument1 = transactionLogDocument.get();
                        transactionLogMapper.update(transactionLogDocument1, transactionLog);
                        TransactionLogDocument saveTransactionDocument = mongoTransactionLogRepo.save(transactionLogDocument1);
                        return transactionLogMapper.toDto(saveTransactionDocument);
                    })
                    .orElseThrow(RuntimeException::new);
        }
        TransactionLogDocument transactionLogDocument = transactionLogMapper.toEntity(transactionLog);
        TransactionLogDocument saveTransactionLogDocument = mongoTransactionLogRepo.save(transactionLogDocument);

        return transactionLogMapper.toDto(saveTransactionLogDocument);
    }

    @Override
    public Optional<TransactionLog> findById(String id) {
        Optional<TransactionLogDocument> transactionLogDocument = mongoTransactionLogRepo.findById(id);

        return transactionLogDocument.map(transactionLogMapper::toDto);
    }

    @Override
    public List<TransactionLog> findAllByTransactionId(String transactionId) {
        List<TransactionLogDocument> transactionLogDocuments = mongoTransactionLogRepo.findAllByTransactionId(transactionId);

        return transactionLogMapper.toDto(transactionLogDocuments);
    }
}
