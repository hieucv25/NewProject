package com.example.demo.Service.Impl;

import com.example.demo.Repository.DongSPRepository;
import com.example.demo.Service.ServiceDongSP;
import com.example.demo.model.DongSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceDongSPImpl implements ServiceDongSP {
    @Autowired
    DongSPRepository drp;
    @Override
    public ArrayList<DongSP> getAll() {
        return (ArrayList<DongSP>) drp.findAll();
    }
}
