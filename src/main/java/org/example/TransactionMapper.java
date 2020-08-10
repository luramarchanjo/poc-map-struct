package org.example;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {

    @Mapping(source = "cardNumber", target = "card")
    @Mapping(source = "terminal", target = "terminalId")
    @Mapping(source = "merchant", target = "merchantId")
    @Mapping(source = "date", target = "merchantDate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "systemDate", ignore = true)
    Transaction requestToTransaction(CreateTransactionRequest createTransactionRequest);

}