import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Termsandcondition extends JPanel implements ActionListener, Interfaceclass {
    Clientform clientform;
    CardLayout cardlayout;
    JPanel mainPanel;
    JRadioButton acceptButton = new JRadioButton("I Accept the Terms and Conditions");
    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Back");

    Termsandcondition() {
    }

    Termsandcondition(CardLayout cardlayout, JPanel mainPanel, Clientform clientform) {
        this.clientform = clientform;
        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        this.setLayout(null);
        JLabel heading = new JLabel("Terms and Conditions");
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        heading.setBounds(500, 10, 500, 50);
        this.add(heading);
        JTextArea termsText = new JTextArea();
        termsText.setText(
                "1. Acceptance of Terms\n" +
                        "By registering, you agree to these terms and conditions.\n\n" +
                        "2. User Responsibilities\n" +
                        "You are responsible for providing accurate information.\n" +
                        "You must not misuse the event management system.\n\n" +
                        "3. Privacy Policy\n" +
                        "Your personal data including name, email, address, and phone number\n" +
                        "will be stored securely and will not be shared with third parties.\n\n" +
                        "4. Event Participation\n" +
                        "Registration does not guarantee event participation.\n" +
                        "The organizers reserve the right to cancel or modify events.\n\n" +
                        "5. Code of Conduct\n" +
                        "All participants must behave respectfully.\n" +
                        "Any misconduct may result in removal from the event.\n\n" +
                        "6. Liability\n" +
                        "The organizers are not liable for any loss or damage\n" +
                        "during the event.\n\n" +
                        "7. Changes to Terms\n" +
                        "These terms may be updated at any time without prior notice.\n\n" +
                        "8. Contact\n" +
                        "For any queries, contact the event management team.");
        termsText.setFont(new Font("Arial", Font.PLAIN, 16));
        termsText.setEditable(false);
        termsText.setLineWrap(true);
        termsText.setWrapStyleWord(true);
        termsText.setBackground(new Color(30, 30, 30));
        termsText.setForeground(Color.WHITE);
        termsText.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(termsText);
        scrollPane.setBounds(200, 70, 900, 450);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // smooth scrolling
        this.add(scrollPane);
        acceptButton.setFont(new Font("Arial", Font.BOLD, 18));
        acceptButton.setForeground(Color.WHITE);
        acceptButton.setOpaque(false);
        acceptButton.setBounds(200, 540, 500, 40);
        this.add(acceptButton);
        backButton.setBounds(200, 600, 120, 45);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(this);
        this.add(backButton);
        submitButton.setBounds(980, 600, 120, 45);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.addActionListener(this);
        this.add(submitButton);

    }

    public void sentData() {
        Database db = new Database();
        Connection conn = db.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO `event` (email, name, address, cell_phone, gender, institute, profession) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, clientform.getEmail());
        ps.setString(2, clientform.getName());
        ps.setString(3, clientform.getAddress());
        ps.setString(4, clientform.getPhone());
        ps.setString(5, clientform.getGenders());
        ps.setString(6, clientform.getInstitute());
        ps.setString(7, clientform.getProfession());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            cardlayout.show(mainPanel, "Clientform");
        }
        if (e.getSource() == submitButton) {
            if (acceptButton.isSelected()) {
                sentData();
                int result = JOptionPane.showConfirmDialog(this, "Submitted Successfully!", "Success",
                        JOptionPane.DEFAULT_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    cardlayout.show(mainPanel, "PAGE1");
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Please accept the Terms and Conditions to proceed.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());
    }
}