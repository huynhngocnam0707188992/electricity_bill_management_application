package com.example.electricity_bill_management_app.ui.find_customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.example.electricity_bill_management_app.usecase.SearchBillOutputDTO;

public class FindCustomerForm {
    private JTextField searchField; // Trường nhập liệu cho tìm kiếm
    private JButton searchButton; // Nút tìm kiếm

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Tìm kiếm Hóa đơn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Thiết lập layout
        frame.setLayout(new GridLayout(3, 1));

        // Nhãn và trường nhập liệu cho mã hóa đơn
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(new JLabel("Nhập mã hóa đơn:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        
        // Nút tìm kiếm
        searchButton = new JButton("Tìm kiếm");
        searchPanel.add(searchButton);

        // Thêm hành động cho nút tìm kiếm
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String billID = searchField.getText();
                // Thực hiện tìm kiếm hóa đơn
                performSearch(billID);
            }
        });

        frame.add(searchPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void performSearch(String billID) {
        // Logic để tìm kiếm hóa đơn theo billID
        // Gọi tới controller để thực hiện tìm kiếm
    }

    public void displayResults(List<SearchBillOutputDTO> bills) {
        // Hiển thị kết quả tìm kiếm
        JFrame resultFrame = new JFrame("Kết quả tìm kiếm");
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setSize(600, 400);

        String[] columns = {
                "Mã hóa đơn", "Tên khách hàng", "Ngày hóa đơn", "Số lượng", "Đơn giá", "Thành tiền"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Thêm dữ liệu hóa đơn vào bảng
        for (SearchBillOutputDTO bill : bills) {
            Object[] row = {
                    bill.getBillID(),
                    bill.getCustomerName(),
                    bill.getBillDate(),
                    bill.getQuantity(),
                    bill.getUnitPrice(),
                    bill.getTotalPrice()
            };
            tableModel.addRow(row);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        resultFrame.add(scrollPane);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
    }
}
