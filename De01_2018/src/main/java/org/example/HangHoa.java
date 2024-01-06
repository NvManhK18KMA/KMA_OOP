package org.example;

import java.io.Serializable;

public class HangHoa implements Serializable {
    private int maHang;
    private String tenHang;
    private double giaBan;

    public HangHoa(int maHang, String tenHang, double giaBan) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.giaBan = giaBan;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "HangHoa{" +
                "maHang=" + maHang +
                ", tenHang='" + tenHang + '\'' +
                ", giaBan=" + giaBan +
                '}';
    }
}
