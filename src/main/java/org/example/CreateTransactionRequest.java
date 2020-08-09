package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequest {

    private TransactionType type;

    private String cardNumber;

    private String terminal;

    private String merchant;

    private BigDecimal amount;

    private LocalDateTime date;

    private Collection<String> ips;

}