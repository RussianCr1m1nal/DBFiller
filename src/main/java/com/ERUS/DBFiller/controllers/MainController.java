package com.ERUS.DBFiller.controllers;

import com.ERUS.DBFiller.dataBase.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    Query query;

    @RequestMapping("/home")
    public String home(@RequestParam(name="home", required=false, defaultValue="home") String home,
                           Model model){
        return "home";
    }

    @GetMapping("/generate")
    public String generate(@RequestParam(name="number", required=false, defaultValue="1") int number,
                           @RequestParam(name="language", required=false, defaultValue="SQL") String language,
                           @RequestParam(name="table", required=false, defaultValue="TABLE") String table,
                           @RequestParam(name="attrs", required=false, defaultValue="name") String attrs,
                           Model model){
        query = new Query();
        model.addAttribute("query",query.createValues(number,attrs,language,table));
        return "generate";
    }
}
