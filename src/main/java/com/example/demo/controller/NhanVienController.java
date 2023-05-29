package com.example.demo.controller;

import com.example.demo.Service.ServiceChucVu;
import com.example.demo.Service.ServiceNhanVien;
import com.example.demo.model.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    ServiceNhanVien svnv;
    @Autowired
    ServiceChucVu svcv;
    @GetMapping("/index")
    public String home(Model model){
        if(svnv.getAll().size()<=0){
            model.addAttribute("mess","List Student is empty!");
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        } else {
            model.addAttribute("list", svnv.getAll());
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
        }
    }
    @PostMapping("/search")
    public String search(Model model,@RequestParam("keyword") String keyword){
        ArrayList<NhanVien> listSearch = new ArrayList<>();
        String nameSearch = keyword.toLowerCase(Locale.ROOT);
        for (NhanVien nv: svnv.getAll()
             ) {
            String name = nv.getTen().toLowerCase(Locale.ROOT);
            if(name.contains(nameSearch)){
                listSearch.add(nv);
            }
        }
            model.addAttribute("list", listSearch);
            model.addAttribute("cv",svcv.getAll());
            model.addAttribute("view","NhanVien/index.jsp");
            return "layout";
    }
    @PostMapping("/save")
    public String save(Model model,@RequestParam("ma") String ma,
                       @RequestParam("ten") String ten,
                       @RequestParam("tenDem") String tenDem,
                       @RequestParam("ho") String ho,
                       @RequestParam("gioiTinh") String gioiTinh,
                       @RequestParam("diaChi") String diaChi,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("matKhau") String matKhau,
                       @RequestParam("trangThai") String trangThai,
                       @RequestParam("cv") String cv
                       ){
        NhanVien nv = new NhanVien();
        nv.setMa(ma);
        nv.setTen(ten);
        nv.setTenDem(tenDem);
        nv.setHo(ho);
        nv.setGioiTinh(gioiTinh);
        nv.setDiaChi(diaChi);
        nv.setNgaySinh(Date.valueOf(ngaySinh));
        nv.setSdt(sdt);
        nv.setMatKhau(matKhau);
        nv.setTrangThai(Integer.valueOf(trangThai));
        UUID id = UUID.fromString(cv);
        nv.setCv(svcv.findById(id));
        svnv.save(nv);
        model.addAttribute("list", svnv.getAll());
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/index.jsp");
        return "layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        svnv.delete(uuid);
        model.addAttribute("list", svnv.getAll());
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/index.jsp");
        return "layout";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        NhanVien nv = svnv.getById(uuid);
        model.addAttribute("nv", nv);
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/detail.jsp");
        return "layout";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") String id,
                       @RequestParam("ten") String ten,
                       @RequestParam("tenDem") String tenDem,
                       @RequestParam("ho") String ho,
                       @RequestParam("gioiTinh") String gioiTinh,
                       @RequestParam("diaChi") String diaChi,
                       @RequestParam("ngaySinh") String ngaySinh,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("matKhau") String matKhau,
                       @RequestParam("trangThai") String trangThai,
                       @RequestParam("cv") String cv
    ){
        UUID uuid = UUID.fromString(id);
        NhanVien nv = svnv.getById(uuid);
        nv.setTen(ten);
        nv.setTenDem(tenDem);
        nv.setHo(ho);
        nv.setGioiTinh(gioiTinh);
        nv.setDiaChi(diaChi);
        nv.setNgaySinh(Date.valueOf(ngaySinh));
        nv.setSdt(sdt);
        nv.setMatKhau(matKhau);
        nv.setTrangThai(Integer.valueOf(trangThai));
        svnv.update(nv);
        model.addAttribute("list", svnv.getAll());
        model.addAttribute("cv",svcv.getAll());
        model.addAttribute("view","NhanVien/index.jsp");
        return "layout";
    }
}
