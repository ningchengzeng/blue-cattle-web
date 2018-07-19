package com.bluecattle.web.entry.customer;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "customer_login_log")
public class LoginLog {

    @DBRef
    private User user;

    private Date time;
    private String ip;
}
