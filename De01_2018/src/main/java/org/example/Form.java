package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Form extends JFrame {
    private JTextField maHang;
    private JTextField tenHang;
    private JTextField giaBan;
    private JTextField nhaSanXuat;
    private JTextField dungLuong;
    private JTextField mauSac;
    private ArrayList<DienThoai> danhSachDienThoai;


    public Form(){
        danhSachDienThoai = new ArrayList<>();
        setTitle("Nhập Thông Tin Điện Thoại");
        setSize(900,450);
        JPanel panel = new JPanel(new GridLayout(8,2));

        maHang = new JTextField();
        JLabel maHangJlabel = new JLabel("Mã Hàng");
        panel.add(maHangJlabel);
        panel.add(maHang);

        tenHang = new JTextField();
        JLabel tenHangJlabel = new JLabel("Tên Hàng");
        panel.add(tenHangJlabel);
        panel.add(tenHang);

        giaBan = new JTextField();
        JLabel giaBanJlabel = new JLabel("Giá Bán");
        panel.add(giaBanJlabel);
        panel.add(giaBan);

        nhaSanXuat = new JTextField();
        JLabel nhaSanXuatJlabel = new JLabel("Nhà Sản Xuất");
        panel.add(nhaSanXuatJlabel);
        panel.add(nhaSanXuat);

        dungLuong = new JTextField();
        JLabel dungLuongJlabel = new JLabel("Dung Lượng");
        panel.add(dungLuongJlabel);
        panel.add(dungLuong);

        mauSac = new JTextField();
        JLabel mauSacJlabel = new JLabel("Màu Sắc");
        panel.add(mauSacJlabel);
        panel.add(mauSac);

        JButton them = new JButton("Thêm Điện Thoại");
        JButton hienThi = new JButton("Hiển Thị Danh Sách");
        JButton ghiFile = new JButton("Ghi File");
        JButton docFile = new JButton("Đọc File Điện Thoại");

        panel.add(them); panel.add(hienThi);
        panel.add(ghiFile); panel.add(docFile);

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
        ghiFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGhiFile();

            }
        });
        docFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDocFile();
            }
        });








        add(panel);
        setVisible(true);
    }

    private void handleHienThi() {
        for (DienThoai dt: danhSachDienThoai) {
            System.out.println(dt.toString());
             new TableForm(danhSachDienThoai);
        }
    }

    private void handleThem() {
        int maHangValue = Integer.parseInt(maHang.getText());
        String tenHangValue = tenHang.getText();
        Double giaBanValue = Double.parseDouble(giaBan.getText());
        String nhaSanXuatValue = nhaSanXuat.getText();
        int dungLuongValue = Integer.parseInt(dungLuong.getText());
        String mauSacValue = mauSac.getText();

        DienThoai dienThoai = new DienThoai(maHangValue , tenHangValue , giaBanValue , nhaSanXuatValue , dungLuongValue , mauSacValue);
        System.out.println(dienThoai.toString());
        danhSachDienThoai.add(dienThoai);

    }

    private void handleGhiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("danh_sach_dien_thoai.txt", true))) {
            for (DienThoai dienThoai : danhSachDienThoai) {
                writer.write(dienThoai.toString());
                writer.newLine();
            }
            System.out.println("Thông tin cầu thủ đã được ghi vào tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi thông tin cầu thủ vào tệp tin: " + e.getMessage());
        }


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("danh_sach_dien_thoai.dat")))) {
            for (DienThoai dienThoai : danhSachDienThoai) {
                objectOutputStream.writeObject(dienThoai);
            }
            System.out.println("Thông tin cầu thủ đã được ghi vào tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi thông tin cầu thủ vào tệp tin: " + e.getMessage());
        }
    }


    private void handleDocFile() {
        ArrayList<DienThoai> danhSachCauThuFile = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("danh_sach_dien_thoai.dat")))) {
            while (true) {
                try {
                    DienThoai dienThoai = (DienThoai) objectInputStream.readObject();
                    danhSachCauThuFile.add(dienThoai);
                } catch (ClassNotFoundException e) {
                    System.err.println("Lỗi khi đọc đối tượng từ tệp tin: " + e.getMessage());
                    break; // Đọc hết file
                }
            }
            System.out.println("Đọc tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp tin: " + e.getMessage());
        }
        new TableForm(danhSachCauThuFile);
    }

}
