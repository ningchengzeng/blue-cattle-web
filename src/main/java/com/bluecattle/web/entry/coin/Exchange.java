package com.bluecattle.web.entry.coin;

import com.bluecattle.web.entry.DescribeBean;
import com.bluecattle.web.entry.HrefBean;
import com.bluecattle.web.entry.PriceBean;
import com.bluecattle.web.entry.TitleBean;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 交易所
 * @author ningchengzeng
 */
@NoArgsConstructor
@Data
@Document(collection = "coin_exchange")
public class Exchange {

    @Indexed(unique = true)
    private String code;
    private String icon;
    private TitleBean title;

    private int star;
    private String costDescription;

    private CountryBean country;
    private HrefBean website;
    private DescribeBean description;
    private List<TypesBean> types;
    private List<String> tags;
    private List<WeiboBean> weibo;
    private Analyse analyse = new Analyse();

    @NoArgsConstructor
    @Data
    public static class Analyse{
        //24小时流通量
        private PriceBean circulationPrice24;
        //24小时流通排名
        private Integer circulationRanking24;
        private Long ts;
    }

    @NoArgsConstructor
    @Data
    public static class CountryBean {
        /**
         * code : us
         * title : 美国
         */
        private String code;
        private String title;
    }

    @NoArgsConstructor
    @Data
    public static class TypesBean {
        /**
         * value : 1
         * code : xianhuo
         * desc : 支持现货
         */
        private int value;
        private String code;
        private String desc;
    }

    @NoArgsConstructor
    @Data
    public static class WeiboBean {
        private String code;
        private String title;
        private String href;
    }
}
