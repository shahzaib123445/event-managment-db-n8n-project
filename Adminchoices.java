
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Adminchoices extends JPanel implements ActionListener, Interfaceclass {
    CardLayout cardlayout;
    Graphics g;
    JPanel mainPanel;
    JButton eventManagmentB = new JButton("Event Managment");
    JButton clientDetailsB = new JButton("Client Details");
    JButton feedbackAnalysisB = new JButton("Feedback Analysis");
    // JButton chatbotManagerB = new JButton("Chatbot Manager");
    JButton addandRemoveB = new JButton("Add & Remove");
    Buttonclass buttonObj;

    Adminchoices() {
    }

    Adminchoices(CardLayout cardlayout, JPanel mainPanel) {
        this.setLayout(null);
        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        buttonObj = new Buttonclass();
        buttonObj.backButtonfun(this, this);
        eventManagmentB.setBounds(500, 80, 270, 75);
        clientDetailsB.setBounds(500, 210, 270, 75);
        feedbackAnalysisB.setBounds(500, 330, 270, 75);
        addandRemoveB.setBounds(500, 450, 270, 75);
        this.add(eventManagmentB);
        this.add(clientDetailsB);
        this.add(feedbackAnalysisB);
        this.add(addandRemoveB);
        eventManagmentB.addActionListener(this);
        clientDetailsB.addActionListener(this);
        feedbackAnalysisB.addActionListener(this);
        addandRemoveB.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonObj.backButton) {
            cardlayout.show(mainPanel, "Loginpage");
        }
        if (e.getSource() == eventManagmentB) {
            cardlayout.show(mainPanel, "Eventmanagment");
        }
        if (e.getSource() == clientDetailsB) {
            cardlayout.show(mainPanel, "Clientdetail");
        }

        if (e.getSource() == addandRemoveB) {
            cardlayout.show(mainPanel, "Addandremove");
        }

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());
    }
}
