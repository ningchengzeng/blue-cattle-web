package com.bluecattle.web.entry.news;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 新闻类型
 * @author ningchengzeng
 */
@Data
@NoArgsConstructor
@Document(collection = "new_type")
public class NewsType {

    @Indexed(unique = true)
    private String code;
    private String name;

}
