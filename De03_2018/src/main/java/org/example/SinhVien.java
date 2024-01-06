package org.example;

public class SinhVien {
    private String hoTen;
    private String maSinhVien;
    private double diemHocPhan;
    private double diemQuaTrinh;

    public SinhVien(String hoTen, String maSinhVien, double diemHocPhan, double diemQuaTrinh) {
        this.hoTen = hoTen;
        this.maSinhVien = maSinhVien;
        this.diemHocPhan = diemHocPhan;
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public SinhVien() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public double getDiemHocPhan() {
        return diemHocPhan;
    }

    public void setDiemHocPhan(double diemHocPhan) {
        this.diemHocPhan = diemHocPhan;
    }

    public double getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(double diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "hoTen='" + hoTen + '\'' +
                ", maSinhVien='" + maSinhVien + '\'' +
                ", diemHocPhan=" + diemHocPhan +
                ", diemQuaTrinh=" + diemQuaTrinh +
                '}';
    }

    public double tinhDiemTrungBinh(){
        return  (this.diemHocPhan*0.3 + this.diemHocPhan*0.7);
    }
}
