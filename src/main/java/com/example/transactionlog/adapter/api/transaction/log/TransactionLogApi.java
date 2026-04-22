package com.example.transactionlog.adapter.api.transaction.log;

import com.example.transactionlog.application.dto.transaction.log.request.TransactionLogRequest;
import com.example.transactionlog.application.dto.transaction.log.response.TransactionLogResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/log")
public interface TransactionLogApi {
    @PostMapping
    ResponseEntity<String> save(@RequestBody TransactionLogRequest request);

    @GetMapping("/{id}")
    ResponseEntity<TransactionLogResponse> findById(@PathVariable String id);

    @GetMapping("/transactions/{transactionId}")
    ResponseEntity<List<TransactionLogResponse>> findAllByTransactionId(@PathVariable String transactionId);
}
