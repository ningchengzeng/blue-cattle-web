package com.bluecattle.web.entry.coin;

import com.bluecattle.web.entry.PriceBean;
import com.bluecattle.web.entry.TimeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 交易排行
 * @author ningchengzeng
 */
@NoArgsConstructor
@Data
@Document(collection = "coin_exchange_rankings")
public class CurrenciesRiseFall {

    @DBRef
    private Currencies currencies;
    private PriceBean price;
    private PriceBean turnover;
    private Double chg;

    /**
     * 时间段
     */
    private TimeType time;
}
