package com.example.transactionlog.infrastructure.persistence.mapper.transaction.log;

import com.example.transactionlog.domain.model.transaction.log.TransactionLog;
import com.example.transactionlog.infrastructure.persistence.entity.transaction.log.TransactionLogDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionLogMapper {
    TransactionLog toDto(TransactionLogDocument entity);

    TransactionLogDocument toEntity(TransactionLog dto);

    List<TransactionLog> toDto(List<TransactionLogDocument> entity);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget TransactionLogDocument entity, TransactionLog transactionLog);
}
