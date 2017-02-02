package ru.calculator.view;


import ru.calculator.controller.CalculatorController;
import ru.calculator.model.Operation;
import ru.calculator.plugin_api.PluginFactory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorView extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private CalculatorController calcController = null;

    private JTextField resultText;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn0;
    private JButton btnDel;
    private JButton btnC;
    private JButton btnRes;
    private JButton btnPoint;
    private JPanel jPanel;
    private ActionListener numActionListener;



    public CalculatorView(String title) {
        super(title);
        calcController = CalculatorController.getInstance();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 300);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        resultText = new JTextField(20);
        resultText.setEnabled(false);
        resultText.setDisabledTextColor(Color.black);
        calcController.setTextComponent(resultText);
        jPanel = new JPanel();

        resultText.setHorizontalAlignment(JTextField.RIGHT);
        btn1 = new JButton("1"); btn1.setActionCommand("1");
        btn2 = new JButton("2"); btn2.setActionCommand("2");
        btn3 = new JButton("3"); btn3.setActionCommand("3");
        btnC = new JButton("C");
        btnC.setPreferredSize(new Dimension(84, 26));
        btn4 = new JButton("4"); btn4.setActionCommand("4");
        btn5 = new JButton("5"); btn5.setActionCommand("5");
        btn6 = new JButton("6"); btn6.setActionCommand("6");
        btnDel = new JButton("Delete");
        btnDel.setPreferredSize(new Dimension(84, 26));
        btn7 = new JButton("7"); btn7.setActionCommand("7");
        btn8 = new JButton("8"); btn8.setActionCommand("8");
        btn9 = new JButton("9"); btn9.setActionCommand("9");
        btnRes = new JButton("=");
        btnRes.setPreferredSize(new Dimension(178, 26));
        btn0 = new JButton("0"); btn0.setActionCommand("0");

        btnPoint = new JButton(","); btnPoint.setActionCommand(".");
        btnPoint.setPreferredSize(new Dimension(84, 26));


        numActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                calcController.SetNumberText(e.getActionCommand());
            }
        };
        ActionListener delNumberActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                calcController.delLastNumber();
            }
        };

        ActionListener delAllActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                calcController.delAllNumber();
            }
        };

        btn1.addActionListener(numActionListener);

        btn2.addActionListener(numActionListener);

        btn3.addActionListener(numActionListener);

        btn4.addActionListener(numActionListener);

        btn5.addActionListener(numActionListener);

        btn6.addActionListener(numActionListener);

        btn7.addActionListener(numActionListener);

        btn8.addActionListener(numActionListener);

        btn9.addActionListener(numActionListener);

        btn0.addActionListener(numActionListener);

        btnPoint.addActionListener(numActionListener);

        btnC.addActionListener(delNumberActionListener);

        btnDel.addActionListener(delAllActionListener);


        btnRes.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcController.getResult();
            }
        }));

        this.add(resultText);
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btnC);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);
        this.add(btnDel);
        this.add(btn7);
        this.add(btn8);
        this.add(btn9);
        this.add(btnPoint);
        this.add(btn0);
        this.add(btnRes);
        this.add(jPanel);
        }

    @Override
    public void run() {
        while (true) {
            jPanel.removeAll();
            for (Operation op : PluginFactory.getPlugins()) {
                JButton b10 = new JButton(op.getName());
                b10.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        calcController.setOperation(op);
                                                           }
                                                       }
                );
                jPanel.add(b10).revalidate();

            }
            try{
                Thread.sleep(10000);
            }catch (InterruptedException i){

            }
        }
    }
}





