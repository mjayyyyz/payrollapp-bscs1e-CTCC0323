import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class PayrollSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Payroll System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false); // Make window size fixed
        frame.setLayout(new GridBagLayout()); // Center all elements

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(760, 560)); // Fix panel size within the window

        // ID and Employee fields
        JLabel idLabel = new JLabel("ID No.");
        idLabel.setBounds(10, 10, 80, 25);
        panel.add(idLabel);

        JTextField idField = new JTextField(20);
        idField.setBounds(100, 10, 160, 25);
        panel.add(idField);

        JLabel empLabel = new JLabel("Employee");
        empLabel.setBounds(10, 40, 80, 25);
        panel.add(empLabel);

        JTextField empField = new JTextField(20);
        empField.setBounds(100, 40, 160, 25);
        panel.add(empField);

        JLabel employeeRateLabel = new JLabel("Employee Rate");
        employeeRateLabel.setBounds(300, 10, 100, 25);
        panel.add(employeeRateLabel);

        JComboBox<String> employeeRateDropdown = new JComboBox<>(new String[]{"Crew - 62.50", "Crew Chief - 63.50"});
        employeeRateDropdown.setBounds(400, 10, 160, 25);
        panel.add(employeeRateDropdown);

        // Regular & Over Time Pay Panel
        JPanel regularPanel = new JPanel();
        regularPanel.setBorder(BorderFactory.createTitledBorder("Regular & Over Time Pay"));
        regularPanel.setBounds(10, 80, 370, 200);
        regularPanel.setLayout(null);
        panel.add(regularPanel);

        JLabel rateLabel = new JLabel("Rate");
        rateLabel.setBounds(10, 20, 80, 25);
        regularPanel.add(rateLabel);

        JTextField rateField = new JTextField(20);
        rateField.setBounds(150, 20, 160, 25);
        regularPanel.add(rateField);

        JLabel noOfDaysLabel = new JLabel("No of Days");
        noOfDaysLabel.setBounds(10, 50, 80, 25);
        regularPanel.add(noOfDaysLabel);

        JTextField noOfDaysField = new JTextField(20);
        noOfDaysField.setBounds(150, 50, 160, 25);
        regularPanel.add(noOfDaysField);

        JLabel regularOTLabel = new JLabel("Regular OT");
        regularOTLabel.setBounds(10, 80, 80, 25);
        regularPanel.add(regularOTLabel);

        JTextField regularOTField = new JTextField(20);
        regularOTField.setBounds(150, 80, 160, 25);
        regularPanel.add(regularOTField);

        JLabel holidayLabel = new JLabel("Holiday");
        holidayLabel.setBounds(10, 110, 80, 25);
        regularPanel.add(holidayLabel);

        JTextField holidayField = new JTextField(20);
        holidayField.setBounds(150, 110, 160, 25);
        regularPanel.add(holidayField);

        // Employee Contribution Panel
        JPanel empContributionPanel = new JPanel();
        empContributionPanel.setBorder(BorderFactory.createTitledBorder("Employee Contribution"));
        empContributionPanel.setBounds(400, 80, 370, 200);
        empContributionPanel.setLayout(null);
        panel.add(empContributionPanel);

        JLabel sssLabel = new JLabel("SSS");
        sssLabel.setBounds(10, 20, 80, 25);
        empContributionPanel.add(sssLabel);

        JTextField sssField = new JTextField(20);
        sssField.setBounds(150, 20, 160, 25);
        empContributionPanel.add(sssField);

        JLabel philHealthLabel = new JLabel("Phil-Health");
        philHealthLabel.setBounds(10, 50, 80, 25);
        empContributionPanel.add(philHealthLabel);

        JTextField philHealthField = new JTextField(20);
        philHealthField.setBounds(150, 50, 160, 25);
        empContributionPanel.add(philHealthField);

        JLabel pagibigLabel = new JLabel("Pagibig");
        pagibigLabel.setBounds(10, 80, 80, 25);
        empContributionPanel.add(pagibigLabel);

        JTextField pagibigField = new JTextField(20);
        pagibigField.setBounds(150, 80, 160, 25);
        empContributionPanel.add(pagibigField);

        JLabel otherDeductionLabel = new JLabel("Other Deduction");
        otherDeductionLabel.setBounds(10, 110, 120, 25);
        empContributionPanel.add(otherDeductionLabel);

        JTextField otherDeductionField = new JTextField(20);
        otherDeductionField.setBounds(150, 110, 160, 25);
        empContributionPanel.add(otherDeductionField);

        JLabel totalDeductionLabel = new JLabel("Total Deduction");
        totalDeductionLabel.setBounds(10, 140, 120, 25);
        empContributionPanel.add(totalDeductionLabel);

        JTextField totalDeductionField = new JTextField(20);
        totalDeductionField.setBounds(150, 140, 160, 25);
        totalDeductionField.setEditable(false); // Make non-editable
        empContributionPanel.add(totalDeductionField);

        JLabel netPayLabel = new JLabel("Net Pay");
        netPayLabel.setBounds(10, 170, 120, 25);
        empContributionPanel.add(netPayLabel);

        JTextField netPayField = new JTextField(20);
        netPayField.setBounds(150, 170, 160, 25);
        netPayField.setEditable(false); // Make non-editable
        empContributionPanel.add(netPayField);

        // Separate panel for Gross Pay
        JPanel grossPayPanel = new JPanel();
        grossPayPanel.setBorder(BorderFactory.createTitledBorder("Gross Pay"));
        grossPayPanel.setBounds(10, 290, 760, 100);
        grossPayPanel.setLayout(null);
        panel.add(grossPayPanel);

        JLabel grossPayLabel = new JLabel("Gross Pay");
        grossPayLabel.setBounds(10, 20, 120, 25);
        grossPayPanel.add(grossPayLabel);

        JTextField grossPayField = new JTextField(20);
        grossPayField.setBounds(150, 20, 160, 25);
        grossPayField.setEditable(false); // Make non-editable
        grossPayPanel.add(grossPayField);

        // Capture Button
        JButton captureButton = new JButton("Capture");
        captureButton.setBounds(350, 400, 100, 25);
        panel.add(captureButton);

        // Update rate field based on selected employee rate
        employeeRateDropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) employeeRateDropdown.getSelectedItem();
                    if (selectedItem != null) {
                        if (selectedItem.startsWith("Crew - 62.50")) {
                            rateField.setText("62.50");
                        } else if (selectedItem.startsWith("Crew Chief - 63.50")) {
                            rateField.setText("63.50");
                        }
                    }
                }
            }
        });

        // Add action listener to the capture button
        captureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double rate = Double.parseDouble(rateField.getText());
                    double noOfDays = Double.parseDouble(noOfDaysField.getText());
                    double regularOT = Double.parseDouble(regularOTField.getText());
                    double holiday = Double.parseDouble(holidayField.getText());

                    double grossPay = rate * noOfDays + regularOT + holiday;
                    grossPayField.setText(String.valueOf(grossPay));

                    double sss = grossPay * 0.02;
                    sssField.setText(String.valueOf(sss));

                    double philHealth = grossPay * 0.05;
                    philHealthField.setText(String.valueOf(philHealth));

                    double pagibig = grossPay * 0.01;
                    pagibigField.setText(String.valueOf(pagibig));

                    double totalDeduction = sss + philHealth + pagibig + Double.parseDouble(otherDeductionField.getText());
                    totalDeductionField.setText(String.valueOf(totalDeduction));

                    double netPay = grossPay - totalDeduction;
                    netPayField.setText(String.valueOf(netPay));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
                }
            }
        });

        frame.add(panel, new GridBagConstraints());
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);
    }
}
