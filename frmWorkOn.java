
package JFrame;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import Entity.Employee;
import Entity.Project;
import Entity.WorkOn;
import company.Tools;
import controls.JMyButton;
import controls.JMyCombo;
import controls.JTextBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class frmWorkOn extends JFrame {

    private JFrame frame;
    private JMyButton btnAdd;
    private JMyButton btnAll;
    private JMyButton btnBack;
    private JMyButton btnDelete;
    private JMyButton btnFind;
    private ButtonGroup btnGroup;
    private JMyButton btnSearch;
    private JMyCombo cbxEmp;
    private JMyCombo cbxProject;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JScrollPane jScrollPane1;
    private JRadioButton rdoEmpNO;
    private JRadioButton rdoEmpName;
    private JRadioButton rdoProjectNO;
    private JRadioButton rdoProjectName;
    private JTable tblWorkOn;
    private JTextField txtSearch;
    
   
    public frmWorkOn(String title) {
        
        
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        pack();
        
        los();
    }

 //-----------------------------------------------------------------------------------  
    private void los() {

        frame = new JFrame("work on");
        btnGroup = new ButtonGroup();
        
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        cbxEmp = new JMyCombo();
        cbxProject = new JMyCombo();
        btnAdd = new JMyButton();
        btnDelete = new JMyButton();
        btnFind = new JMyButton();
        btnAll = new JMyButton();
        btnBack = new JMyButton();
        jLabel4 = new JLabel();
        rdoEmpNO = new JRadioButton();
        rdoEmpName = new JRadioButton();
        rdoProjectNO = new JRadioButton();
        rdoProjectName = new JRadioButton();
        txtSearch = new JTextBox(30);
        btnSearch = new JMyButton();
        jScrollPane1 = new JScrollPane();
        tblWorkOn = new JTable();
        
          
        Container maincontainer = this.getContentPane();
        maincontainer.setLayout(new BorderLayout(8,5));
        
        maincontainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE));
//------------------------------------------------------------------------------------------

 //panel top
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,10));
        topPanel.setBackground(Color.ORANGE);
        topPanel.setLayout(new FlowLayout(5));
        
        frame.add(topPanel);
        topPanel.add(btnSearch);
        topPanel.add(txtSearch);
        topPanel.add(rdoEmpNO);
        topPanel.add(rdoEmpName);
        topPanel.add(rdoProjectNO);
        topPanel.add(rdoProjectName);
        
        maincontainer.add(topPanel,BorderLayout.NORTH);
       
 //----------------------------------------------------------------------------------
       
 //panel middle
        
        JPanel middlepanel = new JPanel();
        middlepanel.setBorder(new LineBorder(Color.BLACK,10));
        middlepanel.setLayout(new FlowLayout(5,5,5));
        middlepanel.setBackground(Color.RED);
        
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(13,1,10,10));
        gridPanel.setBorder(new LineBorder(Color.BLACK,6));
        gridPanel.setBackground(Color.CYAN);
        
        
        frame.add(gridPanel);
        gridPanel.add(jLabel2);
        gridPanel.add(cbxEmp);
        gridPanel.add(jLabel3);
        gridPanel.add(cbxProject);
        
        
        //-----------------------------------------------------table daxayna naw scrollpanelawa    
        jScrollPane1.setViewportView(tblWorkOn);
        
        jScrollPane1.setOpaque(true);
        jScrollPane1.setBorder(new LineBorder(Color.BLACK,10));
        
        frame.add(middlepanel);
        middlepanel.add(gridPanel);
        maincontainer.add(jScrollPane1);
        maincontainer.add(middlepanel,BorderLayout.WEST);
        jScrollPane1.add(tblWorkOn);
     //-------------------------------------------------------------------- 
       
     
//panelbottom
        
        JPanel bottompanel = new JPanel();
        bottompanel.setLayout(new FlowLayout(3));
        frame.add(bottompanel);
        bottompanel.add(btnAdd);
        
        bottompanel.add(btnDelete);
        bottompanel.add(btnFind);
        bottompanel.add(btnAll);
        
        bottompanel.add(btnBack);
        bottompanel.setBackground(Color.MAGENTA);
        bottompanel.setBorder(new LineBorder(Color.BLACK,3));
        maincontainer.add(bottompanel,BorderLayout.SOUTH); 
//---------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
 //kode ba group krdne radio buttonakan lerada dakayn........ 
        btnGroup.add(rdoEmpNO);
        btnGroup.add(rdoEmpName);
        btnGroup.add(rdoProjectNO);
        btnGroup.add(rdoProjectName);
        
          
        tblWorkOn.getTableHeader().setReorderingAllowed(false);

//henane nawe employee bo combobox workon..................
        db.go.fillCombo("Employee", "EmpName", cbxEmp);
        //henane nawe projektakan bo combo boxe workon.............
        db.go.fillCombo("Project", "ProjectName", cbxProject);
        
        work.getAllRows(tblWorkOn);
        
      
//-------------------------------------------------------------------------------
        jLabel1.setFont(new Font("Tahoma", 1, 24)); 
        jLabel1.setText("Work On Form");

        jLabel2.setFont(new Font("Tahoma", 1, 14)); 
        jLabel2.setText("Teilnehmer Wählen :");

        jLabel3.setFont(new Font("Tahoma", 1, 14)); 
        jLabel3.setText("Projekt Wählen :");

        btnAdd.setText("Hinzufügen");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAdd(evt);
            }
        });
//------------------------------------------------------------------------------------
        btnDelete.setText("Löschen");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDelete(evt);
            }
        });
