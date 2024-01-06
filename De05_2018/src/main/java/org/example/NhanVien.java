package org.example;

import java.io.Serializable;

public class NhanVien extends Person implements Serializable {
    private int maNhanVien;
    private double heSoLuong;
    private String donVi;

    public NhanVien(String hoVaTen, NgaySinh ngaySinh, String diaChi, String gioiTinh, int maNhanVien, double heSoLuong, String donVi) {
        super(hoVaTen, ngaySinh, diaChi, gioiTinh);
        this.maNhanVien = maNhanVien;
        this.heSoLuong = heSoLuong;
        this.donVi = donVi;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                super.toString() +
                "maNhanVien=" + maNhanVien +
                ", heSoLuong=" + heSoLuong +
                ", donVi='" + donVi + '\'' +
                '}';
    }
}
