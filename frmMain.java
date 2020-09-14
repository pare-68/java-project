
package JFrame;

import company.Tools;
import controls.JMyButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class frmMain extends JFrame {

  
    private JFrame frame;
    private JMyButton btnDept;
    private JMyButton btnEmp;
    private JMyButton btnEmp1;
    private JMyButton btnExit;
    private JMyButton btnReports;
    private JMyButton btnWorkOn;
    private JLabel jLabel1;
   
    
    public frmMain(String title) {
        
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
      pack();
      
        los();
    }

    private void los() {

        frame = new JFrame("forms");
        jLabel1 = new JLabel();
        btnExit = new JMyButton();
        btnDept = new JMyButton();
        btnEmp = new JMyButton();
        btnEmp1 = new JMyButton();
        btnWorkOn = new JMyButton();
        btnReports = new JMyButton();

      Container maincontainer = this.getContentPane();
       maincontainer.setLayout(new BorderLayout(8,5));
        
       maincontainer.setBackground(Color.yellow);
       this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE)); 
        
//-------------------------------------------------------------------------------------

//panel top
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,3));
        topPanel.setBackground(Color.ORANGE);
        topPanel.setLayout(new FlowLayout(5));
        
        frame.add(topPanel);
        topPanel.add(jLabel1);
        
        
        maincontainer.add(topPanel,BorderLayout.PAGE_START);

//------------------------------------------------------------------------------------
//panel middle
        
        JPanel middlepanel = new JPanel();
        middlepanel.setBorder(new LineBorder(Color.BLACK,3));
        middlepanel.setLayout(new FlowLayout(5,5,5));
        middlepanel.setBackground(Color.RED);
        
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4,1,10,10));
        gridPanel.setBorder(new LineBorder(Color.BLACK,3));
        gridPanel.setBackground(Color.CYAN);
        
         frame.add(gridPanel);
        
        gridPanel.add(btnDept);
        gridPanel.add(btnEmp);
        gridPanel.add(btnEmp1);
        
        gridPanel.add(btnWorkOn);
        
        gridPanel.add(btnReports);
       // gridPanel.add(btnExit);
        middlepanel.add(gridPanel);
        maincontainer.add(middlepanel,BorderLayout.CENTER);

//-----------------------------------------------------------------------------------


        //panelbottom
        
        JPanel bottompanel = new JPanel();
        bottompanel.setLayout(new FlowLayout(3));
       
        bottompanel.add(btnExit);
         
        bottompanel.setBackground(Color.MAGENTA);
        bottompanel.setBorder(new LineBorder(Color.BLACK,3));
        maincontainer.add(bottompanel,BorderLayout.PAGE_END);

//-------------------------------------------------------------------------------------
        jLabel1.setFont(new Font("Tahoma", 1, 18)); 
        jLabel1.setText("Alfatraining Kurs");

     //------------------------------------------------------------------------------------- by anonymaus  
        btnExit.setText("Ausgang");
        btnExit.setFont(new Font("Tahoma", 1, 14));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnExit(evt);
            }
        });
    //-----------------------------------------------------------------------------------------
        btnDept.setText("Kurs ");
        btnDept.setFont(new Font("Tahoma", 1, 14)); 
        btnDept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnDept(evt);
            }
        });
    //-----------------------------------------------------------------------------------------
        btnEmp.setText("Teilnehmer ");
        btnEmp.setFont(new Font("Tahoma", 1, 14));
        btnEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnEmp(evt);
            }
        });
    //-------------------------------------------------------------------------------------------
        btnEmp1.setText("Projekt ");
        btnEmp1.setFont(new Font("Tahoma", 1, 14));
        btnEmp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnEmp1(evt);
            }
        });
    //--------------------------------------------------------------------------------------------
        btnWorkOn.setText("Projekt bearbeiten ");
        btnWorkOn.setFont(new Font("Tahoma", 1, 14));
        btnWorkOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnWorkOn(evt);
            }
        });
    //-----------------------------------------------------------------------------------------------
        btnReports.setText("Berichte");
        btnReports.setFont(new Font("Tahoma", 1, 14));
        btnReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnReports(evt);
            }
        });
        
        
        //------------------------------------------------------------------------------------------------------

        pack();
    }

    
    //---------------------------------------------------------------------------------------------------------------------------
    private void btnExit(ActionEvent evt) {
        System.exit(0);
    }
//--------------------------------------------------------------------------
    private void btnDept(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmDepartment("Kurs Formular"));
        
    }
//--------------------------------------------------------------------------------
    private void btnEmp(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmEmployee("Teilnehmer Formular"));
    }
//---------------------------------------------------------------------------------
    private void btnEmp1(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmProject("Projekt Formular"));
    }
//-------------------------------------------------------------------------------------
    private void btnWorkOn(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmWorkOn("Projekt Bearbeiten"));
    }
//--------------------------------------------------------------------------------------
    private void btnReports(ActionEvent evt) {
        this.dispose();
        frmReports f = new frmReports("Berichten");
        Tools.openForm(f);
        
    }
//--------------------------------------------------------------------------------------
  
}
