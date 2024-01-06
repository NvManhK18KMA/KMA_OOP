package org.example;

import java.io.Serializable;

public class CauThu implements Serializable {
    private int id;
    private String tenCauThu;
    private int namSinh;
    private ViTri viTri;

    public CauThu(int id, String tenCauThu, int namSinh, ViTri viTri) {
        this.id = id;
        this.tenCauThu = tenCauThu;
        this.namSinh = namSinh;
        this.viTri = viTri;
    }

    public CauThu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCauThu() {
        return tenCauThu;
    }

    public void setTenCauThu(String tenCauThu) {
        this.tenCauThu = tenCauThu;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public ViTri getViTri() {
        return viTri;
    }

    public void setViTri(ViTri viTri) {
        this.viTri = viTri;
    }

    @Override
    public String toString() {
        return "CauThu{" +
                "id=" + id +
                ", tenCauThu='" + tenCauThu + '\'' +
                ", namSinh=" + namSinh +
                ", viTri=" + viTri +
                '}';
    }
}
