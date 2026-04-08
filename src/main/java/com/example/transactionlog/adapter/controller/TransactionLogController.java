package com.example.transactionlog.adapter.controller;

import com.example.transactionlog.adapter.api.transaction.log.TransactionLogApi;
import com.example.transactionlog.application.dto.transaction.log.request.TransactionLogRequest;
import com.example.transactionlog.application.dto.transaction.log.response.TransactionLogResponse;
import com.example.transactionlog.application.mapper.transaction.log.request.TransactionLogRequestMapper;
import com.example.transactionlog.application.mapper.transaction.log.response.TransactionLogResponseMapper;
import com.example.transactionlog.domain.service.transaction.log.TransactionLogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionLogController implements TransactionLogApi {
    TransactionLogService transactionLogService;

    TransactionLogRequestMapper requestMapper;

    TransactionLogResponseMapper responseMapper;

    @Override
    public ResponseEntity<String> save(TransactionLogRequest request) {
        transactionLogService.save(requestMapper.toDomain(request));

        return ResponseEntity.ok("Tạo transaction log thành công!");
    }

    @Override
    public ResponseEntity<TransactionLogResponse> findById(String id) {
        TransactionLogResponse response = transactionLogService.findById(id)
                .map(responseMapper::toDto)
                .orElseThrow(RuntimeException::new);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<TransactionLogResponse>> findAllByTransactionId(String transactionId) {
        List<TransactionLogResponse> responses = responseMapper.toDto(transactionLogService
                .findAllByTransactionId(transactionId));

        return ResponseEntity.ok(responses);
    }
}
