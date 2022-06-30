
/**
* 1) This Quiz Game consists of 10 Questions
* with 4 options each.
* 2) User can Review the question for later visit.
* 3) After attempting all the questions user will get a display message with
* the number of correct answers submitted.
* 4) This project is built using JAVA.
*
* @author  Devesh Ratan
* 
* @since   2022-06-28 
*/



import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class Quiz extends JFrame implements ActionListener  
{  
    JLabel l,l1;  // Creating Labels
    JRadioButton jb[]=new JRadioButton[5];  // Creating Radio Buttons for options 
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];
	String s1;

    Quiz(String s)  // Constructor
    {  
        super(s); 
    	s1 = JOptionPane.showInputDialog("Enter your name");
        l=new JLabel();
        l1=new JLabel();
        add(l); 
        add(l1);
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  // Next Button 
        b2=new JButton("Review");  // Review Button
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        questions();  
        
        // Setting Question design
        l.setBounds(30,60,1000,30);        
        l.setFont(new Font("",Font.BOLD, 19));
        l.setForeground(Color.black);
        
        // Setting Name design
        l1.setBounds(600,20,200,18);
        l1.setFont(new Font("monospaced",Font.BOLD,18));
        l1.setForeground(Color.black);
        l1.setText("Welcome " + s1); 
        
        // Setting RadioButton design
        jb[0].setFont(new Font("monospaced",Font.BOLD, 20));
        jb[1].setFont(new Font("monospaced",Font.BOLD, 20));
        jb[2].setFont(new Font("monospaced",Font.BOLD, 20));
        jb[3].setFont(new Font("monospaced",Font.BOLD, 20)); 
        jb[0].setForeground(Color.red);
        jb[1].setForeground(Color.red);
        jb[2].setForeground(Color.red);
        jb[3].setForeground(Color.red);        
        jb[0].setBounds(80,125,200,30);  
        jb[1].setBounds(500,125,200,30);  
        jb[2].setBounds(80,190,200,30);  
        jb[3].setBounds(500,190,200,30);  
        
        // Setting Button design
        b1.setBounds(100,300,100,30); 
        b1.setFont(new Font("Serif",Font.BOLD, 20));
        b2.setBounds(270,300,170,30);
        b2.setFont(new Font("Serif",Font.BOLD, 20));
        
        // Setting Main Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(850,500);  
        getContentPane().setBackground(Color.white);

    }  
    
    // Logic
    
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(answers())  
                count=count+1;  
            current++;  
            questions();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Get Result");  
            }  
        }  
        
        if(e.getActionCommand().equals("Review"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(500,250+20*x,100,20);
            bk.setFont(new Font("Monospaced",Font.BOLD, 15));            
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            questions();    
            if(current==9)  
                b2.setText("Get Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(answers())  
                count=count+1;  
            now=current;  
            current=m[y];  
            questions();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Get Result"))  
        {  
            if(answers())  
                count=count+1;  
            current++;  
            
            //System.out.println("correct ans = "+count);  
            JOptionPane.showMessageDialog(this,"Right Answers = "+count);  
            System.exit(0);  
        }  
    } 
    
    
    // Question set
    
    void questions()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Q-1: Which component is used to compile, debug and execute the java programs?");  
            jb[0].setText("JRE");jb[1].setText("JIT");jb[2].setText("JDK");jb[3].setText("JVM"); //jdk  
        }  
        if(current==1)  
        {  
            l.setText("Q-2: Which of the following is a valid long literal?");  
            jb[0].setText("L990023");jb[1].setText("ABH8097");jb[2].setText("904423");jb[3].setText("0xnf029L"); //d  
        }  
        if(current==2)  
        {  
            l.setText("Q-3: compareTo() returns");  
            jb[0].setText("True");jb[1].setText("False");jb[2].setText("An Int Value");jb[3].setText("None"); //c 
        }  
        if(current==3)  
        {  
            l.setText("Q-4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Q-5: Which of the following is a reserved keyword in Java?");  
            jb[0].setText("object");jb[1].setText("strictfp");jb[2].setText("main");jb[3].setText("system"); //b  
        }  
        if(current==5)  
        {  
            l.setText("Q-6: What is the initial quantity of the ArrayList list?");  
            jb[0].setText("10");jb[1].setText("5");jb[2].setText("100");jb[3].setText("0"); //10 
        }  
        if(current==6)  
        {  
            l.setText("Q-7:  a = 1 , b = 3 ; b = a++   +   ++a   +   ++a   +   a++   +   ++a ; then a = ? , b = ?");  
            jb[0].setText("5 , 20");jb[1].setText("7 , 21");jb[2].setText("6 , 18");  
                        jb[3].setText("8 , 19");  // 6 18
        }  
        if(current==7)  
        {  
            l.setText("Q-8: a = 9 , b = 9 ;  a = b++  ;  b = a++  ;  b = ++b  ; then a = ? , b = ?");  
            jb[0].setText("9 , 10");jb[1].setText("10 , 9");jb[2].setText("11 , 10");  
                        jb[3].setText("10 , 10");      // 10 , 10   
        }  
        if(current==8)  
        {  
            l.setText("Q-9: Worst case time complexity to access an element in a BST can be?");  
            jb[0].setText("O(n)");jb[1].setText("O(1)");jb[2].setText("O(log n)");jb[3].setText("O(n * log n)");  
        }  // a
        if(current==9)  
        {  
            l.setText("Q-10: The operation of processing each element in the list is known as?");  
            jb[0].setText("Sorting");jb[1].setText("Merging");jb[2].setText("Traversal");  
                        jb[3].setText("Inserting");   // c
        }  
    }
    
    
    // Answer Checking 
    boolean answers()  
    {  
        if(current==0)  
            return(jb[2].isSelected());  
        if(current==1)  
            return(jb[3].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[2].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[0].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    } 
    
    
    // Driver Code
    
    public static void main(String s[])  
    {  
        new Quiz("Quiz Game -- © Devesh Ratan");  
    }  
}  