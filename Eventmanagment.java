import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class Eventmanagment extends JPanel implements ActionListener, Interfaceclass {
    Buttonclass buttonObj;
    JButton submitButton = new JButton("Submitt");
    CardLayout cardlayout;
    JPanel mainPanel;
    JLabel location = new JLabel("Location");
    JLabel startTime = new JLabel("Start Time");
    JLabel endTime = new JLabel("End Time");
    JLabel limit = new JLabel("Limit of People");
    JLabel deadline = new JLabel("Deadline of Registration");
    JTextField locationField = new JTextField();
    JTextField startFeild = new JTextField();
    JTextField endFeild = new JTextField();
    JTextField limitFeild = new JTextField();
    JTextField deadlineFeild = new JTextField();

    Eventmanagment() {
    }

    Eventmanagment(CardLayout cardlayout, JPanel mainPanel) {
        this.setLayout(null);
        buttonObj = new Buttonclass();
        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        buttonObj.backButtonfun(this, this);
        submitButton.setBounds(1050, 570, 120, 50);
        submitButton.addActionListener(this);
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 20));
        formPanel.setBounds(300, 150, 600, 400);
        formPanel.setOpaque(false);
        Font f = new Font("Arial", Font.BOLD, 20);
        location.setFont(f);
        location.setForeground(Color.WHITE);
        startTime.setFont(f);
        startTime.setForeground(Color.WHITE);
        endTime.setFont(f);
        endTime.setForeground(Color.WHITE);
        limit.setFont(f);
        limit.setForeground(Color.WHITE);
        deadline.setFont(f);
        deadline.setForeground(Color.WHITE);
        formPanel.add(location);
        formPanel.add(locationField);
        formPanel.add(startTime);
        formPanel.add(startFeild);
        formPanel.add(endTime);
        formPanel.add(endFeild);
        formPanel.add(limit);
        formPanel.add(limitFeild);
        formPanel.add(deadline);
        formPanel.add(deadlineFeild);
        this.add(submitButton);
        this.add(formPanel);
        this.add(buttonObj.backButton);
    }

    public void sentData() {
        Database db = new Database();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO `event_management`(location, start_time, end_time, `limit_people`, deadline) VALUES (?,?,?,?,?)");
            ps.setString(1, locationField.getText());
            ps.setString(2, startFeild.getText());
            ps.setString(3, endFeild.getText());
            ps.setString(4, limitFeild.getText());
            ps.setString(5, deadlineFeild.getText());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonObj.backButton) {
            cardlayout.show(mainPanel, "Adminchoices");
        }
        if (e.getSource() == submitButton) {
            sentData();
            int result = JOptionPane.showConfirmDialog(this, "UPDATE SUCESSFULLY", "UPDATE",
                    JOptionPane.DEFAULT_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                cardlayout.show(mainPanel, "Adminchoices");
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());
    }
}