package com.java;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Frame_and_Operations implements ActionListener{
    JFrame frame=new JFrame("Calculator");
    JPanel panel=new JPanel();
    JTextField textField=new JTextField();
    Font myFont=new Font("Arial Black",Font.BOLD,25);
    JButton numbers[]=new JButton[10];
    JButton addition,subtraction,multiplication,division,decimal,equal_to,neg_or_pos,module;
    JButton delete,all_clear;
    String s="";
    String[] operator=new String[2];
    double number=0,number2=0,result=0;
    int temp=0,con=0;
    int op=0,res=0;
    Frame_and_Operations(){
                //1.Frame
                frame.setSize(470,620);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);
                frame.getContentPane().setBackground(Color.green);

                //2.Textfield to Dispaly Operations and Result
                textField.setBounds(12,10,430,80);
                //textField.setText("0");
                textField.setHorizontalAlignment(JTextField.RIGHT);
                textField.setCaretColor(Color.BLACK);
                textField.setFont(new Font("Arial Black",Font.BOLD,30));
                textField.setEditable(false);

                //3.Creating numbers
                for(int i=0;i<=9;i++){
                    numbers[i]=new JButton(String.valueOf(i));
                    numbers[i].addActionListener(this);
                    numbers[i].setFont(myFont);
                    numbers[i].setFocusable(false);
                }

                //4.Creating Operators for operations
                addition=new JButton("+");
                addition.setFont(myFont);
                addition.setFocusable(false);
                addition.addActionListener(this);
                subtraction=new JButton("-");
                subtraction.setFont(myFont);
                subtraction.setFocusable(false);
                subtraction.addActionListener(this);
                multiplication=new JButton("*");
                multiplication.setFont(myFont);
                multiplication.setFocusable(false);
                multiplication.addActionListener(this);
                division=new JButton("/");
                division.setFont(myFont);
                division.setFocusable(false);
                division.addActionListener(this);
                module=new JButton("%");
                module.setFont(myFont);
                module.setFocusable(false);
                module.addActionListener(this);
                decimal=new JButton("(.)");
                decimal.setFont(myFont);
                decimal.setFocusable(false);
                decimal.addActionListener(this);
                neg_or_pos=new JButton("+/-");
                neg_or_pos.setFont(myFont);
                neg_or_pos.setFocusable(false);
                neg_or_pos.addActionListener(this);
                equal_to=new JButton("=");
                equal_to.setFont(myFont);
                equal_to.setFocusable(false);
                equal_to.addActionListener(this);
                delete=new JButton("Del");
                delete.setFont(myFont);
                delete.setFocusable(false);
                delete.addActionListener(this);
                all_clear=new JButton("Clr");
                all_clear.setFont(myFont);
                all_clear.setFocusable(false);
                all_clear.addActionListener(this);

                //5.Panel to add Operators
                panel.setBounds(12,100,430,470);
                panel.setLayout(new GridLayout(5,4,0,0));

                panel.add(all_clear);
                panel.add(module);
                panel.add(delete);
                panel.add(division);
                panel.add(numbers[7]);
                panel.add(numbers[8]);
                panel.add(numbers[9]);
                panel.add(multiplication);
                panel.add(numbers[4]);
                panel.add(numbers[5]);
                panel.add(numbers[6]);
                panel.add(subtraction);
                panel.add(numbers[1]);
                panel.add(numbers[2]);
                panel.add(numbers[3]);
                panel.add(addition);
                panel.add(neg_or_pos);
                panel.add(numbers[0]);
                panel.add(decimal);
                panel.add(equal_to);

                //6.Adding the Created Components to Frame.
                frame.add(panel);
                frame.add(textField);
                frame.setVisible(true);
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    if (e.getSource() == numbers[i]) {
                        textField.setText(textField.getText().concat(String.valueOf(i)));
                        if (temp == 0) {
                            if(con==0){
                                number = (number * 10) + i;
                            }
                            else {
                                number =Double.parseDouble(textField.getText());
                            }
                        }
                        else if(temp>=1) {
                            if(con==0){
                                number2 = (number2 * 10) + i;
                            }
                            else{
                                s=textField.getText();
                                int len=s.length();
                                int len2=String.valueOf(number2).length();
                                s=s.substring(len-len2);
                                number2=Double.parseDouble(s);
                            }
                        }
                    }
                }


                if (e.getSource() == addition) {
                    if (op == 0) {
                        operator[0] = "+";
                        op = 1;
                    } else {
                        operator[1] = "+";
                        op = 2;
                    }
                    textField.setText(textField.getText().concat("+"));
                    temp++;
                    con=0;
                }


                if (e.getSource() == subtraction) {
                    if (op == 0) {
                        operator[0] = "-";
                        op = 1;
                    } else {
                        operator[1] = "-";
                        op = 2;
                    }
                    textField.setText(textField.getText().concat("-"));
                    temp++;
                    con=0;
                }


                if (e.getSource() == multiplication) {
                    if (op == 0) {
                        operator[0] = "*";
                        op = 1;
                    } else {
                        operator[1] = "*";
                        op = 2;
                    }
                    textField.setText(textField.getText().concat("*"));
                    temp++;
                    con=0;
                }


                if (e.getSource() == division) {
                    if (op == 0) {
                        operator[0] = "/";
                        op = 1;
                    } else {
                        operator[1] = "/";
                        op = 2;
                    }
                    textField.setText(textField.getText().concat("/"));
                    temp++;
                    con=0;
                }


                if (e.getSource() == module) {
                    if (op == 0) {
                        operator[0] = "%";
                        op = 1;
                    } else {
                        operator[1] = "%";
                        op = 2;
                    }
                    textField.setText(textField.getText().concat("%"));
                    temp++;
                    con=0;
                }

                if (op == 2) {
                    switch (operator[0]) {
                        case "+":
                            result = number + number2;
                            break;
                        case "-":
                            result = number - number2;
                            break;
                        case "*":
                            result = number * number2;
                            break;
                        case "/":
                            result = number / number2;
                            break;
                        case "%":
                            result = number % number2;
                            break;
                    }
                    number = result;
                    number2 = 0;
                    operator[0] = operator[1];
                    op = 1;
                    con=0;
                }


                if (e.getSource() == equal_to) {
                    switch (operator[0]) {
                        case "+":
                            result = number + number2;
                            break;
                        case "-":
                            result = number - number2;
                            break;
                        case "*":
                            result = number * number2;
                            break;
                        case "/":
                            result = number / number2;
                            break;
                        case "%":
                            result = number % number2;
                            break;
                    }
                    textField.setText(String.valueOf(result));
                    number = result;
                    op=0;
                    number2 = 0;
                    res=1;
                    con=0;

                }


                if (e.getSource() == decimal) {
                    if (con==0) {
                        if(temp==0){
                            textField.setText(textField.getText().concat("."));
                            con=1;
                        }
                        else if(temp>=1){
                            textField.setText(textField.getText().concat("."));
                            con=1;
                        }
                    }
                }


                if (e.getSource() == neg_or_pos) {
                    String str="";
                    if(temp==0){
                        number=number*(-1);
                        if(con==0)
                            str=(int)number+"";
                        else if(con==1)
                            str=number+"";
                        textField.setText(str);
                    }
                    else if(temp>=1){
                        number2=number2*(-1);
                        str=textField.getText();
                        String str2="";
                        int len=str.length();
                        int len2=0;
                        if(con==0){
                            len2=String.valueOf((int)number2).length();
                            str2=(int)number2+"";
                            if(number2<0)
                                len+=1;
                            else
                                len-=1;
                        }
                        else if(con==1){
                            len2=String.valueOf(number2).length();
                            str2=number2+"";
                            if(number2<0)
                                len+=1;
                            else
                                len-=1;
                        }
                        str=str.substring(0,(len-len2));
                        textField.setText(str.concat(str2));
                    }
                }

                if (e.getSource() == delete) {
                    if(con==0){
                        if (temp == 0 &&res!=1) {
                            number = (int) number / 10;
                            textField.setText(String.valueOf((int)number));
                        }
                        else if (temp >= 1&&res!=1) {
                            number2 = (int)number2 / 10;
                            String str = textField.getText();
                            int len = str.length() - 1;
                            str = str.substring(0, len);
                            textField.setText(str);
                        }
                    }
                    else if(con==1){
                        String s="";
                        if (temp == 0&&res!=1) {
                            s=textField.getText();
                            s=s.substring(0,s.length()-1);
                            number=Double.parseDouble(s);
                            textField.setText(String.valueOf(number));
                        }
                        else if (temp >= 1&&res!=1) {
                            s=textField.getText();
                            int len=s.length();
                            int len2=String.valueOf(number2).length();
                            number2=Double.parseDouble(s.substring(len-len2,len-1));
                            s=s.substring(0,s.length()-1);
                            textField.setText(s);
                        }
                    }
                }

                if (e.getSource() == all_clear) {
                    textField.setText("");
                    number = 0;
                    number2 = 0;
                    result = 0;
                    temp = 0;
                    con=0;
                }
    }
}
