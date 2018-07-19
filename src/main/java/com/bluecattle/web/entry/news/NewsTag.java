package com.bluecattle.web.entry.news;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
public class NewsTag{
    @Indexed(unique = true)
    private String code;
    private String name;
}