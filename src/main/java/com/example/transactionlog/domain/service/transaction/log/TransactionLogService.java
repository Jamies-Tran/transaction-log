package com.example.transactionlog.domain.service.transaction.log;

import com.example.transactionlog.domain.model.transaction.log.TransactionLog;

import java.util.List;
import java.util.Optional;

public interface TransactionLogService {
    void save(TransactionLog transactionLog);

    Optional<TransactionLog> findById(String id);

    List<TransactionLog> findAllByTransactionId(String transactionId);
}
