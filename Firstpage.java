
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Firstpage extends JPanel implements ActionListener, Interfaceclass {
    Font customFont = new Font("BOLD", Font.ITALIC, 35);
    JButton clientButton = new JButton("Client");
    JButton adminButton = new JButton("Admin");
    CardLayout cardlayout;
    JPanel mainPanel;

    Firstpage() {
    }

    Firstpage(CardLayout cardlayout, JPanel mainPanel) {
        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        this.setLayout(null);
        clientButton.setBounds(450, 160, 250, 100);
        clientButton.setFocusable(false);
        clientButton.setBackground(Color.lightGray);
        adminButton.setBackground(Color.lightGray);
        adminButton.setBounds(450, 360, 250, 100);
        adminButton.setFocusable(false);
        adminButton.setFont(customFont);
        clientButton.setFont(customFont);
        this.add(clientButton);
        this.add(adminButton);
        clientButton.addActionListener(this);
        adminButton.addActionListener(this);
        this.setBackground(Color.BLACK);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            cardlayout.show(mainPanel, "Loginpage");
        }
        if (e.getSource() == clientButton) {
            cardlayout.show(mainPanel, "Clientchoices");
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());
    }
}
