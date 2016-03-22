package utcn.dsrl.pt.assig0.gui.controller;

import utcn.dsrl.pt.assig0.gui.calculator.Operation;
import utcn.dsrl.pt.assig0.gui.calculator.Operations;
import utcn.dsrl.pt.assig0.gui.polynom.Polynom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Zuklar on 23-Feb-16.
 */
public class Gui {
    private Operations operations = new Operations();

    private JFrame calculator;
    private JTextField ecran;

    private JButton sum;
    private JButton dif;
    private JButton mul;
    private JButton div;
    private JButton integrate;
    private JButton diferetiate;

    private ArrayList<JButton> numbers;

    private String op;
    private Polynom p1, p2, p3;
    public Gui(){

        numbers = new ArrayList<JButton>();
        ecran = new JTextField();
        calculator = new JFrame("Calculator");
        ecran.setEditable(false);


        calculator.setLayout(null);
        calculator.setSize(500, 550);
        calculator.setVisible(true);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ecran = new JTextField();
        ecran.setBounds(20,30, 400, 30);
        calculator.add(ecran);
        calculator.repaint();

        sum  = new JButton("+");
        sum.setFont(new Font("Arial", Font.PLAIN, 40));
        sum.setBounds(300, 70, 70, 70);
        sum.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                op = "sum";
                //System.out.printf("aici");
                p1 = new Polynom(ecran.getText());
            }
        });
        calculator.add(sum);

        dif  = new JButton("-");
        dif.setFont(new Font("Arial", Font.PLAIN, 40));
        dif.setBounds(390, 70, 70, 70);
        dif.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                op = "diference";
                System.out.println(op);
                p1 = new Polynom(ecran.getText());
            }
        });
        calculator.add(dif);

        mul  = new JButton("*");
        mul.setFont(new Font("Arial", Font.PLAIN, 40));
        mul.setBounds(300, 160, 70, 70);
        mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                op = "multiply";
                p1 = new Polynom(ecran.getText());

            }
        });
        calculator.add(mul);

        div  = new JButton("/");
        div.setFont(new Font("Arial", Font.PLAIN, 40));
        div.setBounds(390, 160, 70, 70);
        calculator.add(div);

        integrate = new JButton("Integrate");
        integrate.setFont(new Font("Arial", Font.BOLD, 20));
        integrate.setBounds(300, 250, 160, 40);
        integrate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                p1 = new Polynom(ecran.getText());
                p3 = operations.integrate(p1);
                ecran.setText(p3.toString());
            }
        });
        calculator.add(integrate);

        diferetiate = new JButton("Diferenciate");
        diferetiate.setFont(new Font("Arial", Font.BOLD, 20));
        diferetiate.setBounds(300, 310, 160, 40);
        diferetiate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                p1 = new Polynom(ecran.getText());
                p3 = operations.diferenciate(p1);
                ecran.setText(p3.toString());
            }
        });
        calculator.add(diferetiate);



        for (int i = 1; i <= 9; i++){
            JButton number = new JButton(Integer.toString(i));
            number.setFont(new Font("Arial", Font.PLAIN, 40));
            number.setBounds(20 + ((i - 1) % 3 * 90), 250 - (((i - 1) / 3) * 90), 70, 70);
            numbers.add(number);
            calculator.add(number);

        }

        JButton number = new JButton("0");
        number.setFont(new Font("Arial", Font.PLAIN, 40));
        number.setBounds(110, 340, 70, 70);
        numbers.add(number);
        calculator.add(number);

        number = new JButton("^");
        number.setFont(new Font("Arial", Font.PLAIN, 40));
        number.setBounds(20, 340, 70, 70);
        numbers.add(number);
        calculator.add(number);

        number = new JButton("X");
        number.setFont(new Font("Arial", Font.PLAIN, 40));
        number.setBounds(200, 340, 70, 70);
        numbers.add(number);
        calculator.add(number);

        number = new JButton("=");
        number.setFont(new Font("Arial", Font.PLAIN, 40));
        number.setBounds(330, 370, 70, 70);
        numbers.add(number);
        number.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                p2 = new Polynom(ecran.getText());
                Operation operation = Operation.valueOf(op);
                switch (operation){
                    case sum:
                        p3 = operations.sum(p1,p2);
                        ecran.setText(p3.toString());
                        break;

                    case diference:
                        p3 = operations.dif(p1,p2);
                        ecran.setText(p3.toString());
                        System.out.printf("aici");
                        break;

                    case multiply:
                        p3 = operations.mul1(p1,p2);
                        ecran.setText(p3.toString());
                        break;

                    case integral:

                        break;

                }
            }
        });
        calculator.add(number);



        number = new JButton("+");
        number.setFont(new Font("Arial", Font.PLAIN, 40));
        number.setBounds(20, 430, 70, 70);
        numbers.add(number);
        calculator.add(number);

        number = new JButton("-");
        number.setFont(new Font("Arial", Font.PLAIN, 40));
        number.setBounds(110, 430, 70, 70);
        numbers.add(number);
        calculator.add(number);

        calculator.repaint();
        ecran.requestFocus(true);

    }

}