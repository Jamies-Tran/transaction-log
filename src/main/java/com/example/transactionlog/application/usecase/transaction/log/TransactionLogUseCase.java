package com.example.transactionlog.application.usecase.transaction.log;

import com.example.transactionlog.domain.entity.transaction.log.TransactionLog;
import com.example.transactionlog.domain.repository.transaction.log.TransactionLogRepository;
import com.example.transactionlog.domain.service.transaction.log.TransactionLogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionLogUseCase implements TransactionLogService {
    TransactionLogRepository transactionLogRepository;

    @Override
    public void save(TransactionLog transactionLog) {
        transactionLogRepository.upsert(transactionLog);
    }

    @Override
    public Optional<TransactionLog> findById(String id) {
        return transactionLogRepository.findById(id);
    }

    @Override
    public List<TransactionLog> findAllByTransactionId(String transactionId) {
        return transactionLogRepository.findAllByTransactionId(transactionId);
    }
}
