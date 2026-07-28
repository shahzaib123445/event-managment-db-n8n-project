
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Clientdetail extends JPanel implements ActionListener, Interfaceclass {
    CardLayout cardlayout;
    Buttonclass buttonObj;
    JPanel mainPanel;
    String[] cols = { "Name", "Email", "Address", "Phone", "Gender", "Institute", "Profession" };
    DefaultTableModel model = new DefaultTableModel(cols, 0);
    JTable table = new JTable(model);
    JScrollPane scroll = new JScrollPane(table);

    Clientdetail() {
    }

    Clientdetail(CardLayout cardlayout, JPanel mainPanel) {
        // this.setLayout(null);
        this.setLayout(new BorderLayout());
        scroll.setPreferredSize(new Dimension(1200, 600));
        buttonObj = new Buttonclass();
        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        buttonObj.backButtonfun(this, this);
        this.add(scroll, BorderLayout.CENTER);
    }

    public void getData() {
        model.setRowCount(0);
        try {
            Database db = new Database();
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM event");
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("cell_phone");
                String gender = rs.getString("gender");
                String institute = rs.getString("institute");
                String profession = rs.getString("profession");
                model.addRow(new Object[] { name, email, address, phone, gender, institute, profession });
            }
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
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());
    }
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            getData();
        }
    }

}