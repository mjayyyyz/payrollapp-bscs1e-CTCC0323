import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

class PayrollSystem {
    public static void main(String[] args) {
        showLoginForm();
    }

    private static void showLoginForm() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 200);
        loginFrame.setResizable(false); // Make window size fixed
        loginFrame.setLayout(new GridBagLayout());
        loginFrame.setLocationRelativeTo(null); // Center the window on the screen

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setPreferredSize(new Dimension(330, 150));

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(userLabel);

        JTextField userField = new JTextField(20);
        userField.setBounds(100, 20, 160, 25);
        loginPanel.add(userField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(10, 60, 80, 25);
        loginPanel.add(passLabel);

        JPasswordField passField = new JPasswordField(20);
        passField.setBounds(100, 60, 160, 25);
        loginPanel.add(passField);

        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(100, 90, 160, 25);
        loginPanel.add(showPasswordCheckBox);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 120, 100, 25);
        loginPanel.add(loginButton);

        showPasswordCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                passField.setEchoChar((char) 0);
            } else {
                passField.setEchoChar('*');
            }
        });

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Check username and password (for demo purposes, we just check for non-empty values)
            if (!username.isEmpty() && !password.isEmpty()) {
                loginFrame.dispose();
                showPayrollSystem();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginFrame.add(loginPanel, new GridBagConstraints());
        loginFrame.setVisible(true);
    }

    private static void showPayrollSystem() {
        JFrame frame = new JFrame("Payroll System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false); // Make window size fixed
        frame.setLayout(new GridBagLayout()); // Center all elements

        // Create a menubar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem logoutMenuItem = new JMenuItem("Logout");
        menu.add(logoutMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(760, 430)); // Fix panel size within the window

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

        JComboBox<String> employeeRateDropdown = new JComboBox<>(new String[]{"Regular Crew - 62.50", "Crew Chief - 63.50"});
        employeeRateDropdown.setBounds(400, 10, 160, 25);
        panel.add(employeeRateDropdown);

        // Pay period dropdown
        JLabel payPeriodLabel = new JLabel("Pay Period");
        payPeriodLabel.setBounds(300, 40, 100, 25);
        panel.add(payPeriodLabel);

        JComboBox<String> payPeriodDropdown = new JComboBox<>(new String[]{"1-15", "16-30"});
        payPeriodDropdown.setBounds(400, 40, 160, 25);
        panel.add(payPeriodDropdown);

        // Regular & Over Time Pay Panel
        JPanel regularPanel = new JPanel();
        regularPanel.setBorder(BorderFactory.createTitledBorder("Regular & Over Time Pay"));
        regularPanel.setBounds(10, 80, 370, 90);
        regularPanel.setLayout(null);
        panel.add(regularPanel);

        JLabel rateLabel = new JLabel("Rate");
        rateLabel.setBounds(10, 20, 80, 25);
        regularPanel.add(rateLabel);

        JTextField rateField = new JTextField(20);
        rateField.setBounds(150, 20, 160, 25);
        regularPanel.add(rateField);

        JLabel daysOfPresentLabel = new JLabel("Days of Present");
        daysOfPresentLabel.setBounds(10, 50, 100, 25);
        regularPanel.add(daysOfPresentLabel);

        JTextField noOfDaysField = new JTextField(20);
        noOfDaysField.setBounds(150, 50, 160, 25);
        regularPanel.add(noOfDaysField);

        // Separate panel for Hours Work Panel
        JPanel hoursPanel = new JPanel();
        hoursPanel.setBorder(BorderFactory.createTitledBorder("Hours Base Calculation"));
        hoursPanel.setBounds(10, 170, 370, 90);
        hoursPanel.setLayout(null);
        panel.add(hoursPanel);

        JLabel noOfHoursLabel = new JLabel("No. of Hours");
        noOfHoursLabel.setBounds(10, 20, 80, 25);
        hoursPanel.add(noOfHoursLabel);

        JTextField noOfHoursField = new JTextField(20);
        noOfHoursField.setBounds(150, 20, 160, 25);
        hoursPanel.add(noOfHoursField);

        JLabel regularOTLabel = new JLabel("Over Time");
        regularOTLabel.setBounds(10, 50, 90, 25);
        hoursPanel.add(regularOTLabel);

        JTextField regularOTField = new JTextField(20);
        regularOTField.setBounds(150, 50, 160, 25);
        hoursPanel.add(regularOTField);

        // Separate panel for Holiday Panel
        JPanel holidayPanel = new JPanel();
        holidayPanel.setBorder(BorderFactory.createTitledBorder("Holidays"));
        holidayPanel.setBounds(10, 270, 370, 90);
        holidayPanel.setLayout(null);
        panel.add(holidayPanel);

        JLabel holidayLabel = new JLabel("Holiday 30%");
        holidayLabel.setBounds(10, 20, 80, 25);
        holidayPanel.add(holidayLabel);

        JTextField holidayField = new JTextField(20);
        holidayField.setBounds(150, 20, 160, 25);
        holidayPanel.add(holidayField);

        JLabel specialHolidayLabel = new JLabel("Special Holidays");
        specialHolidayLabel.setBounds(10, 50, 120, 25);
        holidayPanel.add(specialHolidayLabel);

        JTextField specialHolidayField = new JTextField(20);
        specialHolidayField.setBounds(150, 50, 160, 25);
        holidayPanel.add(specialHolidayField);

        // Separate panel for Employee Contribution Panel
        JPanel empContributionPanel = new JPanel();
        empContributionPanel.setBorder(BorderFactory.createTitledBorder("Employee Contribution"));
        empContributionPanel.setBounds(400, 80, 340, 175);
        empContributionPanel.setLayout(null);
        panel.add(empContributionPanel);

        JLabel sssLabel = new JLabel("SSS");
        sssLabel.setBounds(10, 20, 80, 25);
        empContributionPanel.add(sssLabel);

        JTextField sssField = new JTextField(20);
        sssField.setBounds(150, 20, 160, 25);
        sssField.setEditable(false); // Make non-editable
        empContributionPanel.add(sssField);

        JLabel philHealthLabel = new JLabel("Phil-Health");
        philHealthLabel.setBounds(10, 50, 80, 25);
        empContributionPanel.add(philHealthLabel);

        JTextField philHealthField = new JTextField(20);
        philHealthField.setBounds(150, 50, 160, 25);
        philHealthField.setEditable(false); // Make non-editable
        empContributionPanel.add(philHealthField);

        JLabel pagibigLabel = new JLabel("Pagibig");
        pagibigLabel.setBounds(10, 80, 80, 25);
        empContributionPanel.add(pagibigLabel);

        JTextField pagibigField = new JTextField(20);
        pagibigField.setBounds(150, 80, 160, 25);
        pagibigField.setEditable(false); // Make non-editable
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

        // Separate panel for Total Income
        JPanel totalIncomePanel = new JPanel();
        totalIncomePanel.setBorder(BorderFactory.createTitledBorder("Total Income"));
        totalIncomePanel.setBounds(400, 260, 340, 90);
        totalIncomePanel.setLayout(null);
        panel.add(totalIncomePanel);

        JLabel grossIncomeLabel = new JLabel("Gross Income");
        grossIncomeLabel.setBounds(10, 20, 120, 25);
        totalIncomePanel.add(grossIncomeLabel);

        JTextField grossIncomeField = new JTextField(20);
        grossIncomeField.setBounds(150, 20, 160, 25);
        grossIncomeField.setEditable(false); // Make non-editable
        totalIncomePanel.add(grossIncomeField);

        JLabel netPayLabel = new JLabel("Net Pay");
        netPayLabel.setBounds(10, 50, 120, 25);
        totalIncomePanel.add(netPayLabel);

        JTextField netPayField = new JTextField(20);
        netPayField.setBounds(150, 50, 160, 25);
        netPayField.setEditable(false); // Make non-editable
        totalIncomePanel.add(netPayField);

        // for Calculate Button
        JButton printButton = new JButton("Calculate");
        printButton.setBounds(628, 353, 110, 25);
        panel.add(printButton);

        // Add action listener for the logout menu item
        logoutMenuItem.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                frame.dispose();
                showLoginForm();
            }
        });


        // Add logic to show/hide deduction fields based on pay period selection
        payPeriodDropdown.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                boolean is16to30 = "16-30".equals(payPeriodDropdown.getSelectedItem());
                sssLabel.setVisible(is16to30);
                sssField.setVisible(is16to30);
                philHealthLabel.setVisible(is16to30);
                philHealthField.setVisible(is16to30);
                pagibigLabel.setVisible(is16to30);
                pagibigField.setVisible(is16to30);
                otherDeductionLabel.setVisible(is16to30);
                otherDeductionField.setVisible(is16to30);
                totalDeductionLabel.setVisible(is16to30);
                totalDeductionField.setVisible(is16to30);
            }
        });

        // Initially hide the deduction fields if "1-15" is selected by default
        if (!"16-30".equals(payPeriodDropdown.getSelectedItem())) {
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
        }

        // Update rate field based on selected employee rate
        employeeRateDropdown.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) employeeRateDropdown.getSelectedItem();
                if (selectedItem != null) {
                    if (selectedItem.startsWith("Regular Crew - 62.50")) {
                        rateField.setText("62.50");
                    } else if (selectedItem.startsWith("Crew Chief - 63.50")) {
                        rateField.setText("63.50");
                    }
                }
            }
        });

        // Add action listener to the capture button
        printButton.addActionListener(e -> {
            try {
                BigDecimal rate = new BigDecimal(rateField.getText());
                BigDecimal noOfDays = new BigDecimal(noOfDaysField.getText());
                BigDecimal noOfHours = new BigDecimal(noOfHoursField.getText());
                BigDecimal regularOT = new BigDecimal(regularOTField.getText().isEmpty() ? "0" : regularOTField.getText());
                BigDecimal holiday = new BigDecimal(holidayField.getText().isEmpty() ? "0" : holidayField.getText());
                BigDecimal specialHoliday = new BigDecimal(specialHolidayField.getText().isEmpty() ? "0" : specialHolidayField.getText());

                BigDecimal dayHoursPay = rate.multiply(noOfDays).multiply(noOfHours);
                BigDecimal regularOTPay = regularOT.multiply(rate).multiply(new BigDecimal("0.25"));
                BigDecimal holidayPay = holiday.multiply(rate).multiply(new BigDecimal("0.3"));
                BigDecimal specialHolidayPay = specialHoliday.multiply(rate).multiply(new BigDecimal("2"));

                BigDecimal grossPay = dayHoursPay.add(regularOT).add(holidayPay).add(specialHolidayPay);
                grossIncomeField.setText(grossPay.setScale(2, RoundingMode.HALF_UP).toString());

                if ("16-30".equals(payPeriodDropdown.getSelectedItem())) {
                    BigDecimal sss = grossPay.multiply(new BigDecimal("0.045")).setScale(2, RoundingMode.HALF_UP);
                    sssField.setText(sss.toString());

                    BigDecimal philHealth = grossPay.multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
                    philHealthField.setText(philHealth.toString());

                    BigDecimal pagibig = grossPay.multiply(new BigDecimal("0.02")).setScale(2, RoundingMode.HALF_UP);
                    pagibigField.setText(pagibig.toString());

                    BigDecimal otherDeduction = new BigDecimal(otherDeductionField.getText().isEmpty() ? "0" : otherDeductionField.getText());

                    BigDecimal totalDeduction = sss.add(philHealth).add(pagibig).add(otherDeduction);
                    totalDeductionField.setText(totalDeduction.setScale(2, RoundingMode.HALF_UP).toString());

                    BigDecimal netPay = grossPay.subtract(totalDeduction);
                    netPayField.setText(netPay.setScale(2, RoundingMode.HALF_UP).toString());
                } else {
                    sssField.setText("");
                    philHealthField.setText("");
                    pagibigField.setText("");
                    otherDeductionField.setText("");
                    totalDeductionField.setText("");
                    netPayField.setText("");
                }

                // Create and display the payslip window
                JFrame payslipFrame = new JFrame("Payslip");
                payslipFrame.setSize(230, 350);
                payslipFrame.setLayout(new GridBagLayout());
                payslipFrame.setResizable(false);
                JPanel payslipPanel = new JPanel();
                payslipPanel.setLayout(new BoxLayout(payslipPanel, BoxLayout.Y_AXIS));

                // Calculate total hours present
                BigDecimal totalHours = noOfDays.multiply(noOfHours);
                payslipPanel.add(new JLabel("Employee No: " + idField.getText()));
                payslipPanel.add(new JLabel("Employee Name: " + empField.getText()));
                payslipPanel.add(new JLabel(" "));
                payslipPanel.add(new JLabel("No. of Days Present: " + noOfDaysField.getText()));
                payslipPanel.add(new JLabel("Total Hours Present: " + totalHours.setScale(2, RoundingMode.HALF_UP)));
                payslipPanel.add(new JLabel("Rate per Hour: " + rateField.getText()));
                payslipPanel.add(new JLabel(" "));
                payslipPanel.add(new JLabel("Gross Income: " + grossIncomeField.getText()));
                payslipPanel.add(new JLabel("Net Pay: " + netPayField.getText()));

                if ("16-30".equals(payPeriodDropdown.getSelectedItem())) {
                    payslipPanel.add(new JLabel(" "));
                    payslipPanel.add(new JLabel("Deductions:"));
                    payslipPanel.add(new JLabel("SSS: " + sssField.getText()));
                    payslipPanel.add(new JLabel("Phil-Health: " + philHealthField.getText()));
                    payslipPanel.add(new JLabel("Pagibig: " + pagibigField.getText()));
                    payslipPanel.add(new JLabel("Other Deduction: " + otherDeductionField.getText()));
                    payslipPanel.add(new JLabel(" "));
                    payslipPanel.add(new JLabel("Total Deduction: " + totalDeductionField.getText()));
                    payslipPanel.add(new JLabel("Net Pay: " + netPayField.getText()));
                }

                payslipFrame.add(payslipPanel, new GridBagConstraints());
                payslipFrame.setLocationRelativeTo(frame); // Center relative to main frame
                payslipFrame.setVisible(true);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(panel, new GridBagConstraints());
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);
    }
}
