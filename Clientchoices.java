
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clientchoices extends JPanel implements ActionListener, Interfaceclass {
    CardLayout cardlayout;
    JPanel mainPanel;
    JLabel timeStatus;
    JLabel timeBar;
    JButton participantB = new JButton("Participant");
    JButton attendeeB = new JButton("Attendee");
    JButton vipAttendeeB = new JButton("VIP Attendee");
    Buttonclass buttonObj;

    Clientchoices() {
    }

    Clientchoices(CardLayout cardlayout, JPanel mainPanel) {

        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        this.setLayout(null);
        buttonObj = new Buttonclass();
        buttonObj.backButtonfun(this, this);
        participantB.setBounds(500, 90, 290, 85);
        attendeeB.setBounds(500, 240, 290, 85);
        vipAttendeeB.setBounds(500, 400, 290, 85);
        this.add(participantB);
        this.add(attendeeB);
        this.add(vipAttendeeB);
        participantB.addActionListener(this);
        attendeeB.addActionListener(this);
        vipAttendeeB.addActionListener(this);
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonObj.backButton) {

            cardlayout.show(mainPanel, "PAGE1");
        }

        if (e.getSource() == participantB) {
            cardlayout.show(mainPanel, "Clientform");
        }
        if (e.getSource() == attendeeB) {
            cardlayout.show(mainPanel, "Clientform");
        }
        if (e.getSource() == vipAttendeeB) {
            cardlayout.show(mainPanel, "Clientform");
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());
    }
}
