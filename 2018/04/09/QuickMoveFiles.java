/**
 * 418：快速批量移动文件（文件操作）
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class QuickMoveFiles extends JFrame {

    private JPanel contentPane;
    private JTextArea infoArea;
    private JTextField sourceFolderField;
    private JTextField targetFolderField;
    private File[] files;
    private File dir;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuickMoveFiles frame = new QuickMoveFiles();
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
    public QuickMoveFiles() {
        setTitle("\u5FEB\u901F\u6279\u91CF\u79FB\u52A8\u6587\u4EF6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 507, 299);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 178, 0, 0, 0, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 169, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        JLabel label = new JLabel("\u9009\u62E9\u6E90\u6587\u4EF6\uFF1A");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.EAST;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);

        sourceFolderField = new JTextField();
        GridBagConstraints gbc_sourceFolderField = new GridBagConstraints();
        gbc_sourceFolderField.gridwidth = 3;
        gbc_sourceFolderField.insets = new Insets(0, 0, 5, 5);
        gbc_sourceFolderField.fill = GridBagConstraints.HORIZONTAL;
        gbc_sourceFolderField.gridx = 1;
        gbc_sourceFolderField.gridy = 0;
        contentPane.add(sourceFolderField, gbc_sourceFolderField);
        sourceFolderField.setColumns(10);

        JButton browserButton1 = new JButton("\u6D4F\u89C8");
        browserButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_browserButton1_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_browserButton1 = new GridBagConstraints();
        gbc_browserButton1.insets = new Insets(0, 0, 5, 0);
        gbc_browserButton1.gridx = 4;
        gbc_browserButton1.gridy = 0;
        contentPane.add(browserButton1, gbc_browserButton1);

        JLabel label_1 = new JLabel(
                "\u9009\u62E9\u76EE\u6807\u6587\u4EF6\u5939\uFF1A");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 1;
        contentPane.add(label_1, gbc_label_1);

        targetFolderField = new JTextField();
        GridBagConstraints gbc_targetFolderField = new GridBagConstraints();
        gbc_targetFolderField.gridwidth = 3;
        gbc_targetFolderField.insets = new Insets(0, 0, 5, 5);
        gbc_targetFolderField.fill = GridBagConstraints.HORIZONTAL;
        gbc_targetFolderField.gridx = 1;
        gbc_targetFolderField.gridy = 1;
        contentPane.add(targetFolderField, gbc_targetFolderField);
        targetFolderField.setColumns(10);

        JButton browserButton2 = new JButton("\u6D4F\u89C8");
        browserButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_browserButton2_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_browserButton2 = new GridBagConstraints();
        gbc_browserButton2.insets = new Insets(0, 0, 5, 0);
        gbc_browserButton2.gridx = 4;
        gbc_browserButton2.gridy = 1;
        contentPane.add(browserButton2, gbc_browserButton2);

        JLabel label_2 = new JLabel("\u64CD\u4F5C\u8BB0\u5F55\uFF1A");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.anchor = GridBagConstraints.EAST;
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 0;
        gbc_label_2.gridy = 2;
        contentPane.add(label_2, gbc_label_2);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridwidth = 4;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 2;
        contentPane.add(scrollPane, gbc_scrollPane);

        infoArea = new JTextArea();
        scrollPane.setViewportView(infoArea);

        JButton moveButton = new JButton("\u79FB\u52A8");
        moveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_moveButton_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_moveButton = new GridBagConstraints();
        gbc_moveButton.insets = new Insets(0, 0, 0, 5);
        gbc_moveButton.gridx = 1;
        gbc_moveButton.gridy = 3;
        contentPane.add(moveButton, gbc_moveButton);

        JButton closeButton = new JButton("\u5173\u95ED");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_closeButton = new GridBagConstraints();
        gbc_closeButton.insets = new Insets(0, 0, 0, 5);
        gbc_closeButton.gridx = 2;
        gbc_closeButton.gridy = 3;
        contentPane.add(closeButton, gbc_closeButton);
    }

    /**
     * 选择源文件的浏览按钮
     *
     * @param e
     */
    protected void do_browserButton1_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        chooser.setMultiSelectionEnabled(true);// 设置文件多选
        int option = chooser.showOpenDialog(this);// 显示文件打开对话框
        if (option == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();// 获取选择的文件数组
            sourceFolderField.setText("");// 清空文本框
            StringBuilder filesStr = new StringBuilder();
            for (File file : files) {// 遍历文件数组
                filesStr.append("、" + file.getName());// 连接文件名称
            }
            String str = filesStr.substring(1);// 获取所有文件名称的字符串
            sourceFolderField.setText(str);// 设置文件名称信息到文本框
        } else {
            files = new File[0];
            sourceFolderField.setText("");// 清空文本框
        }
    }

    /**
     * 选择目标文件夹的浏览按钮
     *
     * @param e
     */
    protected void do_browserButton2_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 创建文件选择器
        // 设置选择器只针对文件夹生效
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = chooser.showOpenDialog(this);// 显示文件打开对话框
        if (option == JFileChooser.APPROVE_OPTION) {
            dir = chooser.getSelectedFile();// 获取选择的文件夹
            targetFolderField.setText(dir.toString());// 显示文件夹到文本框
        } else {
            dir = null;
            targetFolderField.setText("");
        }
    }

    /**
     * 关闭按钮的事件处理方法
     *
     * @param e
     */
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * 移动按钮的事件处理方法
     *
     * @param e
     */
    protected void do_moveButton_actionPerformed(ActionEvent e) {
        if (files.length <= 0 || dir == null)// 判断文件数组有无元素
            return;
        for (File file : files) {// 遍历文件数组
            File newFile = new File(dir, file.getName());// 创建移动目标文件
            infoArea.append(file.getName() + "\t移动到\t" + dir);// 显示移动记录
            file.renameTo(newFile);// 文件移动
            infoArea.append("------完成\n");// 显示移动完成信息
        }
        // 显示操作完成
        infoArea.append("##################操作完成###################\n");
    }
}
