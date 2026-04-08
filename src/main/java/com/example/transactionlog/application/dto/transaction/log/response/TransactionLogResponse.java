package com.example.transactionlog.application.dto.transaction.log.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record TransactionLogResponse(
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
