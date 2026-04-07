import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

// Strategy Interface
interface PaymentStrategy {
    String pay(double amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    public String pay(double amount) {
        return "Payment of Rs. " + amount + " successful via Credit Card";
    }
}

class UPIPayment implements PaymentStrategy {
    public String pay(double amount) {
        return "Payment of Rs. " + amount + " successful via UPI";
    }
}

class WalletPayment implements PaymentStrategy {
    public String pay(double amount) {
        return "Payment of Rs. " + amount + " successful via Wallet";
    }
}

// Context Class
class PaymentGateway {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public String processPayment(double amount) {
        return strategy.pay(amount);
    }
}

// Main GUI Class
public class PaymentGatewayGUI extends JFrame implements ActionListener {

    private JComboBox<String> paymentMethods;
    private JTextField amountField;
    private JButton payButton;
    private JTextArea resultArea;
    private PaymentGateway gateway;

    public PaymentGatewayGUI() {
        gateway = new PaymentGateway();

        setTitle("Payment Gateway Simulation");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(245, 248, 255));

        // Title
        JLabel title = new JLabel("Payment Gateway Simulation");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(110, 20, 350, 30);
        mainPanel.add(title);

        // Payment Method Label
        JLabel methodLabel = new JLabel("Select Payment Method:");
        methodLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        methodLabel.setBounds(50, 90, 180, 25);
        mainPanel.add(methodLabel);

        // Dropdown
        paymentMethods = new JComboBox<>(
                new String[]{"Credit Card", "UPI", "Wallet"});
        paymentMethods.setBounds(250, 90, 200, 30);
        mainPanel.add(paymentMethods);

        // Amount Label
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        amountLabel.setBounds(50, 140, 180, 25);
        mainPanel.add(amountLabel);

        // Amount Field
        amountField = new JTextField();
        amountField.setBounds(250, 140, 200, 30);
        amountField.setBorder(new LineBorder(Color.GRAY, 1));
        mainPanel.add(amountField);

        // Button
        payButton = new JButton("Process Payment");
        payButton.setBounds(170, 200, 180, 40);
        payButton.setFont(new Font("Arial", Font.BOLD, 14));
        payButton.addActionListener(this);
        mainPanel.add(payButton);

        // Result Area
        resultArea = new JTextArea();
        resultArea.setBounds(70, 270, 400, 60);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 15));
        resultArea.setBorder(new TitledBorder("Payment Status"));
        mainPanel.add(resultArea);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String method = (String) paymentMethods.getSelectedItem();

            if (method.equals("Credit Card")) {
                gateway.setStrategy(new CreditCardPayment());
            } else if (method.equals("UPI")) {
                gateway.setStrategy(new UPIPayment());
            } else {
                gateway.setStrategy(new WalletPayment());
            }

            String result = gateway.processPayment(amount);
            resultArea.setText(result);

            JOptionPane.showMessageDialog(
                    this,
                    result,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid amount",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new PaymentGatewayGUI();
    }
}