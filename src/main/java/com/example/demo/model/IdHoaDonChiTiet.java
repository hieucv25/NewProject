package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class IdHoaDonChiTiet implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_hoa_don")
    private HoaDon hd;

    @ManyToOne
    @JoinColumn(name="id_chi_tiet_san_pham")
    private SanPhamChiTiet spct;
}
