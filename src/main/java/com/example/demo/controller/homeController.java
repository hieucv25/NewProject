package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

//    @RequestMapping(value="/home", method = RequestMethod.GET)
// @RequestParam có thể có hoặc không
//    @GetMapping("/home")
//    public String index(Model model, @RequestParam(value = "id",required = false) Integer id, @RequestParam(value="name",required = false) String name){
//        model.addAttribute("title","Hello Spring");
//        return "index";
//    }

//    @GetMapping(value="/home/{id}")
//    //@PathVariable đường dẫn cố định bắt buộc phải có
//    public String index2(Model model, @PathVariable("id") Integer id){
//        model.addAttribute("title2",id);
//        return "index2";
//    }
// Giống nhau là cả 2 đều truy xuất giá trị trên URL.
    @GetMapping("/home-login")
    public String index3(Model model){
        return "index3";
    }
    @PostMapping("/login")
    public String index4(Model model, @RequestParam(value = "username") String username, @RequestParam(value="password") String password){
        if(username.equals("nguyenvv4")&&password.equals("nguyenvv4")){
            model.addAttribute("mess","Login success");
        } else {
            model.addAttribute("mess","Login fail");
        }
        return "index4";
    }
}
