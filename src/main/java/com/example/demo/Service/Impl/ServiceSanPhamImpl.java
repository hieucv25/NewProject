package com.example.demo.Service.Impl;

import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Service.ServiceSanPham;
import com.example.demo.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServiceSanPhamImpl implements ServiceSanPham {
    @Autowired
    SanPhamRepository sprp;
    @Override
    public ArrayList<SanPham> getAll() {
        return (ArrayList<SanPham>) sprp.findAll();
    }
}
