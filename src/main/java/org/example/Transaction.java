package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Builder.Default
    private UUID id = UUID.randomUUID();

    private TransactionType type;

    private String card;

    private String terminalId;

    private String merchantId;

    private BigDecimal amount;

    private LocalDateTime merchantDate;

    @Builder.Default
    private LocalDateTime systemDate = LocalDateTime.now(ZoneId.of("UTC"));

}