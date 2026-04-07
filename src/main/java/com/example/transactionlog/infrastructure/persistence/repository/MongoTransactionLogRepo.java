package com.example.transactionlog.infrastructure.persistence.repository;

import com.example.transactionlog.infrastructure.persistence.entity.transaction.log.TransactionLogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoTransactionLogRepo extends MongoRepository<TransactionLogDocument, String> {
    List<TransactionLogDocument> findAllByTransactionId(String transactionId);
}
