package org.example;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {

    // FIXME testar com map
    // FIXME testar com data e diferente formato
    // FIXME Update README.md

    @Mapping(source = "cardNumber", target = "card")
    @Mapping(source = "terminal", target = "terminalId")
    @Mapping(source = "merchant", target = "merchantId")
    @Mapping(source = "date", target = "merchantDate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "systemDate", ignore = true)
    Transaction requestToTransaction(CreateTransactionRequest createTransactionRequest);

}