package org.example;

import java.io.Serializable;

public class DienThoai extends HangHoa implements Serializable {
    private String nhaSanXuan;
    private int dungLuong;
    private String mauSac;

    public DienThoai(int maHang, String tenHang, double giaBan, String nhaSanXuan, int dungLuong, String mauSac) {
        super(maHang, tenHang, giaBan);
        this.nhaSanXuan = nhaSanXuan;
        this.dungLuong = dungLuong;
        this.mauSac = mauSac;
    }

    public String getNhaSanXuan() {
        return nhaSanXuan;
    }

    public void setNhaSanXuan(String nhaSanXuan) {
        this.nhaSanXuan = nhaSanXuan;
    }

    public int getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(int dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                super.toString()+
                "nhaSanXuan='" + nhaSanXuan + '\'' +
                ", dungLuong=" + dungLuong +
                ", mauSac='" + mauSac + '\'' +
                '}';
    }
}
