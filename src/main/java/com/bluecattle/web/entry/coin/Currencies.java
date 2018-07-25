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
 * 货币信息
 * @author ningchengzeng
 */
@NoArgsConstructor
@Data
@Document(collection = "coin_currencies")
public class Currencies {

    //编号
    @Indexed(unique = true)
    private String code;
    //图标
    private String icon;
    //单位
    private String unit;
    //名称
    private TitleBean title;
    //上架时间
    private String date;
    //货币介绍
    private DescribeBean describe;
    //白皮书
    private HrefBean whitePaper;
    //网站
    private List<HrefBean> webSite;
    //区块站点
    private List<HrefBean> blockStation;

    //代币
    private Boolean assets;
    //代币平台
    private String assetsPlatform;

    //分析信息
    private Analyse analyse = new Analyse();

    @NoArgsConstructor
    @Data
    public static class Analyse{
        //价格
        private PriceBean price;
        //涨跌
        private Double chg;

        //24小时最高
        private PriceBean max;
        //24小时最低
        private PriceBean min;
        //流通市值
        private PriceBean circulationPrice;
        //流通排名
        private Integer circulationRanking;

        //发行量
        private Integer issue;
        //流通量
        private Integer circulation;

        //24小时流通量
        private PriceBean circulationPrice24;
        //24小时流通排名
        private Integer circulationRanking24;

        private Long ts; //更新时间
    }
}
