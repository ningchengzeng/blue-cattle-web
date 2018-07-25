package com.bluecattle.web.service;

import com.bluecattle.web.vo.Property;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class PropertyService {

    public List<Property> findProperties() {
        return Arrays.asList(new Property[] {
                new Property("1", BigDecimal.valueOf(30000), BigDecimal.valueOf(40), 2, 1, "14 Tottenham Court Road", "Newly renovated stainless steel appliances with LARGE GRAND BEDROOMS. Located on beautiful tree-lined block", "SOLD", "/condo1.jpg"),
                new Property("1", BigDecimal.valueOf(3000.4), BigDecimal.valueOf(40), 2, 1, "44-46 Morningside Road", " It is large floor-thru, and offers plenty of sunlight, kitchen & dining area, 2 spacious bedrooms, and huge living room", "SOLD", "/condo2.jpg"),
                new Property("1", BigDecimal.valueOf(30000.657), BigDecimal.valueOf(40), 2, 1, "27 Colmore Row", " This apartment is surrounded by plenty of businesses and right next to McGorlick park.There are 2 large rooms, wood floors throughout, kitchen and baths.", "SOLD", "/house1.jpg"),
                new Property("1", BigDecimal.valueOf(3000.23), BigDecimal.valueOf(40), 2, 1, "3 Edgar Building", "All buildings feature elevators, central laundry facilities and spacious apartments with wood flooring throughout", "SOLD", "/condo2.jpg"),
                new Property("1", BigDecimal.valueOf(30199.99), BigDecimal.valueOf(40), 1, 1, "91 Western Road", "A Warm & Bright prewar 1 Bedroom, upgraded kitchen Marble Bath, Granite counter tops, Stainless Steel appliances and Oak Flooring", "SOLD", "/house2.jpg"),
                new Property("1", BigDecimal.valueOf(30199.99), BigDecimal.valueOf(40), 1, 1, "91 Western Road", "A Warm & Bright prewar 1 Bedroom, upgraded kitchen Marble Bath, Granite counter tops, Stainless Steel appliances and Oak Flooring", "SOLD", "/house2.jpg"),
                new Property("1", BigDecimal.valueOf(30199.99), BigDecimal.valueOf(40), 1, 1, "91 Western Road", "A Warm & Bright prewar 1 Bedroom, upgraded kitchen Marble Bath, Granite counter tops, Stainless Steel appliances and Oak Flooring", "SOLD", "/house2.jpg"),
                new Property("1", BigDecimal.valueOf(30199.99), BigDecimal.valueOf(40), 1, 1, "91 Western Road", "A Warm & Bright prewar 1 Bedroom, upgraded kitchen Marble Bath, Granite counter tops, Stainless Steel appliances and Oak Flooring", "SOLD", "/house2.jpg"),
        });
    };
}
