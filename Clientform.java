import java.awt.*;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.JTextField;

public class Clientform extends JPanel implements ActionListener, Interfaceclass {

    String[] days;
    String[] months = { "Jan", "Feb", "Mar", "Apr", "May",
            "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    String[] years;

    JComboBox<String> day;
    JComboBox<String> month;
    JComboBox<String> year;
    Buttonclass buttonObj;
    Buttonclass listButton;
    CardLayout cardlayout;
    JPanel mainPanel;
    Font labelFont = new Font("Arial", Font.BOLD, 25);
    Font msgFont = new Font("Arial", Font.BOLD, 35);
    Font fieldFont = new Font("Arial", Font.PLAIN, 16);
    Font headingFont = new Font("Arial", Font.ITALIC, 30);
    JLabel warningMsg = new JLabel("Feild is nesessay");
    JRadioButton option1 = new JRadioButton("Male");
    JRadioButton option2 = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup();
    JLabel name = new JLabel("Name");
    JLabel gmail = new JLabel("Email");
    JLabel address = new JLabel("Address");
    JLabel profession = new JLabel("Profession");
    JLabel institute = new JLabel("Institute");
    JLabel dob = new JLabel("DOB");
    JLabel phoneNo = new JLabel("Phone No");
    JLabel expectation = new JLabel("Your Expectation");
    JLabel heading = new JLabel("Client Registration Form");
    JLabel gender = new JLabel("Gender");
    JLabel labelMsg = new JLabel("All Fields are necessary");
    private JTextField nameField = new JTextField();
    private JTextField gmailField = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField professionField = new JTextField();
    private JTextField instituteField = new JTextField();
    private JTextField dobField = new JTextField();
    private JTextField phoneNoField = new JTextField();
    private JTextField expectationField = new JTextField();
    JButton nextButton = new JButton("Next");
    JTextField[] fields = { nameField, gmailField, addressField, professionField,
            instituteField, dobField, phoneNoField, expectationField };
    int y = 30;
    int x = 90;
    int xFeild = 0;

    Clientform() {
    }

    Clientform(CardLayout cardlayout, JPanel mainPanel) {
        this.cardlayout = cardlayout;
        this.mainPanel = mainPanel;
        this.setLayout(null);
        labelMsg.setBounds(850, 510, 2050, 50);
        labelMsg.setFont(msgFont);
        labelMsg.setForeground(Color.YELLOW);
        labelMsg.setVisible(false);
        this.add(labelMsg);
        warningMsg.setForeground(Color.RED);
        buttonObj = new Buttonclass(this, this);
        buttonObj.backButtonfun(this, this);
        buttonObj.resetButtonfun(this, this);
        nextButton.addActionListener(this);
        days = new String[31];
        years = new String[101];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        for (int i = 0; i < 101; i++) {
            years[i] = String.valueOf(2026 - i);
        }
        day = new JComboBox<>(days);
        month = new JComboBox<>(months);
        year = new JComboBox<>(years);

        this.setBackground(Color.BLACK);
        heading.setFont(headingFont);
        heading.setForeground(Color.RED);
        heading.setBounds(470, 10, 500, 70);
        this.add(heading);
        group.add(option1);
        group.add(option2);
        option1.setBounds(240, 440, 100, 50);
        option2.setBounds(340, 440, 100, 50);
        gender.setBounds(90, 440, 180, 50);
        gender.setFont(labelFont);
        nextButton.setBounds(1050, 570, 120, 50);
        gender.setForeground(Color.WHITE);
        this.add(option1);
        this.add(option2);
        this.add(gender);
        this.add(buttonObj.resetButton);
        this.add(nextButton);
        JLabel[] labels = { name, gmail, address, profession, institute, dob, phoneNo, expectation };

        for (int i = 0; i < labels.length; i++) {
            y = y + 80;
            xFeild = x + 150;
            labels[i].setBounds(x, y, 180, 50);
            fields[i].setBounds(xFeild, y, 200, 40);

            // if(feild[i]=)
            if (i > 0 && i % 2 != 0) {
                y = y - 80;
                labels[i].setBounds(x + 500, y, 230, 50);
                if (i != 5) {
                    fields[i].setBounds(xFeild + 600, y, 200, 40);
                }
                if (i == 5) {
                    day.setBounds(xFeild + 600, y, 70, 40);
                    month.setBounds(xFeild + 670, y, 70, 40);
                    year.setBounds(xFeild + 740, y, 70, 40);
                    this.add(day);
                    this.add(month);
                    this.add(year);
                }

            }
            labels[i].setFont(labelFont);
            labels[i].setForeground(Color.WHITE);

            this.add(labels[i]);

            fields[i].setFont(fieldFont);

            this.add(fields[i]);
        }
        listButton = new Buttonclass(instituteField);
        this.add(listButton);

    }

    public String getName() {
        return nameField.getText();
    }

    public String getEmail() {
        return gmailField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getPhone() {
        return phoneNoField.getText();
    }

    public String getInstitute() {
        return instituteField.getText();
    }

    public String getProfession() {
        return professionField.getText();
    }
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            buttonObj.reset(this, group);
            labelMsg.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonObj.backButton) {

            cardlayout.show(mainPanel, "Clientchoices");
        }
        if (e.getSource() == buttonObj.resetButton) {
            buttonObj.reset(this, group);
        }

        if (e.getSource() == nextButton) {
            boolean allFilled = true;

            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getText().trim().isEmpty() && i != 6) {
                    allFilled = false;
                    labelMsg.setVisible(true);
                    break;
                }
            }

            if (allFilled) {
                labelMsg.setVisible(false);
                cardlayout.show(mainPanel, "Termsandcondition");
            }
        }

    }
    public String getGenders() {
        String gender = "";
        if (option1.isSelected()) {
            gender = "Male";
            return gender;
        } else if (option2.isSelected()) {
            gender = "Female";
            return gender;
        }
        return gender;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g, getWidth(), getHeight());

    }
}