package com.example.transactionlog.application.dto.transaction.log.request;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record TransactionLogRequest(
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
