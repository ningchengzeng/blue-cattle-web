package com.bluecattle.web.vo;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private String id;
    private BigDecimal price;
    private BigDecimal squareFeet;
    private Integer bedrooms;
    private Integer bathrooms;
    private String address;
    private String features;
    private String status;
    private String thumbnail;
}
