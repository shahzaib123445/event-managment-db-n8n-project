
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Cardlayoutsclass extends JFrame {
  CardLayout cardlayout = new CardLayout();
  JPanel mainPanel = new JPanel(cardlayout);

  Cardlayoutsclass() {
    this.setDefaultCloseOperation(Cardlayoutsclass.EXIT_ON_CLOSE);
    this.setTitle("Event Managment System");

    this.setBounds(0, 0, 1920, 1080);
    Clientform clientform = new Clientform(cardlayout, mainPanel);

    mainPanel.add(new Firstpage(cardlayout, mainPanel), "PAGE1");
    mainPanel.add(new Loginpage(cardlayout, mainPanel), "Loginpage");
    mainPanel.add(new Clientchoices(cardlayout, mainPanel), "Clientchoices");
    mainPanel.add(new Adminchoices(cardlayout, mainPanel), "Adminchoices");
    mainPanel.add(new Eventmanagment(cardlayout, mainPanel), "Eventmanagment");
    mainPanel.add(new Clientdetail(cardlayout, mainPanel), "Clientdetail");
    mainPanel.add(clientform, "Clientform");
    mainPanel.add(new Termsandcondition(cardlayout, mainPanel, clientform), "Termsandcondition");
    this.add(mainPanel);
    this.setVisible(true);
  }

}
