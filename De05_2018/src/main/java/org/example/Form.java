package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Form extends JFrame {
    private JTextField hoVaTen;
    private JTextField ngay;
    private JTextField thang;
    private JTextField nam;
    private JTextField diaChi;
    private JTextField gioiTinh;
    private JTextField maNhanVien;
    private JTextField heSoLuong;
    private JTextField donVi;

    private ArrayList<NhanVien> danhSachNhanVien;

    public  Form(){
        danhSachNhanVien = new ArrayList<>();
        setTitle("Form Thông Tin");
        setSize(900, 450);
        JPanel panel = new JPanel(new GridLayout(9,2));

        JLabel hoVaTenLabel = new JLabel("Họ Và Tên");
        hoVaTen = new JTextField();
        JLabel ngayLabel = new JLabel("Ngày Sinh");
        ngay = new JTextField();
        thang = new JTextField();
        nam = new JTextField();
        JPanel panelNgaySinh = new JPanel(new GridLayout(1,3));
        panelNgaySinh.add(ngay); panelNgaySinh.add(thang); panelNgaySinh.add(nam);
        JLabel diaChilabel = new JLabel("Địa Chỉ");
        diaChi = new JTextField();
        JLabel gioiTinhLabel = new JLabel("Giới Tính");
        gioiTinh = new JTextField();
        JLabel maNhanVienLabel = new JLabel("Mã Nhân Viên");
        maNhanVien = new JTextField();
        JLabel heSoLuongLabel = new JLabel("Hệ Số Lương");
        heSoLuong = new JTextField();
        JLabel donViLabel = new JLabel("Đơn Vị");
        donVi = new JTextField();








        panel.add(hoVaTenLabel); panel.add(hoVaTen);
        panel.add(ngayLabel); panel.add(panelNgaySinh);
        panel.add(diaChilabel); panel.add(diaChi);
        panel.add(gioiTinhLabel); panel.add(gioiTinh);
        panel.add(maNhanVienLabel); panel.add(maNhanVien);
        panel.add(heSoLuongLabel); panel.add(heSoLuong);
        panel.add(donViLabel); panel.add(donVi);


        JButton luuFile = new JButton("Lưu File");
        JButton docFile = new JButton("Đọc File");
        JButton them = new JButton("Thêm Nhân Viên");
        JButton hienThi = new JButton("Hiển Thị Danh Sách");

        panel.add(luuFile); panel.add(docFile); panel.add(them); panel.add(hienThi);


        luuFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLuuFile();
            }
        });

        docFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDocFile();
            }
        });

        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleThem();
            }
        });

        hienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleHienThi();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void handleDocFile() {
        ArrayList<NhanVien> danhSachNhanVienFile = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("danh_sach_nhan_vien.dat")))) {
            while (true) {
                try {
                    NhanVien nhanVien = (NhanVien) objectInputStream.readObject();
                    danhSachNhanVienFile.add(nhanVien);
                } catch (ClassNotFoundException e) {
                    System.err.println("Lỗi khi đọc đối tượng từ tệp tin: " + e.getMessage());
                    break; // Đọc hết file
                }
            }
            System.out.println("Đọc tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp tin: " + e.getMessage());
        }
        new TableForm(danhSachNhanVienFile);
    }

    private void handleLuuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("danh_sach_nhan_vien.txt", true))) {
            for (NhanVien nhanVien : danhSachNhanVien) {
                writer.write(nhanVien.getHoVaTen()+"$"+nhanVien.getNgaySinh().getNgay()+"$"+nhanVien.getNgaySinh().getThang()+"$"+nhanVien.getNgaySinh().getNam()+"$"+nhanVien.getDiaChi()+"$"+nhanVien.getGioiTinh()+"$"+nhanVien.getMaNhanVien()+"$"+nhanVien.getHeSoLuong()+"$"+nhanVien.getDonVi());
                writer.newLine();
            }
            System.out.println("Thông tin  được ghi vào tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi thông tin  vào tệp tin: " + e.getMessage());
        }


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("danh_sach_nhan_vien.dat")))) {
            for (NhanVien nhanVien : danhSachNhanVien) {
                objectOutputStream.writeObject(nhanVien);
            }
            System.out.println("Thông tin  đã được ghi vào tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi thông tin  vào tệp tin: " + e.getMessage());
        }
    }

    private void handleThem() {
        String hoVaTenValue = hoVaTen.getText();
        int ngayValue = Integer.parseInt(ngay.getText());
        int thangValue = Integer.parseInt(thang.getText());
        int namValue = Integer.parseInt(nam.getText());
        NgaySinh ngaySinhValue = new NgaySinh(ngayValue,thangValue,namValue);
        String diaChiValue = diaChi.getText();
        String gioiTinhValue = gioiTinh.getText();
        int maNhanVienValue = Integer.parseInt(maNhanVien.getText());
        Double heSoLuongValue = Double.parseDouble(heSoLuong.getText());
        String donViValue = donVi.getText();


        NhanVien nhanVien = new NhanVien(hoVaTenValue , ngaySinhValue , diaChiValue , gioiTinhValue, maNhanVienValue , heSoLuongValue ,donViValue);
        System.out.println(nhanVien.toString());
        danhSachNhanVien.add(nhanVien);
    }
    private void handleHienThi(){
        new TableForm(danhSachNhanVien);
    }
}
