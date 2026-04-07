package com.example.transactionlog.infrastructure.persistence.entity.transaction.log;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Document("transaction-log")
public class TransactionLogDocument {
    String id;

    String transactionId;

    Map<String, Object> requestData;
    Map<String, Object> responseData;

    String requestBy;
    String requestByName;

    LocalDateTime requestAt;
    LocalDateTime responseAt;

    String action;

    Integer retryCount;

    String status;
}
