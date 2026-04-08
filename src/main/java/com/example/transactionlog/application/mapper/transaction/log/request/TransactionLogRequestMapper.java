package com.example.transactionlog.application.mapper.transaction.log.request;

import com.example.transactionlog.application.dto.transaction.log.request.TransactionLogRequest;
import com.example.transactionlog.domain.entity.transaction.log.TransactionLog;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionLogRequestMapper {
    TransactionLog toDomain(TransactionLogRequest dto);

    List<TransactionLog> toDomain(List<TransactionLogRequest> dto);
}
