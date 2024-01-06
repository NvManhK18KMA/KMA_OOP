package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentTable extends JFrame {

    private JTable table;

    public StudentTable(LopHoc lopHoc, ArrayList<SinhVien> danhSachSinhVien) {
        // Khởi tạo frame
        setTitle("Danh sách sinh viên " +lopHoc.getTenLop());
        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sinh viên");
        model.addColumn("Tên sinh viên");
        model.addColumn("Tuổi");
        model.addColumn("Điểm");
        model.addColumn("Điểm Trung Bình");

        // Thêm dữ liệu từ danhSachSinhVien vào DefaultTableModel
        for (SinhVien sv : danhSachSinhVien) {
            Object[] rowData = new Object[]{sv.getMaSinhVien(), sv.getHoTen(), sv.getDiemQuaTrinh(), sv.getDiemHocPhan(), sv.tinhDiemTrungBinh()};
            model.addRow(rowData);
        }

        // Tạo JTable với DefaultTableModel
        table = new JTable(model);

        // Tạo JScrollPane để hỗ trợ cuộn nếu có quá nhiều dữ liệu
        JScrollPane scrollPane = new JScrollPane(table);

        // Thêm JScrollPane vào frame
        add(scrollPane);

        // Hiển thị frame
        setLocationRelativeTo(null); // Hiển thị frame ở giữa màn hình
        setVisible(true);
    }
}
