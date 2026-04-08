package com.example.transactionlog.domain.entity.transaction.log;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record TransactionLog (
        String id,
        String transactionId,

        Map<String, Object> requestData,
        Map<String, Object> responseData,

        String requestBy,
        String requestByName,

        LocalDateTime requestAt,
        LocalDateTime responseAt,

        String description,
        Integer retryCount,
        String errMessage,
        Boolean allowRetry,
        String status
) {
}
