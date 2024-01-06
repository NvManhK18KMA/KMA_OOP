package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Form extends JFrame {
    private JFrame jFrame;
    private JTextField id;
    private JTextField tenCauThu;
    private JTextField namSinh;
    private JPanel viTri;

    private JTextField jTextFieldSearch;

    private ButtonGroup buttonGroup;
    private ArrayList<CauThu> danhSachCauThu;
    public Form(){
        ArrayList<CauThu> danhSachCauThu = new ArrayList<>();
        this.danhSachCauThu = new ArrayList<>();

        setTitle("Nhập Thông Tin Cầu Thủ");
        setSize(900,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,2));

        Label label1 = new Label("ID Cầu Thủ");
        Label label2 = new Label("Tên Cầu Thủ");
        Label label3 = new Label("Năm Sinh");
        Label label4 = new Label("Vị Trí");

        id = new JTextField();
        tenCauThu = new JTextField();
        namSinh = new JTextField();

        viTri = new JPanel(new GridLayout(1,4));
        JRadioButton viTriRadio1 = new JRadioButton(ViTri.ThuMon.name());
        JRadioButton viTriRadio2= new JRadioButton(ViTri.HauVe.name());
        JRadioButton viTriRadio3 = new JRadioButton(ViTri.TienVe.name());
        JRadioButton viTriRadio4 = new JRadioButton(ViTri.TienDao.name());

        buttonGroup = new ButtonGroup();
        buttonGroup.add(viTriRadio1);
        buttonGroup.add(viTriRadio2);
        buttonGroup.add(viTriRadio3);
        buttonGroup.add(viTriRadio4);

        viTri.add(viTriRadio1);
        viTri.add(viTriRadio2);
        viTri.add(viTriRadio3);
        viTri.add(viTriRadio4);



        panel.add(label1); panel.add(id);
        panel.add(label2); panel.add(tenCauThu);
        panel.add(label3); panel.add(namSinh);
        panel.add(label4); panel.add(viTri);


        JButton themCauThu = new JButton("Thêm Cầu Thủ");
        JButton hienThiDanhSach = new JButton("Hiển Thị Danh Sách");
        JButton ghiFile = new JButton("Xuất File Danh Sách");
        JButton docFile = new JButton("Đọc File Danh Sách");
        panel.add(themCauThu);
        panel.add(hienThiDanhSach);
        panel.add(ghiFile);
        panel.add(docFile);

        jTextFieldSearch = new JTextField();
        JButton buttonSearch = new JButton("Tìm Kiếm Theo Tên : ");
        panel.add(buttonSearch);
        panel.add(jTextFieldSearch);

        add(panel);
        setVisible(true);





        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearch();
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



        hienThiDanhSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleHienThiDanhSach();
            }
        });


        themCauThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String viTri = "";
                if(viTriRadio1.isSelected()) {
                    viTri = viTriRadio1.getText();
                }else  if(viTriRadio2.isSelected()){
                    viTri = viTriRadio2.getText();
                }else  if(viTriRadio3.isSelected()){
                    viTri = viTriRadio3.getText();
                }else  if(viTriRadio4.isSelected()){
                    viTri = viTriRadio4.getText();
                } else {
                    viTri = "DuBi";
                }
                handleThemCauThu(viTri);
            }
        });
    }

    private void handleSearch() {
        String tenCauThuSearch = jTextFieldSearch.getText();
        ArrayList<CauThu> cauThus = new ArrayList<>();
        for (CauThu ct: danhSachCauThu) {
            if(ct.getTenCauThu().equals(tenCauThuSearch)){
                cauThus.add(ct);
            }
        }
        new TableForm(cauThus);
    }

    private void handleGhiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("danh_sach.txt", true))) {
            for (CauThu ct : danhSachCauThu) {
                writer.write(ct.toString());
                writer.newLine();
            }
            System.out.println("Thông tin cầu thủ đã được ghi vào tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi thông tin cầu thủ vào tệp tin: " + e.getMessage());
        }


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("danh_sach.dat")))) {
            for (CauThu ct : danhSachCauThu) {
                objectOutputStream.writeObject(ct);
            }
            System.out.println("Thông tin cầu thủ đã được ghi vào tệp tin thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi thông tin cầu thủ vào tệp tin: " + e.getMessage());
        }
    }


    private void handleDocFile() {
        ArrayList<CauThu> danhSachCauThuFile = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("danh_sach.dat")))) {
            while (true) {
                try {
                    CauThu cauThu = (CauThu) objectInputStream.readObject();
                    danhSachCauThuFile.add(cauThu);
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


    private void handleHienThiDanhSach() {
        new TableForm(danhSachCauThu);
    }

    private void handleThemCauThu(String viTriText) {
        int idValue = Integer.parseInt(id.getText());
        String tenCauThuValue = tenCauThu.getText();
        int namSinhValue = Integer.parseInt(namSinh.getText());
        CauThu cauThu = new CauThu();
        cauThu.setTenCauThu(tenCauThuValue);
        cauThu.setId(idValue);
        cauThu.setNamSinh(namSinhValue);
        if(viTriText.equals(ViTri.ThuMon.name())){
            cauThu.setViTri(ViTri.ThuMon);
        } else if(viTriText.equals(ViTri.HauVe.name())){
            cauThu.setViTri(ViTri.HauVe);
        } else if(viTriText.equals(ViTri.TienVe.name())){
            cauThu.setViTri(ViTri.TienVe);
        } else if(viTriText.equals(ViTri.TienDao.name())){
            cauThu.setViTri(ViTri.TienDao);
        }
        System.out.println(cauThu);
        danhSachCauThu.add(cauThu);

    }
}
