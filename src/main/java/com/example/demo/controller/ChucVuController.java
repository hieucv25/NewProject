package com.example.demo.controller;

import com.example.demo.Service.ServiceChucVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    ServiceChucVu svcv;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("list",svcv.getAll());
        model.addAttribute("view","ChucVu/index.jsp");
        return "layout";
    }
}
