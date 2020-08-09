package org.example;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    // FIXME testar com enum
    // FIXME testar com lista
    // FIXME testar com map
    // FIXME testar com tipo diferente
    // FIXME testar com mesmo tipo
    // FIXME testar com data
    // FIXME testar com data e diferente formato

    @Mapping(source = "cardNumber", target = "card")
    @Mapping(source = "terminal", target = "terminalId")
    @Mapping(source = "merchant", target = "merchantId")
    @Mapping(source = "date", target = "merchantDate")
    Transaction requestToTransaction(CreateTransactionRequest createTransactionRequest);

}