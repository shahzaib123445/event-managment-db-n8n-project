
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Component;
import java.awt.Dimension;

public class Buttonclass extends JPanel implements DocumentListener {
    Buttonclass() {
    }

String[] institutes = {
    // Original Items
    "PIEAS Institute of Engineering",
    "Punjab University",
    "FAST National University",
    "Pakistan Institute of Development Economics",
    "Pakistan Institute of Fashion and Design",
    "PMAS Arid Agriculture University Rawalpindi",
    "Peshawar University",
    "Poonch University",
    "Preston University",
    "Punjab Tianjin University of Technology",
    "Punjab University of Technology",
    "Pakistan Military Academy",
    "Pakistan Naval Academy",
    "Peoples University of Medical and Health Sciences for Women"
};
    Buttonclass buttonObj;
    JTextField instituteFeild;
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    JLabel labelMsg = new JLabel("Feilds is necessary");
    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> list = new JList<>(listModel);
    JPopupMenu popup = new JPopupMenu();
    JScrollPane scroll = new JScrollPane(list);
    Buttonclass(JTextField instituteFeild) {
        this.instituteFeild = instituteFeild;
        scroll.setPreferredSize(new Dimension(200, 100));
        popup.add(scroll);
        popup.setInvoker(instituteFeild);
        instituteFeild.getDocument().addDocumentListener(this);
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String selected = list.getSelectedValue();
                if (selected != null) {
                    instituteFeild.setText(selected);
                    popup.setVisible(false);
                }
            }
        });
    }

    Buttonclass(JPanel panel, ActionListener listner) {

    }
    public void backButtonfun(JPanel panel, ActionListener listner) {
        backButton.setBounds(90, 570, 120, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(listner);
        panel.add(backButton);
    }
    public void resetButtonfun(JPanel panel, ActionListener listner) {
        resetButton.setBounds(600, 570, 120, 50);
        resetButton.addActionListener(listner);
        panel.add(resetButton);
    }
    public void reset(JPanel panel, ButtonGroup group) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
            if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(false);
                group.clearSelection();
            }
            if (c instanceof JComboBox) {
                ((JComboBox<?>) c).setSelectedIndex(0);
            }

        }
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        updatelist();

    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        updatelist();
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        updatelist();
    }
    public void updatelist() {
        String input = instituteFeild.getText().trim().toLowerCase();
        listModel.clear();
        if (input.isEmpty()) {
            popup.setVisible(false);
            return;
        }
        for (int i = 0; i < institutes.length; i++) {
            if (institutes[i].toLowerCase().contains(input)) {
                listModel.addElement(institutes[i]);
            }
        }
        if (!listModel.isEmpty()) {
            popup.show(instituteFeild, 0, instituteFeild.getHeight());
            instituteFeild.requestFocus();
        } else {
            popup.setVisible(false);
        }

    }
}
