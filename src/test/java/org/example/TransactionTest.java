package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
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

        TransactionMapperImpl transactionMapper = new TransactionMapperImpl();
        Transaction transaction = transactionMapper.requestToTransaction(request);

        Assert.assertEquals(transaction.getType(), request.getType());
        Assert.assertEquals(transaction.getCard(), request.getCardNumber());
        Assert.assertEquals(transaction.getTerminalId(), request.getTerminal());
        Assert.assertEquals(transaction.getMerchantId(), request.getMerchant());
        Assert.assertEquals(transaction.getAmount(), Double.valueOf(request.getAmount().doubleValue()));
        Assert.assertEquals(transaction.getMerchantDate(), request.getDate());
        Assert.assertEquals(transaction.getIps(), request.getIps());
        Assert.assertNotNull(transaction.getSystemDate());
        Assert.assertNotNull(transaction.getId());
    }

}