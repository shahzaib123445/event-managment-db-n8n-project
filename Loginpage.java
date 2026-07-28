
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginpage extends JPanel implements ActionListener, Interfaceclass {
    Buttonclass obj1;
    Font customFont = new Font("BOLD", Font.PLAIN, 25);
   private String userID = "CIS@25-29";
    private String password = "1234567";
 
    JLabel userId;
    JLabel userPassword;
    JLabel message;
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIdFeild = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    CardLayout cardlayout;
    JPanel mainPanel;

    Loginpage() {
    };

    Loginpage(CardLayout cardlayout, JPanel mainPanel) {
        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        this.setLayout(null);
        obj1 = new Buttonclass();
        obj1.backButtonfun(this, this);
        userId = new JLabel("User ID");
        userPassword = new JLabel("Password");
        userId.setBounds(450, 160, 100, 100);
        userPassword.setBounds(450, 240, 200, 100);
        userId.setFont(customFont);
        userPassword.setFont(customFont);
        userIdFeild.setBounds(600, 180, 200, 60);
        userPasswordField.setBounds(600, 260, 200, 60);
        userIdFeild.setFont(customFont);
        userPasswordField.setFont(customFont);
        loginButton.setBounds(530, 370, 120, 50);
        loginButton.setFocusable(false);
        resetButton.setBounds(670, 370, 120, 50);
        resetButton.setFocusable(false);
        message = new JLabel("Login Fail");
        message.setForeground(Color.RED);
        message.setBounds(530, 450, 120, 50);
        message.setVisible(false);
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        this.add(userId);
        this.add(message);
        this.add(userPassword);
        this.add(userIdFeild);
        this.add(userPasswordField);
        this.add(loginButton);
        this.add(resetButton);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            userIdFeild.setText("");
            userPasswordField.setText("");
            message.setVisible(false);

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String enterId = userIdFeild.getText();
            String enterPassword = new String(userPasswordField.getPassword());
            if (userID.equals(enterId) && password.equals(enterPassword)) {
                cardlayout.show(mainPanel, "Adminchoices");
            } else {
                message.setVisible(true);
            }
        }
        if (e.getSource() == resetButton) {
            userIdFeild.setText("");
            userPasswordField.setText("");
            message.setVisible(false);
        }
        if (e.getSource() == obj1.backButton) {
            cardlayout.show(mainPanel, "PAGE1");
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());
    }
}
