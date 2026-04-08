package com.example.transactionlog.domain.repository.transaction.log;

import com.example.transactionlog.domain.entity.transaction.log.TransactionLog;

import java.util.List;
import java.util.Optional;

public interface TransactionLogRepository {
    TransactionLog upsert(TransactionLog transactionLog);

    Optional<TransactionLog> findById(String id);

    List<TransactionLog> findAllByTransactionId(String transactionId);
}
