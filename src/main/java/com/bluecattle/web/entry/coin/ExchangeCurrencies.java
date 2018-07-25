package com.bluecattle.web.entry.coin;

import com.bluecattle.web.entry.PriceBean;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * 交易所交易对信息
 * @author ningchengzeng
 */
@NoArgsConstructor
@Data
@Document(collection = "coin_exchange_currencies")
public class ExchangeCurrencies {
    @DBRef
    private Currencies form;
    @DBRef
    private Currencies to;

    @DBRef
    private Exchange exchange;
    private Analyse analyse = new Analyse();

    @NoArgsConstructor
    @Data
    public static class Analyse{
        private PriceBean price;    //成交价格
        private BigDecimal volume;  //成交量
        private PriceBean turnover; //成交额
        private Long ts;    //更新时间
    }
}
