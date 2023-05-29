package com.example.demo.controller;

import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/spct")
public class SPCTController {
    @Autowired
    ServiceSanPham svsp;
    @Autowired
    ServiceMauSac svms;
    @Autowired
    ServiceNsx svnsx;
    @Autowired
    ServiceDongSP svdsp;
    @Autowired
    ServiceSPCT svspct;
    @GetMapping("/index")
    private String home(Model model){
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/index.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    private String delete(Model model, @PathVariable("id") String id){
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/index.jsp");
        UUID uuid = UUID.fromString(id);
        svspct.deleteById(uuid);
        return "layout";
    }
    @GetMapping("/detail/{id}")
    private String detail(Model model, @PathVariable("id") String id){
        model.addAttribute("listSP",svsp.getAll());
        model.addAttribute("listMS",svms.getAll());
        model.addAttribute("listNSX",svnsx.getAll());
        model.addAttribute("listDSP",svdsp.getAll());
        model.addAttribute("listSPCT",svspct.getAll());
        model.addAttribute("view","SPCT/detail.jsp");
        UUID uuid = UUID.fromString(id);
        model.addAttribute("spct",svspct.getOne(uuid));
        return "layout";
    }

}
