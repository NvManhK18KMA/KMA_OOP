package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;

public class TableForm extends JFrame {
    private JTable jTable;
    public TableForm(ArrayList<CauThu> danhSachCauThu){
        setTitle("Danh Sách Cầu Thủ");
        setSize(900 ,450);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Họ Và Tên");
        defaultTableModel.addColumn("Năm Sinh");
        defaultTableModel.addColumn("Vị Trí");
        for (CauThu ct: danhSachCauThu) {
            Object[] rowData = new Object[]{ct.getId() , ct.getTenCauThu() , ct.getNamSinh() , ct.getViTri()};
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
