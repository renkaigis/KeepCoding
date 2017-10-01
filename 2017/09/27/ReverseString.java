/**
 * 074：将字符串的每一个字符进行倒序输出（reverse()）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReverseString extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea_2;
    private JTextArea textArea_1;
    private JLabel label_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReverseString frame = new ReverseString();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ReverseString() {
        setTitle("\u5C06\u5B57\u7B26\u4E32\u7684\u6BCF\u4E2A\u5B57\u7B26\u8FDB\u884C\u5012\u5E8F\u8F93\u51FA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.columnWidths = new int[]{155, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel label = new JLabel("\u8F93\u5165\u5B57\u7B26\u4E32\uFF1A");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.WEST;
        gbc_label.insets = new Insets(0, 0, 5, 0);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        contentPane.add(scrollPane, gbc_scrollPane);

        textArea_1 = new JTextArea();
        textArea_1.setLineWrap(true);
        scrollPane.setViewportView(textArea_1);

        label_1 = new JLabel("\u8F93\u5165\u5B57\u7B26\u4E32\uFF1A");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.WEST;
        gbc_label_1.insets = new Insets(0, 0, 5, 0);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 3;
        contentPane.add(label_1, gbc_label_1);

        JButton button = new JButton("\u53CD\u8F6C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 0;
        gbc_button.gridy = 2;
        contentPane.add(button, gbc_button);

        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 0;
        gbc_scrollPane_1.gridy = 4;
        contentPane.add(scrollPane_1, gbc_scrollPane_1);

        textArea_2 = new JTextArea();
        textArea_2.setLineWrap(true);
        scrollPane_1.setViewportView(textArea_2);

    }

    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textArea_1.getText();
        StringBuilder sbuilder = new StringBuilder(text);
        StringBuilder reverse = sbuilder.reverse();
        String reverseText = reverse.toString();
        textArea_2.setText(reverseText);
    }
}
