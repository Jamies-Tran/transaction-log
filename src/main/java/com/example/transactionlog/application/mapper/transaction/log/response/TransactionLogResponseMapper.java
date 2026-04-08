package com.example.transactionlog.application.mapper.transaction.log.response;

import com.example.transactionlog.application.dto.transaction.log.request.TransactionLogRequest;
import com.example.transactionlog.application.dto.transaction.log.response.TransactionLogResponse;
import com.example.transactionlog.domain.entity.transaction.log.TransactionLog;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionLogResponseMapper {
    TransactionLogResponse toDto(TransactionLog domain);

    List<TransactionLogResponse> toDto(List<TransactionLog> domain);
}
