package com.example.demo.Service.Impl;

import com.example.demo.Repository.NsxRepository;
import com.example.demo.Service.ServiceNsx;
import com.example.demo.model.Nsx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceNsxImpl implements ServiceNsx {
    @Autowired
    NsxRepository nrp;
    @Override
    public ArrayList<Nsx> getAll() {
        return (ArrayList<Nsx>) nrp.findAll();
    }
}
