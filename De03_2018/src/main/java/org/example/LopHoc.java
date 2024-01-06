package org.example;

import java.util.ArrayList;

public class LopHoc {
    private int siSoLop;
    private String tenLop;
    private ArrayList<SinhVien> danhSachSinhVien;

    public LopHoc() {
    }

    public LopHoc(int siSoLop, String tenLop, ArrayList<SinhVien> danhSachSinhVien) {
        this.siSoLop = siSoLop;
        this.tenLop = tenLop;
        this.danhSachSinhVien = danhSachSinhVien;
    }

    public int getSiSoLop() {
        return siSoLop;
    }

    public void setSiSoLop(int siSoLop) {
        this.siSoLop = siSoLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public ArrayList<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }

    public void setDanhSachSinhVien(ArrayList<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }


    @Override
    public String toString() {
        return "LopHoc{" +
                "siSoLop=" + siSoLop +
                ", tenLop='" + tenLop + '\'' +
                ", danhSachSinhVien=" + danhSachSinhVien +
                '}';
    }
}
