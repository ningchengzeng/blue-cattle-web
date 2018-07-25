package com.bluecattle.web.service.scheduled;

import com.bluecattle.web.entry.PriceBean;
import com.bluecattle.web.entry.coin.Global;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class CoinService {

    private final static String BASE_URL = "https://api.coinmarketcap.com/v2/";
    private final static String GLOBAL = BASE_URL + "global/?convert=CNY";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void global() {
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(GLOBAL, Map.class);
        if(responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.hasBody()){
            Global global = new Global();

            Map map = responseEntity.getBody();
            Map data = MapUtils.getMap(map, "data");
            global.setActiveCryptoCurrencies(MapUtils.getInteger(data, "active_cryptocurrencies"));
            global.setActiveMarkets(MapUtils.getInteger(data, "active_markets"));
            global.setBitcoinPercentageMarketCap(MapUtils.getDouble(data, "bitcoin_percentage_of_market_cap"));


            Map quotes = MapUtils.getMap(data, "quotes");
            Map usd = MapUtils.getMap(quotes, "USD");
            Map cny = MapUtils.getMap(quotes, "CNY");

            PriceBean totalMarketCap = new PriceBean();
            totalMarketCap.setUsd(BigDecimal.valueOf(MapUtils.getLong(usd, "total_market_cap")));
            totalMarketCap.setCny(BigDecimal.valueOf(MapUtils.getLong(cny, "total_market_cap")));

            PriceBean totalVolume24h = new PriceBean();
            totalVolume24h.setUsd(BigDecimal.valueOf(MapUtils.getLong(usd, "total_volume_24h")));
            totalVolume24h.setCny(BigDecimal.valueOf(MapUtils.getLong(cny, "total_volume_24h")));

            global.setTotalMarketCap(totalMarketCap);
            global.setTotalVolume24h(totalVolume24h);

            mongoTemplate.remove(Global.class).all();
            mongoTemplate.insert(global);
        }
    }

    public void list(){

    }
}
