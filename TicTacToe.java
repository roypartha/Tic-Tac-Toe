import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe extends JFrame implements ActionListener
{
	Random random = new Random();
	JTextField t1;
	JLabel l1,l2,l3;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,next,exit; 
	
	JPanel p1;
	JButton[] buttons = new JButton[9]; 
	boolean player1_turn ;
	boolean che= false;
	
	int a=0;
		int b=0;
	
	public TicTacToe()
	{
		super("Game");
		this.setSize(600,560);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    p1 = new JPanel();
		p1.setSize(new Dimension(600,560));
		p1.setBackground(Color.black);
		p1.setLayout(null);
		
		
		l1 = new JLabel("TIC TAC TOE");
		l1.setFont(new Font("Serif",Font.BOLD,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(115,20,280,40);
		p1.add(l1);
		
		l2 = new JLabel("RESULT");
		
		l2.setFont(new Font("Serif",Font.BOLD,30));
		l2.setForeground(Color.BLUE);
		l2.setBounds(385,100,260,80);
		p1.add(l2);
		
		
		l3 = new JLabel();
		l3.setFont(new Font("Serif",Font.BOLD,30));
		l3.setForeground(Color.BLUE);
		l3.setBounds(385,190,260,80);
		p1.add(l3);
		
		b1 = new JButton();
		b1.setForeground(Color.green);
		b1.setBackground(Color.red);
		b1.setBounds(100,100,90,90);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton();
		b2.setForeground(Color.green);
		b2.setBackground(Color.red);
		b2.setBounds(195,100,90,90);
		b2.addActionListener(this);
		p1.add(b2);
		
		b3 = new JButton();
		b3.setForeground(Color.green);
		b3.setBackground(Color.red);
		b3.setBounds(290,100,90,90);
		b3.addActionListener(this);
		p1.add(b3);
		
		b4 = new JButton();
		b4.setForeground(Color.green);
		b4.setBackground(Color.red);
		b4.setBounds(100,195,90,90);
		b4.addActionListener(this);
		p1.add(b4);
		
		b5 = new JButton( );
		b5.setForeground(Color.green);
		b5.setBackground(Color.red);
		b5.setBounds(195,195,90,90);
		b5.addActionListener(this);
		p1.add(b5);
		
		b6 = new JButton();
		b6.setForeground(Color.green);
		b6.setBackground(Color.red);
		b6.setBounds(290,195,90,90);
		b6.addActionListener(this);
		p1.add(b6);
		
		b7 = new JButton();
		b7.setForeground(Color.green);
		b7.setBackground(Color.red);
		b7.setBounds(100,290,90,90);
		b7.addActionListener(this);
		p1.add(b7);
		
		b8 = new JButton();
		b8.setForeground(Color.green);
		b8.setBackground(Color.red);
		b8.setBounds(195,290,90,90);
		b8.addActionListener(this);
		p1.add(b8);
		
		b9 = new JButton( );
		b9.setForeground(Color.green);
		b9.setBackground(Color.red);
		b9.setBounds(290,290,90,90);
		b9.addActionListener(this);
		p1.add(b9);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Serif",Font.BOLD,25));
		exit.setForeground(Color.white);
		exit.setBackground(Color.red);
		exit.setBounds(50,400,150,40);
		exit.addActionListener(this);
		p1.add(exit);
		
		
		next = new JButton("PLAY AGAIN");
		next.setFont(new Font("Serif",Font.BOLD,25));
		next.setForeground(Color.white);
		next.setBackground(Color.red);
		next.setBounds(210,450,200,40);
		next.addActionListener(this);
		p1.add(next);
		
		t1 = new JTextField();
		t1.setBounds(385,400,165,40);
		t1.setFont(new Font("Serif",Font.BOLD,40));
		t1.setForeground(Color.yellow);
		t1.setBackground(Color.pink);
		t1.setText("Ratio");
		p1.add(t1);
		
		buttons[0]=b1;
		buttons[1]=b2;
		buttons[2]=b3;
		buttons[3]=b4;
		buttons[4]=b5;
		buttons[5]=b6;
		buttons[6]=b7;
		buttons[7]=b8;
		buttons[8]=b9;
		
		
		this.add(p1);
		
		firstTurn();
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
			
		
		
		for(int i=0;i<9;i++) 
		{
			if(e.getSource()==buttons[i])
			{
				if(player1_turn) 
				{
					if(buttons[i].getText()=="") 
					{
						buttons[i].setForeground( Color.green);
						buttons[i].setText("X");
						buttons[i].setFont(new Font("Serif",Font.BOLD,30));
						player1_turn=false;
						check();
						a++;
						
						
					}
				}
				else {
					if(buttons[i].getText()=="") 
					{
						buttons[i].setForeground(Color.blue);
						buttons[i].setText("O");
						buttons[i].setFont(new Font("Serif",Font.BOLD,30));
						player1_turn=true;
						check();
						b++;
					}
				}
			}
             count();			
		}
		
		if(a==5 && b==4)
		{
			if(che==false)
			{
				tie();
			}
		}
		
	     if(e.getSource()==next)
		{
			TicTacToe2 t = new TicTacToe2();
			this.setVisible(false);
			t.setVisible(true);
		}
		  if(e.getSource()==exit)
		{
			System.exit(0);
		}
		
		
		
		
		
	
	    
	      
	    
		
		
		
	}
	
	
	
	
	
	public void firstTurn()
	{
		
		
		
		if(random.nextInt(1)==0)
		{
			player1_turn=true;
		}
		else
		{
			player1_turn=false;
		}
		
		
	}
	
	public void check() {
		
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
					che= true;
			xWins(0,1,2);
		}
		else if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
					che= true;
			xWins(3,4,5);
		}
		else if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
					che= true;
			xWins(6,7,8);
		}
		else if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
					che= true;
			xWins(0,3,6);
		}
		else if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
					che= true;
			xWins(1,4,7);
		}
		else if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
					che= true;
			xWins(2,5,8);
		}
		else if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
					che= true;
			xWins(0,4,8);
		}
		else if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
					che= true;
			xWins(2,4,6);
		}
		
		else if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
					che= true;
			oWins(0,1,2);
		}
		else if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
					che= true;
			oWins(3,4,5);
		}
		else if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
					che= true;
			oWins(6,7,8);
		}
		else if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
					che= true;
			oWins(0,3,6);
		}
		else if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
					che= true;
			oWins(1,4,7);
		}
		else if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
					che= true;
			oWins(2,5,8);
		}
		else if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
					che= true;
			oWins(0,4,8);
		}
		else if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
					che= true;
			oWins(2,4,6);
		}
		
		
	}
	
	public void xWins(int a,int b,int c) 
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) 
		{
			buttons[i].setEnabled(false);
		}
		l3.setText("X Wins");
		l3.setForeground(Color.red);
	}
	public void oWins(int a,int b,int c) 
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) 
		{
			buttons[i].setEnabled(false);
		}
		l3.setText("O Wins");
		l3.setForeground(Color.red);
	}
	
	public void tie() 
	{
		
           l3.setText("Game Tie");
		   l3.setForeground(Color.red);			
		
	}
	
	public void count()
	{
		t1.setText("X:O ="+a+":"+b);
		t1.setForeground(Color.black);	
	}
	

}
	
	
