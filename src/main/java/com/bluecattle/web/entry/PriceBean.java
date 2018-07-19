package com.bluecattle.web.entry;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class PriceBean {
    private BigDecimal cny = BigDecimal.ZERO;
    private BigDecimal usd = BigDecimal.ZERO;
    private BigDecimal btc = BigDecimal.ZERO;
}
