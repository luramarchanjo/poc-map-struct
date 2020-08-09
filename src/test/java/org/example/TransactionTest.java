package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

public class TransactionTest extends TestCase {

    @Test
    public void testMapper() {
        CreateTransactionRequest request = CreateTransactionRequest.builder()
                .type(TransactionType.PURCHASE)
                .cardNumber("9999 8888 7777 6666")
                .terminal("POS-000001")
                .merchant("MACDONALDS-0000001")
                .amount(BigDecimal.valueOf(55.43))
                .date(LocalDateTime.of(2020, 8, 9, 9, 45))
                .ips(Collections.singletonList("127.0.0.1, 192.168.0.1, 0.0.0.0"))
                .build();

        TransactionMapper transactionMapper = new TransactionMapperImpl();
        Transaction transaction = transactionMapper.requestToTransaction(request);

        assertEquals(transaction.getType(), request.getType());
        assertEquals(transaction.getCard(), request.getCardNumber());
        assertEquals(transaction.getTerminalId(), request.getTerminal());
        assertEquals(transaction.getMerchantId(), request.getMerchant());
        assertEquals(transaction.getAmount(), request.getAmount().doubleValue());
        assertEquals(transaction.getMerchantDate(), request.getDate());
        assertEquals(transaction.getIps(), request.getIps());
        assertNotNull(transaction.getSystemDate());
        assertNotNull(transaction.getId());
    }

}