package com.example.electricity_bill_management_app.ui.find_customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.electricity_bill_management_app.usecase.findcustomer.BillSearchResponesOutput;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class BillSearchForm {

    private DefaultTableModel tableModel; // Model for the table
    private List<BillSearchResponesOutput> bills; // List of bills

    public void createAndShowGUI(List<BillSearchResponesOutput> bills) {
        this.bills = bills; // Assign the bill list
        JFrame frame = new JFrame("Electricity Bill Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);

        // Create title label
        JLabel titleLabel = new JLabel("DANH SÁCH HÓA ĐƠN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Create columns for JTable
        String[] columns = {
            "STT", "Tên Khách Hàng", "Mã Hóa Đơn", "Ngày Hóa Đơn", "Số Lượng", "Giá"
        };

        // Create model for the table
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        updateTableData(bills); // Update the table with bill data

        // Add table to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create panel for search field and search button
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Tìm");

        // Add ActionListener for the search button
        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText().trim();
            searchBill(searchTerm);
        });

        // Add search field and button to the panel
        searchPanel.add(new JLabel("Mã Hóa Đơn:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Set layout for the frame
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH); // Add title at the top
        frame.add(scrollPane, BorderLayout.CENTER); // Add table in the center
        frame.add(searchPanel, BorderLayout.SOUTH); // Add search panel at the bottom

        // Display the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateTableData(List<BillSearchResponesOutput> bills) {
        // Clear old data from the table
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Add bills to the table
        for (int i = 0; i < bills.size(); i++) {
            BillSearchResponesOutput bill = bills.get(i);
            Object[] row = {
                i + 1,
                bill.getName(),
                bill.getBill(), // Use billID here
                sdf.format(bill.getBillDate()),
                bill.getQuantity(),
                bill.getUnitPrice()
            };
            tableModel.addRow(row);
        }
    }

    private void searchBill(String searchTerm) {
        // Clear old data from the table
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Search bills by billID
        for (int i = 0; i < bills.size(); i++) {
            BillSearchResponesOutput bill = bills.get(i);
            if (bill.getBill().contains(searchTerm)) { // Search based on billID
                Object[] row = {
                    i + 1,
                    bill.getName(),
                    bill.getBill(), // Display the billID
                    sdf.format(bill.getBillDate()),
                    bill.getQuantity(),
                    bill.getUnitPrice()
                };
                tableModel.addRow(row);
            }
        }

        // Show a message if no bill is found
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào với mã: " + searchTerm, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
