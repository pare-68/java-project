
package JFrame;

import company.Tools;
import controls.JMyButton;
import controls.JPasswordBox;
import controls.JTextBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class frmLogin extends JFrame {

    
    private JFrame frame; 
    private JMyButton btnExit;
    private JMyButton btnLogin;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField txtPass;
    private JTextField txtUsername;
    
    public frmLogin(String title) {
        
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
      pack();
        
        
        los();
    }

  //----------------------------------------------------------------------------------------------------------  
   
    private void los() {
        
        frame = new JFrame("Login");
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txtUsername = new JTextBox(15);
        txtPass = new JPasswordBox(15);
        btnLogin = new JMyButton();
        btnExit = new JMyButton();

        
       Container maincontainer = this.getContentPane();
       maincontainer.setLayout(new BorderLayout(8,5));
        
       maincontainer.setBackground(Color.yellow);
       this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.ORANGE));
         
      //-----------------------------------------------------------------------  
        //panel top
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,5));
        topPanel.setBackground(Color.ORANGE);
        topPanel.setLayout(new FlowLayout(5));
        
        frame.add(topPanel);
        topPanel.add(jLabel1);
        
        
        maincontainer.add(topPanel,BorderLayout.PAGE_START);
      
        //-------------------------------------------------------------------
        //panel middle
        
        JPanel middlepanel = new JPanel();
        middlepanel.setBorder(new LineBorder(Color.BLACK,5));
        middlepanel.setLayout(new FlowLayout(5,5,5));
        middlepanel.setBackground(Color.RED);
        
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4,1,5,5));
        gridPanel.setBorder(new LineBorder(Color.BLACK,3));
        gridPanel.setBackground(Color.CYAN);
        
        
        frame.add(gridPanel);
        
        gridPanel.add(jLabel2);
        gridPanel.add(txtUsername);
        gridPanel.add(jLabel3);
        
        gridPanel.add(txtPass);
        
        gridPanel.add(btnLogin);
        gridPanel.add(btnExit);
        middlepanel.add(gridPanel);
        maincontainer.add(middlepanel,BorderLayout.CENTER);
        
 //------------------------------------------------------------------------------       
        jLabel1.setFont(new Font("Tahoma", 1, 18));
        jLabel1.setText("Anmeldung");

        jLabel2.setFont(new Font("Tahoma", 1, 14)); 
        jLabel2.setText("Nutzername:");

        jLabel3.setFont(new Font("Tahoma", 1, 14)); 
        jLabel3.setText("Passwort:");
//-------------------------------------------------------------------------------------------------------


        btnLogin.setText("Anmelden");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnLogin(evt);
            }
        });
//-------------------------------------------------------------------------------------------------------------------

        btnExit.setText("Ausgang");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnExit(evt);
            }
        });
//----------------------------------------------------------------------------------------------------------------------------

        pack();
    }
    //-----------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    
    
    
    private void btnExit(ActionEvent evt) 
    {
        System.exit(0);
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------
    
//methode login bo forme logen....................
    private void btnLogin(ActionEvent evt)
    {
        String user = txtUsername.getText();
        String pass = txtPass.getText();
        boolean isLogged = db.go.checkUserAndPass(user, pass);
        if(isLogged){
        
            this.dispose();
            Tools.openForm(new frmMain("Alfatraining Formular"));
        
        }
        else{
            
            Tools.msgBox("user and password Incorrect");
            txtUsername.setText("");
            txtPass.setText("");
            txtUsername.requestFocus();
        }
    }

 //-----------------------------------------------------------------------------------------------------------------------------------   
 
   
}
