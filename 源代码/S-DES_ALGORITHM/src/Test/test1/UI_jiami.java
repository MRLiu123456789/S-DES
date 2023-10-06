package Test.test1;

import BaseMethodsTools.CPMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI_jiami extends JFrame {
    private JTextArea outputTextAre_jiami;
    private JTextField inputTextField_jiami;
    private JTextField inputTextField_k;
    private JTextField outputTextField_jiami;

    /**
     * 加密函数
     */
    public UI_jiami() {

        // 设置窗口标题
        setTitle("明文加密程序");

        // 设置窗口默认关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建面板
        JPanel mainPanel = new JPanel(new BorderLayout());

        // 创建输出文本区域
        outputTextAre_jiami = new JTextArea();
        outputTextAre_jiami.setEditable(false);
        outputTextAre_jiami.setFont(new Font("宋体", Font.PLAIN, 40)); // 设置字体大小

        // 创建滚动面板，并将输出文本区域添加到其中
        JScrollPane scrollPane = new JScrollPane(outputTextAre_jiami);
        scrollPane.setPreferredSize(new Dimension(800, 300)); // 设置滚动面板的尺寸

        // 创建输入文本框并设置列数和字体大小

        int[] p = new int[9];         //需要加密的数据
//        int[] k = new int[10];     //一个密钥
        int[] k = {2,1,0,1,0,0,0,0,0,1,0};
        int[] c = new int[9];

        inputTextField_k = new JTextField();
        inputTextField_k.setColumns(30); // 设置列数
        inputTextField_k.setFont(new Font("宋体", Font.PLAIN, 40)); // 设置字体大小
        inputTextField_k.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String input = inputTextField_k.getText();
                String[] String_k = input.split(",");
                for (int i = 0; i < String_k.length; i++) {
                    k[i] = Integer.parseInt(String_k[i]); // 将每个单独的数字转换为整数
                }
                outputTextAre_jiami.append("此次解密的密钥为:");
                for(int i = 0; i<=9; i++){
                    outputTextAre_jiami.append(k[i]+" ");
                }
                inputTextField_k.setText("");
            }
        });

        inputTextField_jiami = new JTextField();
        inputTextField_jiami.setColumns(30); // 设置列数
        inputTextField_jiami.setFont(new Font("宋体", Font.PLAIN, 40)); // 设置字体大小
        inputTextField_jiami.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String input = inputTextField_jiami.getText();
                String[] String_p = input.split(",");
                for (int i = 0; i < String_p.length; i++) {
                    p[i] = Integer.parseInt(String_p[i]); // 将每个单独的数字转换为整数
                }
                int[] c = CPMethods.jiami(p,k);
                outputTextAre_jiami.append("\n此次加密的明文为:");
                for(int i = 1; i<=8; i++){
                    outputTextAre_jiami.append(p[i]+" ");
                }
                inputTextField_jiami.setText("");
                outputTextAre_jiami.append("\n密文如下:\n");
                for(int i = 1; i<=8; i++){
                    outputTextAre_jiami.append(c[i]+" ");
                }
                inputTextField_jiami.setText("");
            }
        });



        // 创建输出文本框
        outputTextField_jiami = new JTextField("请先在左侧输入框中输入密钥，再在最下方输入框中输入明文(明文开头加上“2,”，数字间用“,”隔开)");
        outputTextField_jiami.setEditable(false);
        outputTextField_jiami.setFont(new Font("宋体", Font.PLAIN, 40)); // 设置字体大小

        // 将滚动面板和输入文本框添加到主面板
        mainPanel.add(scrollPane, BorderLayout.EAST);
        mainPanel.add(inputTextField_k, BorderLayout.CENTER);
        mainPanel.add(inputTextField_jiami, BorderLayout.SOUTH);
        mainPanel.add(outputTextField_jiami, BorderLayout.NORTH);

        // 将主面板添加到窗口中
        getContentPane().add(mainPanel);

        // 自动调整窗口大小以适应组件
        pack();

        // 设置窗口位置居中
        setLocationRelativeTo(null);
    }



    public static void main(String[] args) {
        // 在事件分派线程中创建和显示 GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UI_jiami ui = new UI_jiami();
                ui.setVisible(true);
            }
        });
    }
}
