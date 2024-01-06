package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;

public class TableForm extends JFrame {
    private JTable jTable;
    public TableForm(ArrayList<NhanVien> danhSachNhanVien){
        setTitle("Danh Sách Cầu Thủ");
        setSize(900 ,450);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Họ Tên");
        defaultTableModel.addColumn("Ngày Sinh");
        defaultTableModel.addColumn("Địa Chỉ");
        defaultTableModel.addColumn("Giới Tính");
        defaultTableModel.addColumn("Mã Nhân Viên");
        defaultTableModel.addColumn("Hệ Số Lương");
        defaultTableModel.addColumn("Đơn Vị");

        for (NhanVien nhanVien: danhSachNhanVien) {
            Object[] rowData = new Object[]{
                    nhanVien.getHoVaTen(),
                    nhanVien.getNgaySinh().toString(),
                    nhanVien.getDiaChi(),
                    nhanVien.getGioiTinh(),
                    nhanVien.getMaNhanVien(),
                    nhanVien.getHeSoLuong(),
                    nhanVien.getDonVi()
            };
            defaultTableModel.addRow(rowData);
        }
        jTable = new JTable(defaultTableModel);

        // Tạo JScrollPane để hỗ trợ cuộn nếu có quá nhiều dữ liệu
        JScrollPane scrollPane = new JScrollPane(jTable);

        // Thêm JScrollPane vào frame
        add(scrollPane);

        // Hiển thị frame
        setLocationRelativeTo(null); // Hiển thị frame ở giữa màn hình
        setVisible(true);
    }
}
