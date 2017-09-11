/**
 * 051：冒泡排序法（**必须重点掌握**）
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
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class BubbleSort extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea1;
    private JTextArea textArea2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BubbleSort frame = new BubbleSort();
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
    public BubbleSort() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        contentPane.add(scrollPane, gbc_scrollPane);

        textArea1 = new JTextArea();
        scrollPane.setViewportView(textArea1);

        JButton button = new JButton("\u751F\u6210\u968F\u673A\u6570");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 0;
        gbc_button.gridy = 1;
        contentPane.add(button, gbc_button);

        JScrollPane scrollPane_1 = new JScrollPane();
        GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
        gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
        gbc_scrollPane_1.gridx = 0;
        gbc_scrollPane_1.gridy = 2;
        contentPane.add(scrollPane_1, gbc_scrollPane_1);

        JButton button_1 = new JButton("\u5192\u6CE1\u6392\u5E8F\u6CD5");
        button_1.setActionCommand("\u5192\u6CE1\u6392\u5E8F\u6CD5");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button_1 = new GridBagConstraints();
        gbc_button_1.gridx = 0;
        gbc_button_1.gridy = 3;
        contentPane.add(button_1, gbc_button_1);

        textArea2 = new JTextArea();
        scrollPane_1.setViewportView(textArea2);
    }

    private int[] array = new int[10];

    protected void do_button_actionPerformed(ActionEvent e) {
        Random random = new Random(); // 创建随机数对象
        textArea1.setText(""); // 清空文本域
        for (int i = 0; i < array.length; i++) { // 初始化数组元素
            array[i] = random.nextInt(50); // 生成50以内的随机数
            textArea1.append(array[i] + "  "); // 把数组元素显示的文本域控件中
        }
    }

    protected void do_button_1_actionPerformed(ActionEvent e) {
        textArea2.setText(""); // 清空文本域
        // 比较相邻两个元素，较大的数往后冒泡
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j]; // 把第一个元素值保持到临时变量中
                    array[j] = array[j + 1]; // 把第二个元素值保存到第一个元素单元中
                    array[j + 1] = temp; // 把临时变量也就是第一个元素原值保持到第二个元素中
                }
                textArea2.append(array[j] + "  "); // 把排序后的数组元素显示到文本域中
            }
            textArea2.append("【");
            for (int j = array.length - i; j < array.length; j++) {
                textArea2.append(array[j] + "  "); // 把排序后的数组元素显示到文本域中
            }
            textArea2.append("】\n");
        }
    }
}