//-------------------------------------------------------------------------------------
        btnFind.setText("Finden");
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFind(evt);
            }
        });
//------------------------------------------------------------------------------------
        btnAll.setText("Alle");
        btnAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAll(evt);
            }
        });
//-----------------------------------------------------------------------------------------
        btnBack.setText("Zurück");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBack(evt);
            }
        });
//---------------------------------------------------------------------------------------
        jLabel4.setFont(new Font("Tahoma", 1, 14)); 
        jLabel4.setText("Search By :");

        rdoEmpNO.setBackground(new Color(255, 255, 255));
        rdoEmpNO.setSelected(true);
        rdoEmpNO.setText("Teilnehmer Nummer");

        rdoEmpName.setBackground(new Color(255, 255, 255));
        rdoEmpName.setText("Teilnehmer Name");

        rdoProjectNO.setBackground(new Color(255, 255, 255));
       
        rdoProjectNO.setText("Projekt Nummer");

        rdoProjectName.setBackground(new Color(255, 255, 255));
        rdoProjectName.setText("Projekt Name");

        btnSearch.setText("Suchen");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSearch(evt);
            }
        });
//-------------------------------------------------------------------------------------
        tblWorkOn.setModel(new DefaultTableModel(
            new Object [][] {}, new String [] { "TeilnehmerNummer", "TeilnehmerName", "ProjectNummer", "ProjectName"})

            {
            boolean[] Edit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return Edit [columnIndex];
            }
            });
      
 //-------------------------------------------------------------------------------       
        tblWorkOn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblWorkOnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblWorkOn);
//----------------------------------------------------------------------------------------------------
     pack();
    }
//---------------------------------------------------------------------------------------------------------
   private void btnBack(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmMain("Alfatraining Formular"));
    }
     
//--------------------------------------------------------------------------------------    
//methodek la daree add drust dakay bo bang krdne la naw add ba assane.........
   //sarata object bo harse class drust dakay ka pewesta.....
    Employee emp = new Employee();
    Project proj = new Project();
    WorkOn work = new WorkOn();
    
    private void setValues(){
    
        String EmpName = cbxEmp.getSelectedItem().toString();
        String ProjName = cbxProject.getSelectedItem().toString();
        
        String strEmpNO = emp.getValueByName(EmpName);
        String strProjNO = proj.getValueByName(ProjName);
        
        int EmpNO = Integer.parseInt(strEmpNO);
        int ProjNO = Integer.parseInt(strProjNO);
        
        work.setEmpNO(EmpNO);
        work.setProjectNO(ProjNO);
        
    
    }
    
 //------------------------------------------------------------------------------------------   
    private void btnAdd(ActionEvent evt) {
        
        //awja deen lerada ba assane bange methodaka dakayn bo add krdn......
        setValues();
        work.add();
        //am koda bo awaya ka klikt lasar add krd ma3lumataka daxele naw tableka bet ka lasar shashaya....
        work.getAllRows(tblWorkOn);
    }
 //------------------------------------------------------------------------------------------------   

    private void btnDelete(ActionEvent evt) {
        boolean isConfirm = Tools.confirmMsg("Möchten Sie löschen  ?");
        if(isConfirm){
        setValues();
        work.delete();
        work.getAllRows(tblWorkOn);
        
        }
    }
 //----------------------------------------------------------------------------------------   
//barmaja krdne buttone find............................................
    private void btnFind(ActionEvent evt) {
        String strEmpNO = (String) Tools.InputBox("Geben Sie die TeilnehmerNummer ein");
        String strProjNO = (String) Tools.InputBox("Geben Sie die ProjektNummer ein");
        
        int EmpNO = Integer.parseInt(strEmpNO);
        int ProjNO = Integer.parseInt(strProjNO);
        
        work.setEmpNO(EmpNO);
        work.setProjectNO(ProjNO);
        work.getOneRow(tblWorkOn);
    }
 //---------------------------------------------------------------------------------------   
    
//barmagakrdne buttone all......................................
    private void btnAll(ActionEvent evt) {
        work.getAllRows(tblWorkOn);
    }
//-----------------------------------------------------------------------------------------------
    private void tblWorkOnMouseClicked(MouseEvent evt) {
       //barmaja krdn lerada dakayn bo away klik lasar har rowek bkayn lanaw tableka awa ma3lumatakat la xanay combobox darbchet bo jak krdn...
       try{
       
           int row = tblWorkOn.getSelectedRow();
           String EmpName = tblWorkOn.getValueAt(row, 1).toString();
           String ProjectName = tblWorkOn.getValueAt(row, 3).toString();
           
           cbxEmp.setSelectedItem(EmpName);
           cbxProject.setSelectedItem(ProjectName);
       }
       catch(Exception ex){
       Tools.msgBox(ex.getMessage());
       }
        
    }
 //----------------------------------------------------------------------------------------   
//barmaja krdne buttone search.................................
    private void btnSearch(ActionEvent evt) {
        
        String strSearch = "select * from workon_data where ";
        if(rdoEmpNO.isSelected()){
        
            strSearch += "employee_no";
        
        }
        else if(rdoEmpName.isSelected()){
        
        strSearch += "employee_name";
        }
        else if(rdoProjectNO.isSelected()){
        
        strSearch += "project_no";
        }
        else{
        strSearch += "project_name";
        }
        
        strSearch += " like'%" + txtSearch.getText() + "%'";
        
        
        work.getCustomRows(strSearch, tblWorkOn);
    }

 
}
