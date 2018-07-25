package com.bluecattle.web.component.scheduled;

import com.bluecattle.web.service.scheduled.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 币信息
 * @author ningchengzeng
 */
@Component
public class CoinComponent {

    @Autowired
    private CoinService coinService;

    /**
     * 每10分钟更新一次
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    public void global() {
        coinService.global();
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    public void list(){
        coinService.list();
    }
}
