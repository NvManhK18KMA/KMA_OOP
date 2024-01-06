package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentForm extends JFrame {

    private JTextField siSo;
    private JTextField tenLop;
    private JTextField maSinhVien;
    private JTextField tenSinhVien;
    private JTextField diemQuaTrinh;
    private JTextField diemHocPhan;

    private StudentTable studentTable;


    public StudentForm() {
        LopHoc lopHoc = new LopHoc();
        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();


        // Thiết lập cửa sổ
        setTitle("Student Information Form");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo panel chứa các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        // Thêm các thành phần vào panel
        panel.add(new JLabel("Sĩ Số:"));
        siSo = new JTextField();
        panel.add(siSo);

        panel.add(new JLabel("Tên Lớp:"));
        tenLop = new JTextField();
        panel.add(tenLop);

        panel.add(new JLabel("Mã Sinh Viên"));
        maSinhVien = new JTextField();
        panel.add(maSinhVien);

        panel.add(new JLabel("Tên Sinh Viên"));
        tenSinhVien = new JTextField();
        panel.add(tenSinhVien);

        panel.add(new JLabel("Điểm Quá Trình"));
        diemQuaTrinh = new JTextField();
        panel.add(diemQuaTrinh);
        panel.add(new JLabel("Điểm Học Phần"));
        diemHocPhan = new JTextField();
        panel.add(diemHocPhan);

        JButton themSinhVien = new JButton("Thêm Sinh Viên");
        panel.add(themSinhVien);

        JButton hoanThanh = new JButton("Lưu Lớp Học");
        panel.add(hoanThanh);

        JButton hienThiDanhSach = new JButton("Hiển Thị Danh Sách Sinh Viên");
        panel.add(hienThiDanhSach);
        JButton thoat = new JButton("Thoát");
        panel.add(thoat);


        themSinhVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleThemSinhVien(danhSachSinhVien);
            }
        });

        hoanThanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLuuLopHoc(lopHoc, danhSachSinhVien);
            }
        });

        hienThiDanhSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleHienThiDanhSach(lopHoc , danhSachSinhVien);
            }
        });

        thoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleThoat();
            }
            
        });

        // Thêm panel vào cửa sổ
        add(panel);
        // Hiển thị cửa sổ
        setVisible(true);
    }

    private void handleThoat() {
        System.exit(0);
    }

    private void handleLuuLopHoc(LopHoc lopHoc , ArrayList<SinhVien> danhSachSinhVien) {
        int siSoInt = Integer.parseInt(siSo.getText());
        String tenLopText = tenLop.getText();
        lopHoc.setSiSoLop(siSoInt);
        lopHoc.setTenLop(tenLopText);
        lopHoc.setDanhSachSinhVien(danhSachSinhVien);
        JOptionPane.showMessageDialog(null, "Lưu thành công!\n"+ "Lớp "+lopHoc.getTenLop() + "\n"+ "Sĩ Số "+lopHoc.getSiSoLop(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    private void handleThemSinhVien(ArrayList<SinhVien> danhSachSinhVien) {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setMaSinhVien(maSinhVien.getText());
        sinhVien.setHoTen(tenSinhVien.getText());
        double diemQuaTrinhValue = 0.0;
        try {
            diemQuaTrinhValue = Double.parseDouble(diemQuaTrinh.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ cho điểm quá trình. Đã đặt giá trị mặc định là 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        double diemHocPhanValue = 0.0;
        try {
            diemHocPhanValue = Double.parseDouble(diemHocPhan.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ cho điểm học phần. Đã đặt giá trị mặc định là 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        sinhVien.setDiemHocPhan(diemHocPhanValue);
        sinhVien.setDiemQuaTrinh(diemQuaTrinhValue);

        System.out.println("SinhVien{" +
                "hoTen='" + sinhVien.getHoTen() + '\'' +
                ", maSinhVien='" + sinhVien.getMaSinhVien() + '\'' +
                ", diemHocPhan=" + sinhVien.getDiemHocPhan() +
                ", diemQuaTrinh=" + sinhVien.getDiemQuaTrinh() +
                '}');
        JOptionPane.showMessageDialog(null, "Thêm Sinh Viên Thành Công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        danhSachSinhVien.add(sinhVien);
        maSinhVien.setText("");
        tenSinhVien.setText("");
        diemHocPhan.setText("");
        diemQuaTrinh.setText("");
    }

    private void handleHienThiDanhSach(LopHoc lopHoc , ArrayList<SinhVien> danhSachSinhVien){
        new StudentTable(lopHoc , danhSachSinhVien);
    }
}
