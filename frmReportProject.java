
package JFrame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import company.Tools;
import controls.JMyButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class frmReportProject extends JFrame {

    private JFrame frame;
    private JMyButton btnBack;
    private JMyButton btnPrint;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable tblProject;
    
    
    public frmReportProject(String title) {
        
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        pack();
        los();
    }

 //=====================================================================================================   
    private void los() {

        frame = new JFrame("Project");
        jScrollPane1 = new JScrollPane();
        tblProject = new JTable();
        jLabel1 = new JLabel();
        btnPrint = new JMyButton();
        btnBack = new JMyButton();
//-----------------------------------------------------------------------------------------------
      
        Container maincontainer = this.getContentPane();
        maincontainer.setLayout(new BorderLayout(8,5));
        
        maincontainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE));
//----------------------------------------------------------------------------------


//panel top
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,3));
        topPanel.setBackground(Color.ORANGE);
        topPanel.setLayout(new FlowLayout(5));
        
        frame.add(topPanel);
        topPanel.add(jLabel1);
        maincontainer.add(topPanel,BorderLayout.NORTH);
 //------------------------------------------------------------------------------------------      
       
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(1,0,0,0));
        gridPanel.setBorder(new LineBorder(Color.RED,0));
        gridPanel.setBackground(Color.CYAN);
   
        frame.add(gridPanel);
        
        jScrollPane1.setViewportView(tblProject);               //to fill table.................................
        
        jScrollPane1.setOpaque(true);
        jScrollPane1.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
        gridPanel.add(jScrollPane1);
        maincontainer.add(jScrollPane1);
        maincontainer.add(gridPanel,BorderLayout.SOUTH);
        jScrollPane1.add(tblProject);
     //-------------------------------------------------------------------- 
        
        //panelbottom
        
        JPanel bottompanel = new JPanel();
        bottompanel.setLayout(new FlowLayout(3));
        
        frame.add(bottompanel);
        bottompanel.add(btnBack);
        bottompanel.add(btnPrint);
       
        bottompanel.setBackground(Color.MAGENTA);
        bottompanel.setBorder(new LineBorder(Color.BLACK,3));
        maincontainer.add(bottompanel,BorderLayout.SOUTH); 
        



//--------------------------------------------------------------------------------------------------
        tblProject.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProjektNummer", " ProjektName", "ProjektDauer", "KursNummer", "KursName und Dauer "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProject);
        
        db.go.fillToJTable("Project_Data", tblProject);
        Tools.setReport(tblProject);
        
//-----------------------------------------------------------------------------------

        jLabel1.setFont(new Font("Tahoma", 1, 14)); 
        jLabel1.setText("Projekt Bericht");

        btnPrint.setText("Drucken");
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPrint(evt);
            }
        });
//------------------------------------------------------------------------------------------
        btnBack.setText("Zurück");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBack(evt);
            }
        });
//---------------------------------------------------------------------------------------------
    
        pack();
    }
//======================================================================================================
    private void btnPrint(ActionEvent evt) {

        //bam regaya tanha bange methodaka dakayn ka bo print la naw tools drustman krd.......
        Tools.PrintReport(tblProject, "Projekt");

        
    }
//------------------------------------------------------------------------------------------
    
    private void btnBack(ActionEvent evt) {
        this.dispose();

        Tools.openForm(new frmReports(""));
    }
//--------------------------------------------------------------------------------------------------
 
}
