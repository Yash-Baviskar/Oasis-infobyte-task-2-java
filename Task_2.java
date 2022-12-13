package com.oasis;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



class Task2 extends JFrame
{

    public JTextField t1, t2;
    //JTextField is a lightweight component that allows the editing of a single line of text.
    //A JLabel object can display either text, an image, or both.
    public JLabel jl;
    ButtonListener b1;
    ButtonListener2 b2;

    int random=(int) (Math.random()*100); //Generates random numbers between 1 and 100.
    int increment =0;


    public Task2()
    {

        Container container;
        //A generic Abstract Window Toolkit(AWT) container object is a component that can contain other AWT components.
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        JLabel labelpic = new JLabel("");
        JLabel jm;
        jm = new JLabel("Number Guessing Game");
        jm.setForeground(Color.BLUE);
        jm.setFont(new Font("Times New Roman",Font.BOLD,22));
        jm.setSize(270 ,20);
        jm.setLocation(300,35);
        JLabel jb1 =new JLabel("Choose between 1-100");
        jb1.setFont(new Font("Verdana",Font.PLAIN,17));
        jb1.setSize(270,20);
        jb1.setLocation(300,60);
        t1=new JTextField(10);
        t1.setSize(50,30);
        t1.setLocation(360,90);
        jl =new JLabel("Status");
        jl.setFont(new Font("Palatine",Font.PLAIN,17));
        jl.setSize(270,20);
        jl.setLocation(300,150);
        t2 =new JTextField(10);
        t2.setSize(40,20);
        t2.setLocation(160,100);
        JLabel j2=new JLabel("Number of Guesses");
        j2.setFont(new Font("Verdana",Font.PLAIN,12));
        j2.setSize(270,20);
        j2.setLocation(210,100);
        JButton b1=new JButton("Guess It!");
        b1.setSize(150,50);
        b1.setLocation(290,250);
        this.b1 =new ButtonListener();
        b1.addActionListener(this.b1);
        JButton b2=new JButton("Guess Again!");
        b2.setSize(110,20);
        b2.setLocation(290,200);
        this.b2 =new ButtonListener2();
        b2.addActionListener(this.b2);
        container.add(jl);
        container.add(labelpic);
        container.add(jm);
        container.add(jb1);
        container.add(t1);
        container.add(t2);
        container.add(b1);
        container.add(b2);
        container.add(j2);
        t2.setEditable(false);
        setTitle("Number Guessing Game");
        setSize(480,360);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent eve)
        {
            int app = Integer.parseInt(t1.getText());
            increment = increment +1;
            if(app <random)
            {
                jl.setText("Please Enter a Low Number");
            }
            else if(app >random)
            {
                jl.setText("Please Enter a High Number");
            }
            else
            {
                jl.setText("Hurray! You Guessed It Right!");
            }
            t1.requestFocusInWindow();
            t1.selectAll();

            t2.setText(increment +"");
        }
    }



    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            random=(int) (Math.random()*100);
            t1.setText("");
            t2.setText("");
            jl.setText("Try again and guess the number");
            t2.setText("");
            increment =0;
            t1.setEditable(true);
            t1.requestFocusInWindow();
        }
    }



    public static void main(String[] args)
    {
        new Task2();
    }
}
