package com.bluecattle.web.entry.customer;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 *
 */
@Data
@NoArgsConstructor
@Document(collection = "customer_user")
public class User {
    //用户名称
    @Indexed(unique = true)
    private String username;
    //姓名
    private String fullname;
    //密码
    private String password;

    //头像
    private String icon;
    //手机号码
    private String phone;

    private Date createTime;
    private Date updateTime;

    private LastLogin lastLogin;

    @Data
    @NoArgsConstructor
    public static class LastLogin{
        private Date time;
        private String ip;
    }
}
