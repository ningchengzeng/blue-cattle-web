package com.bluecattle.web.entry.news;

import com.bluecattle.web.entry.DescribeBean;
import com.bluecattle.web.entry.HrefBean;
import com.bluecattle.web.entry.NewState;
import com.bluecattle.web.entry.TitleBean;
import com.bluecattle.web.entry.coin.Currencies;
import com.bluecattle.web.entry.customer.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 新闻
 * @author ningchengzeng
 */
@Data
@NoArgsConstructor
@Document(collection = "new_journalism")
public class Journalism {

    @Indexed(unique = true)
    private String code;
    private TitleBean title;
    private NewState state;
    @DBRef
    private NewsType type;
    @DBRef
    private List<NewsTag> tags;
    private DescribeBean describe;
    //时间
    private Date time;
    //创建时间
    private Date createTime;
    //虚拟币
    @DBRef
    private List<Currencies> currencies = new ArrayList<>();
    //发稿
    private Draft draft;
    //上架时间
    private Date upTime;
    //下架时间
    private Date downTime;


    @Data
    @NoArgsConstructor
    public static class Draft{
        @DBRef
        private User user;
        private HrefBean source;
    }
}
