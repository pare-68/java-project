

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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class frmReports extends JFrame {

     

    private JFrame frame;
    private JMyButton btnBack;
    private JMyButton btnDeptReport;
    private JMyButton btnEmpReport;
    private JMyButton btnPhonesReport;
    private JMyButton btnProjectReport;
    private JMyButton btnWorkOnReport;
    private JLabel jLabel1;
    

    
    public frmReports(String title) {
        
        
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        pack();
        los();
        
    }
//=========================================================================================
    
  private void los() {

        frame = new JFrame("reports");
        jLabel1 = new JLabel();
        btnDeptReport = new JMyButton();
        btnBack = new JMyButton();
        btnEmpReport = new JMyButton();
        btnPhonesReport = new JMyButton();
        btnProjectReport = new JMyButton();
        btnWorkOnReport = new JMyButton();
        
        
        Container maincontainer = this.getContentPane();
        maincontainer.setLayout(new BorderLayout(8,5));
        
        maincontainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE)); 
//---------------------------------------------------------------------------------------
       

//panel top
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,3));
        topPanel.setBackground(Color.ORANGE);
        topPanel.setLayout(new FlowLayout(5));
        
        frame.add(topPanel);
        topPanel.add(jLabel1);
        
        
        maincontainer.add(topPanel,BorderLayout.PAGE_START);
//------------------------------------------------------------------------------------------


//panel middle
        
        JPanel middlepanel = new JPanel();
        middlepanel.setBorder(new LineBorder(Color.BLACK,10));
        middlepanel.setLayout(new FlowLayout(5,5,5));
        middlepanel.setBackground(Color.RED);
        
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4,1,10,10));
        gridPanel.setBorder(new LineBorder(Color.BLACK,6));
        gridPanel.setBackground(Color.CYAN);
        
         frame.add(gridPanel);
        
        gridPanel.add(btnDeptReport);
        gridPanel.add(btnEmpReport);
        gridPanel.add(btnProjectReport);
        
        gridPanel.add(btnWorkOnReport);
        
        
        middlepanel.add(gridPanel);
        maincontainer.add(middlepanel,BorderLayout.CENTER);
//---------------------------------------------------------------------------------------

        
//panelbottom
        
        JPanel bottompanel = new JPanel();
        bottompanel.setLayout(new FlowLayout(3));
       
        bottompanel.add(btnBack);
         
        bottompanel.setBackground(Color.MAGENTA);
        bottompanel.setBorder(new LineBorder(Color.BLACK,3));
        maincontainer.add(bottompanel,BorderLayout.PAGE_END);


//---------------------------------------------------------------------------------------------------

        jLabel1.setFont(new Font("Tahoma", 1, 18)); 
        jLabel1.setText("Berichten");
//-----------------------------------------------------------------------------------

        btnDeptReport.setText("Kurs Bericht");
        btnDeptReport.setFont(new Font("Tahoma", 1, 14));
        btnDeptReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeptReport(evt);
            }
        });
//-------------------------------------------------------------------------------------
        btnBack.setText("Back");
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBack(evt);
            }
        });
//---------------------------------------------------------------------------------------
        btnEmpReport.setText("Teilnehmer Bericht");
        btnEmpReport.setFont(new Font("Tahoma", 1, 14));
        btnEmpReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEmpReport(evt);
            }
        });
//----------------------------------------------------------------------------------------
 
        btnProjectReport.setText("Projekt Bericht");
        btnProjectReport.setFont(new Font("Tahoma", 1, 14));
        btnProjectReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnProjectReport(evt);
            }
        });
//------------------------------------------------------------------------------------------
        btnWorkOnReport.setText("Project Bearbeiten Bericht");
        btnWorkOnReport.setFont(new Font("Tahoma", 1, 14));
        btnWorkOnReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnWorkOnReport(evt);
            }
        });
//---------------------------------------------------------------------------------------------
        

        pack();
    }
//===============================================================================================
    private void btnBack(ActionEvent evt) {
        this.dispose();

        Tools.openForm(new frmMain("Berichte"));
    }
//-----------------------------------------------------------------
    private void btnDeptReport(ActionEvent evt) {
        
        this.dispose();
        Tools.openForm(new frmReportDept("Kurs Bericht"));
    }
//-------------------------------------------------------------------
    private void btnEmpReport(ActionEvent evt) {
        
        this.dispose();
        Tools.openForm(new frmReportEmp("Teilnehmern Bericht"));
    }
//----------------------------------------------------------------------
    private void btnProjectReport(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmReportProject("Projekt Bericht"));
    }
//---------------------------------------------------------------------------
    private void btnWorkOnReport(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmReportWorkOn("Projekt Bearbeiten"));
    }
//---------------------------------------------------------------------------
   
}
