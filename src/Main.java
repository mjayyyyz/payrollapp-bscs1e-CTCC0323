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

        // Pay period dropdown
        JLabel payPeriodLabel = new JLabel("Pay Period");
        payPeriodLabel.setBounds(300, 40, 100, 25);
        panel.add(payPeriodLabel);

        JComboBox<String> payPeriodDropdown = new JComboBox<>(new String[]{"June 1-15", "June 16-30"});
        payPeriodDropdown.setBounds(400, 40, 160, 25);
        panel.add(payPeriodDropdown);

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

        // Add logic to show/hide deduction fields based on pay period selection
        payPeriodDropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    boolean isJune16to30 = "June 16-30".equals(payPeriodDropdown.getSelectedItem());
                    sssLabel.setVisible(isJune16to30);
                    sssField.setVisible(isJune16to30);
                    philHealthLabel.setVisible(isJune16to30);
                    philHealthField.setVisible(isJune16to30);
                    pagibigLabel.setVisible(isJune16to30);
                    pagibigField.setVisible(isJune16to30);
                    otherDeductionLabel.setVisible(isJune16to30);
                    otherDeductionField.setVisible(isJune16to30);
                    totalDeductionLabel.setVisible(isJune16to30);
                    totalDeductionField.setVisible(isJune16to30);
                    netPayLabel.setVisible(isJune16to30);
                    netPayField.setVisible(isJune16to30);
                }
            }
        });

        // Initially hide the deduction fields if "June 1-15" is selected by default
        if (!"June 16-30".equals(payPeriodDropdown.getSelectedItem())) {
            sssLabel.setVisible(false);
            sssField.setVisible(false);
            philHealthLabel.setVisible(false);
            philHealthField.setVisible(false);
            pagibigLabel.setVisible(false);
            pagibigField.setVisible(false);
            otherDeductionLabel.setVisible(false);
            otherDeductionField.setVisible(false);
            totalDeductionLabel.setVisible(false);
            totalDeductionField.setVisible(false);
            netPayLabel.setVisible(false);
            netPayField.setVisible(false);
        }

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

                    if ("June 16-30".equals(payPeriodDropdown.getSelectedItem())) {
                        double sss = grossPay * 0.02;
                        sssField.setText(String.valueOf(sss));

                        double philHealth = grossPay * 0.05;
                        philHealthField.setText(String.valueOf(philHealth));

                        double pagibig = grossPay * 0.01;
                        pagibigField.setText(String.valueOf(pagibig));

                        double totalDeduction = sss + philHealth + pagibig;
                        if (!otherDeductionField.getText().isEmpty()) {
                            totalDeduction += Double.parseDouble(otherDeductionField.getText());
                        }
                        totalDeductionField.setText(String.valueOf(totalDeduction));

                        double netPay = grossPay - totalDeduction;
                        netPayField.setText(String.valueOf(netPay));
                    } else {
                        sssField.setText("");
                        philHealthField.setText("");
                        pagibigField.setText("");
                        otherDeductionField.setText("");
                        totalDeductionField.setText("");
                        netPayField.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(panel, new GridBagConstraints());
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);
    }
}
