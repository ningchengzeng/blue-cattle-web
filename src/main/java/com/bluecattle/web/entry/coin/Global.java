package com.bluecattle.web.entry.coin;

import com.bluecattle.web.entry.PriceBean;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Document(collection = "coin_global")
public class Global {

    private Integer activeCryptoCurrencies;
    private Integer activeMarkets;
    private Double bitcoinPercentageMarketCap;

    private PriceBean totalMarketCap = new PriceBean();
    private PriceBean totalVolume24h = new PriceBean();
}
