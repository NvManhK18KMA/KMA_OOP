package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableForm extends JFrame {
    private JTable jTable;
    public TableForm(ArrayList<DienThoai> danhSachDienThoai){
        setTitle("Danh Sách Điện Thoại");
        setSize(900 ,450);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã Hàng");
        defaultTableModel.addColumn("Tên Hàng");
        defaultTableModel.addColumn("Giá Bán");
        defaultTableModel.addColumn("Nhà Sản Xuất");
        defaultTableModel.addColumn("Dung Lượng");
        defaultTableModel.addColumn("Màu Sắc");

        for (DienThoai dienThoai: danhSachDienThoai) {
            Object[] rowData = new Object[]{
                    dienThoai.getMaHang(),
                    dienThoai.getTenHang(),
                    dienThoai.getGiaBan(),
                    dienThoai.getNhaSanXuan(),
                    dienThoai.getDungLuong(),
                    dienThoai.getMauSac()
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
