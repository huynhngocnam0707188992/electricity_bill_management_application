package com.example.electricity_bill_management_app.ui.delete_bill;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.example.electricity_bill_management_app.usecase.delete_bill.DeleteBillOutputDTO;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class DeleteBillForm {

    private DefaultTableModel tableModel; // Để lưu model của bảng
    private List<DeleteBillOutputDTO> bills; // Danh sách hóa đơn gốc

    public void createAndShowGUI(List<DeleteBillOutputDTO> bills) {
        this.bills = bills; // Gán danh sách hóa đơn
        JFrame frame = new JFrame("Electricity Bill Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);

        // Tạo title label
        JLabel titleLabel = new JLabel("DANH SÁCH HÓA ĐƠN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Tạo cột cho JTable
        String[] columns = {
            "STT", "Tên Khách Hàng", "Hóa Đơn", "Ngày Thanh Toán", "Số Lượng", "Giá"
        };

        // Tạo model cho bảng
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        updateTableData(bills); // Cập nhật bảng với dữ liệu hóa đơn

        // Thêm bảng vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo panel cho ô tìm kiếm và nút xóa
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Tìm");
        JButton deleteButton = new JButton("Xóa Hóa Đơn");

        // Thêm ActionListener cho nút tìm kiếm
        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText().trim();
            searchBill(searchTerm);
        });

        // Thêm ActionListener cho nút xóa
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                // Logic xóa hóa đơn từ danh sách
                bills.remove(selectedRow); // Xóa hóa đơn từ danh sách gốc
                updateTableData(bills); // Cập nhật bảng
            } else {
                JOptionPane.showMessageDialog(frame, "Vui lòng chọn hóa đơn để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Thêm ô tìm kiếm và nút vào panel
        searchPanel.add(new JLabel("Mã Hóa Đơn:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(deleteButton);

        // Thiết lập layout cho frame
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH); // Thêm tiêu đề ở trên cùng
        frame.add(scrollPane, BorderLayout.CENTER); // Thêm bảng vào giữa
        frame.add(searchPanel, BorderLayout.SOUTH); // Thêm panel tìm kiếm và nút xóa ở dưới cùng

        // Hiển thị frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateTableData(List<DeleteBillOutputDTO> bills) {
        // Xóa tất cả dữ liệu cũ trong bảng
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Thêm hóa đơn mới vào bảng
        for (int i = 0; i < bills.size(); i++) {
            DeleteBillOutputDTO bill = bills.get(i);
            Object[] row = {
                i + 1,
                bill.getName(),
                bill.getBill(),
                sdf.format(bill.getBillDate()),
                bill.getQuantity(),
                bill.getUnitPrice()
            };
            tableModel.addRow(row);
        }
    }

    private void searchBill(String searchTerm) {
        // Xóa tất cả dữ liệu cũ trong bảng
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Tìm hóa đơn theo mã
        for (int i = 0; i < bills.size(); i++) {
            DeleteBillOutputDTO bill = bills.get(i);
            if (bill.getBill().contains(searchTerm)) { // Thay đổi logic tìm kiếm nếu cần
                Object[] row = {
                    i + 1,
                    bill.getName(),
                    bill.getBill(),
                    sdf.format(bill.getBillDate()),
                    bill.getQuantity(),
                    bill.getUnitPrice()
                };
                tableModel.addRow(row);
            }
        }

        // Thông báo nếu không tìm thấy hóa đơn nào
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào với mã: " + searchTerm, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
