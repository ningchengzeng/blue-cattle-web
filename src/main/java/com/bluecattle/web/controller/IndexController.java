package com.bluecattle.web.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping({"/", "", "index.html"})
    public String index(ModelMap modelMap){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70d, true));
        books.add(new Book("Life, the Universe and Everything", 60d, false));
        books.add(new Book("The Restaurant at the End of the Universe", 5.40d, true));

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("books", books);
        model.put("pageName", "My Bookshelf");

        modelMap.putAll(model);

        return "index";
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Book{
        private String name;
        private Double price;
        private Boolean available;
    }
}
