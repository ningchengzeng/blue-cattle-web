package com.bluecattle.web.entry.coin;

import com.bluecattle.web.entry.PriceBean;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * 感念行情
 * @author ningchengzeng
 */
@NoArgsConstructor
@Data
@Document(collection = "coin_concept")
public class Concept {

    @Indexed(unique = true)
    private String code;
    private String name;

    //分析信息
    private Analyse analyse = new Analyse();

    @NoArgsConstructor
    @Data
    public static class Analyse{
        //24小时交易额
        private PriceBean transaction1d = new PriceBean();
        //平均涨跌
        private Double argChg;
        //最大涨幅
        @DBRef
        private Currencies increaseMax;
        //最大跌幅
        @DBRef
        private Currencies declinesMax;
        //涨幅列表
        @DBRef
        private List<Currencies> increase = new ArrayList<>();
        //跌幅列表
        @DBRef
        private List<Currencies> declines = new ArrayList<>();
    }
}
