package libraryman;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LibraryMan extends JFrame{
    private Container c;
    private JFrame jf1;
    private ImageIcon img1,img2,img3;
    private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
    private Font f;
    private JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8;
    private JButton jb1,jb2,jb3,jb4,jb5;
    private File file1,file2,file3;
    
    LibraryMan(){
        //setting javaframe properties
        c = this.getContentPane();
        c.setLayout(null);
        img1 = new ImageIcon(getClass().getResource("books.jpg"));
        jl1 = new JLabel();
        jl2 = new JLabel("Customer Name :");
        jl3 = new JLabel("Book Name :");
        jl4 = new JLabel("Author Name :");
        jl5 = new JLabel("Phone Number :");
        jl6 = new JLabel("Price :");
        jt1 = new JTextField();
        jt2 = new JTextField();
        jt3 = new JTextField();
        jt4 = new JTextField();
        jt5 = new JTextField();
        jb1 = new JButton("Sold");
        jb2 = new JButton("Customer Details");
        jb3 = new JButton("Avialable Books");
        jb4 = new JButton("Add New Book");
        
        jl1.setBounds(0, 0,img1.getIconWidth(),img1.getIconHeight());
        jl1.setIcon(img1);
        
        jl2.setBounds(30, 50, 150, 60);jt1.setBounds(180, 65, 180, 30);
        jl2.setForeground(Color.white);jt1.setBackground(Color.WHITE);
        jl3.setBounds(30, 110, 150, 60);jt2.setBounds(180, 125, 180, 30);
        jl3.setForeground(Color.white);jt2.setBackground(Color.WHITE);
        jl4.setBounds(30, 170, 150, 60);jt3.setBounds(180, 185, 180, 30);
        jl4.setForeground(Color.white);jt3.setBackground(Color.WHITE);
        jl5.setBounds(30, 230, 150, 60);jt4.setBounds(180, 245, 180, 30);
        jl5.setForeground(Color.white);jt4.setBackground(Color.WHITE);
        jl6.setBounds(30, 290, 150, 60);jt5.setBounds(180, 305, 180, 30);
        jl6.setForeground(Color.white);jt5.setBackground(Color.WHITE);
        jb1.setBounds(20, 350,180,30);
        jb2.setBounds(220,350,180,30);
        jb3.setBounds(220,400,180,30);
        jb4.setBounds(20, 400,180,30);
        
        
        c.add(jb1);c.add(jb2);c.add(jb3);c.add(jl2);c.add(jl3);c.add(jl4);c.add(jl5);c.add(jl6);c.add(jt1);
        c.add(jt2);c.add(jt3);c.add(jt4);c.add(jt5);c.add(jb4);c.add(jl1);
        
        //Button1 to save records of customer
        jb1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy    HH:mm:ss");
                Date dateobj = new Date();
                Calendar calobj = Calendar.getInstance();
                
                String book = jt2.getText();
                    int c = 0;
                    
                //checking if the book is available or not    
                    try{
                    Scanner s = new Scanner(file3);
                    while(s.hasNext()){
                        String p = s.nextLine();
                        if(p.equals(book))
                        {
                          c++;
                          break;
                        }
                                      }
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null,"sorry had some problem");
                    }
                
                //check if any of the textfield is empty     
                if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") ||
                   jt4.getText().equals("") || jt5.getText().equals("")){
                            JOptionPane.showMessageDialog(null,"Enter info in all textfields");
                        }
                
                //if book is not availabe then show this message
                else if(c==0){
                    JOptionPane.showMessageDialog(null,"Book is not available");
                }
                
                //if everything is ok then save all the information in file1
                else{
                try{
                    FileWriter fw = new FileWriter(file1,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("Name: "+jt1.getText()+"|| Book: "+jt2.getText()+
                    "|| Author: "+jt3.getText()+"|| Number: "+jt4.getText()+"|| Price: "+jt5.getText()+"\n"
                    +df.format(calobj.getTime())+"\n");
                    bw.newLine();
                    bw.close();
                    jt1.setText("");jt2.setText("");jt3.setText("");jt4.setText("");jt5.setText("");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"sorry had some problem");
                }
                }
}
            
        });
        
        
        //button2 to get customer information
        jb2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //setting javaframe properties
                JFrame jf1 = new JFrame();
                Container c1;
                jf1.setVisible(true);
                jf1.setResizable(true);
                jf1.setTitle("Customer Detail");
                jf1.setBounds(40, 10,800, 630);
                
                c1 = jf1.getContentPane();
                c1.setLayout(null);
                
                JLabel jl = new JLabel();
                JTextArea jt = new JTextArea();
                img2 = new ImageIcon(getClass().getResource("dt.jpg"));
                f = new Font("Arial",Font.BOLD+Font.ITALIC,16);
                
                jl.setBounds(0, 0,img2.getIconWidth(),img2.getIconHeight());
                jl.setIcon(img2);
                jt.setWrapStyleWord(true);
                jt.setLineWrap(true);
                jt.setEditable(false);
                jt.setOpaque(true);
                jt.setForeground(Color.black);
                jt.setFont(f);
                
                JScrollPane jsp = new JScrollPane(jt);
                jsp.setEnabled(true);
                jsp.setBounds(0, 0,500,img2.getIconHeight());
                
                //scanning file1 for customer information and showing it to user
                 try{
                                Scanner sc = new Scanner(file1);
                                while(sc.hasNext()){
                                    jt.append(sc.nextLine()+"\n");
                                }
                                }
                                catch(Exception ex){
                                    JOptionPane.showMessageDialog(null,ex);
                                }
                
                
                c1.add(jsp);c1.add(jl);
            }
            
        });
        
        //button4 for adding new books to the system
        jb4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //setting javaframe properties
                JFrame jf1 = new JFrame();
                Container c1;
                jf1.setVisible(true);
                jf1.setBounds(20, 20, 600, 500);
                jf1.setTitle("Add New Book");
                c1 = jf1.getContentPane();
                c1.setLayout(null);
                
                JLabel jl = new JLabel();
                f = new Font("Arial",Font.BOLD+Font.ITALIC,16);
                jl7 = new JLabel("Book Name:");
                jl8 = new JLabel("Author Name:");
                jl9 = new JLabel("Price:");
                jt6 = new JTextField();
                jt7 = new JTextField();
                jt8 = new JTextField();
                jb5 = new JButton("Add Book");
                
                jl7.setBounds(140,70,120, 40);jt6.setBounds(250,80,170,25);
                jl8.setBounds(140,120,120,40);jt7.setBounds(250,130,170,25);
                jl9.setBounds(140,170,120,40);jt8.setBounds(250,180,170,25);
                jl7.setForeground(Color.white);
                jl8.setForeground(Color.white);
                jl9.setForeground(Color.white);
                jl7.setFont(f);
                jl8.setFont(f);
                jl9.setFont(f);
                jb5.setBounds(210,230,100,30);
                
                img3 = new ImageIcon(getClass().getResource("newb.jpg"));
                jl.setBounds(0, 0,img3.getIconWidth(),img3.getIconHeight());
                jl.setIcon(img3);
                c1.add(jb5);c1.add(jl7);c1.add(jl8);c1.add(jl9);c1.add(jt6);c1.add(jt7);c1.add(jt8);c1.add(jl);
                
                //button5 to save the new book detail in file2
                jb5.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //checking if any of the textfield is empty or not
                        if(jt6.getText().equals("") || jt7.getText().equals("") ||
                                jt8.getText().equals("")){
                            JOptionPane.showMessageDialog(null,"Enter info in all textfields");
                        }
                        //saving new book detail in file2
                        else{
                            try{
                    FileWriter fw = new FileWriter(file2,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(" Book: "+jt6.getText()+
                    "|| Author: "+jt7.getText()+"|| Price: "+jt8.getText());
                    bw.newLine();
                    bw.close();
                    //adding only book name to file3 for checking availability during sell
                    fw = new FileWriter(file3,true);
                    bw = new BufferedWriter(fw);
                    bw.write(jt6.getText());
                    bw.newLine();
                    bw.close();
                    JOptionPane.showMessageDialog(null,"Book added");
                    jt6.setText("");jt7.setText("");jt8.setText("");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Could not save the receipt");
                }
                        }
}
                    
                });
                }
        });
        
        //button3 for checking information of available books
        jb3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //setting javaframe properties
                JFrame jf1 = new JFrame();
                Container c1;
                jf1.setVisible(true);
                jf1.setResizable(true);
                jf1.setTitle("Available Books");
                jf1.setBounds(40, 10,800, 630);
                
                c1 = jf1.getContentPane();
                c1.setLayout(null);
                
                JLabel jl = new JLabel();
                JTextArea jt = new JTextArea();
                img2 = new ImageIcon(getClass().getResource("dt.jpg"));
                f = new Font("Arial",Font.BOLD+Font.ITALIC,16);
                
                jl.setBounds(0, 0,img2.getIconWidth(),img2.getIconHeight());
                jl.setIcon(img2);
                jt.setWrapStyleWord(true);
                jt.setLineWrap(true);
                jt.setEditable(false);
                jt.setOpaque(true);
                jt.setForeground(Color.black);
                jt.setFont(f);
                
                JScrollPane jsp = new JScrollPane(jt);
                jsp.setEnabled(true);
                jsp.setBounds(0, 0,500,img2.getIconHeight());
                
                //scanning file2 for information of books and showing it to user
                 try{
                                Scanner sc = new Scanner(file2);
                                while(sc.hasNext()){
                                    jt.append(sc.nextLine()+"\n");
                                }
                                }
                                catch(Exception ex){
                                    JOptionPane.showMessageDialog(null,ex);
                                }
                
                
                c1.add(jsp);c1.add(jl);
}
        });
        
        
    }
    

    public static void main(String[] args) {
        LibraryMan l = new LibraryMan();
        //opening files
        l.file1 = new File("CustomerData.txt");
        l.file2 = new File("AvailableBooks.txt");
        l.file3 = new File("Book.txt");
        
        try{
            l.file1.createNewFile();
            l.file2.createNewFile();
            l.file3.createNewFile();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        //setting javaframe properties
        l.setBounds(30, 20, 800,650);
        l.setTitle("Library Management");
        l.setVisible(true);
        l.setResizable(false);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
