
package JFrame;

import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import Entity.Department;
import Entity.Project;
import company.Tools;
import controls.JMyButton;
import controls.JMyCombo;
import controls.JTextBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class frmProject extends JFrame {

    private JFrame frame;
    private JMyButton btnAdd;
    private JMyButton btnAddDept;
    private JMyButton btnAll;
    private JMyButton btnBack;
    private JMyButton btnClear;
    private JMyButton btnDelete;
    private JMyButton btnFind;
    private ButtonGroup btnGroup;
    private JMyButton btnSearch;
    private JMyButton btnUpdate;
    private JMyCombo cbxDept;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JRadioButton rdoDepartment;
    private JRadioButton rdoLocation;
    private JRadioButton rdoName;
    private JRadioButton rdoProjectNO;
    private JTable tblProject;
    private JTextField txtLocation;
    private JTextField txtProjectNO;
    private JTextField txtProjectName;
    private JTextField txtSearch;
   
    
    
    public frmProject(String title) {
        
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
      pack();
        
        los();
    }

    private void los() {

        frame = new JFrame("project");
        btnGroup = new ButtonGroup();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        txtProjectNO = new JTextBox(20);
        txtProjectName = new JTextBox(20);
        txtLocation = new JTextBox(20);
        cbxDept = new JMyCombo();
        btnAdd = new JMyButton();
        btnUpdate = new JMyButton();
        btnDelete = new JMyButton();
        btnFind = new JMyButton();
        btnAll = new JMyButton();
        btnClear = new JMyButton();
        btnBack = new JMyButton();
        jLabel6 = new JLabel();
        rdoProjectNO = new JRadioButton();
        rdoName = new JRadioButton();
        rdoLocation = new JRadioButton();
        rdoDepartment = new JRadioButton();
        jScrollPane1 = new JScrollPane();
        tblProject = new JTable();
        txtSearch = new JTextBox(30);
        btnSearch = new JMyButton();
        btnAddDept = new JMyButton();
        
        
         
        Container maincontainer = this.getContentPane();
        maincontainer.setLayout(new BorderLayout(8,5));
        
        maincontainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE));

        
      
        //panel top
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,3));
        topPanel.setBackground(Color.ORANGE);
        topPanel.setLayout(new FlowLayout(5));
        
        frame.add(topPanel);
        topPanel.add(btnSearch);
        topPanel.add(txtSearch);
        topPanel.add(rdoProjectNO);
        topPanel.add(rdoName);
        topPanel.add(rdoLocation);
        //topPanel.add(rdoDepartment);
        maincontainer.add(topPanel,BorderLayout.NORTH);
       
 //----------------------------------------------------------------------------------
 
 //panel middle
        
        JPanel middlepanel = new JPanel();
        middlepanel.setBorder(new LineBorder(Color.BLACK,3));
        middlepanel.setLayout(new FlowLayout(5,5,5));
        middlepanel.setBackground(Color.RED);
        
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(16,10,10,10));
        gridPanel.setBorder(new LineBorder(Color.BLACK,3));
        gridPanel.setBackground(Color.CYAN);
        
        
        frame.add(gridPanel);
        gridPanel.add(jLabel2);
        gridPanel.add(txtProjectNO);
        gridPanel.add(jLabel3);
        gridPanel.add(txtProjectName);
        gridPanel.add(jLabel4);
        gridPanel.add(txtLocation);
        gridPanel.add(jLabel5);
        gridPanel.add(cbxDept);
        gridPanel.add(btnAddDept);
        
             
    //-----------------------------------------------------table daxayna naw scrollpanelawa    
        jScrollPane1.setViewportView(tblProject);
        
        jScrollPane1.setOpaque(true);
        jScrollPane1.setBorder(new LineBorder(Color.BLACK,3));
        
        frame.add(middlepanel);
        middlepanel.add(gridPanel);
        maincontainer.add(jScrollPane1);
        maincontainer.add(middlepanel,BorderLayout.WEST);
        jScrollPane1.add(tblProject);
     //-------------------------------------------------------------------- 
        
         //kode ba groupkrdne radio buttonakan.........
        btnGroup.add(rdoProjectNO);
        btnGroup.add(rdoName);
        btnGroup.add(rdoLocation);
        btnGroup.add(rdoDepartment);
     // ..............................................  
        db.go.fillCombo("Department", "DeptName", cbxDept);
        
        proj.getAllRows(tblProject);
        clearData();
        
        tblProject.getTableHeader().setReorderingAllowed(false);
    //------------------------------------------------------------------------    
        
     //panelbottom
        
        JPanel bottompanel = new JPanel();
        bottompanel.setLayout(new FlowLayout(3));
        frame.add(bottompanel);
        bottompanel.add(btnAdd);
        bottompanel.add(btnUpdate);
        bottompanel.add(btnDelete);
        bottompanel.add(btnFind);
        bottompanel.add(btnAll);
        bottompanel.add(btnClear);
        bottompanel.add(btnBack);
        bottompanel.setBackground(Color.MAGENTA);
        bottompanel.setBorder(new LineBorder(Color.BLACK,3));
        maincontainer.add(bottompanel,BorderLayout.SOUTH); 
//---------------------------------------------------------------------------------
    
        jLabel1.setFont(new Font("Tahoma", 1, 24)); 
        jLabel1.setText("Project Form");

        jLabel2.setFont(new Font("Tahoma", 1, 14)); 
        jLabel2.setText("Projekt Nummer :");

        jLabel3.setFont(new Font("Tahoma", 1, 14)); 
        jLabel3.setText("Projekt Name :");

        jLabel4.setFont(new Font("Tahoma", 1, 14)); 
        jLabel4.setText("Projekt Dauer :");

        jLabel5.setFont(new Font("Tahoma", 1, 14));
        jLabel5.setText("Wählen Sie den Kurs :");

        txtProjectNO.setEditable(false);
//--------------------------------------------------------------------------------
        btnAdd.setText("Hinzufügen");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAdd(evt);
            }
        });
//----------------------------------------------------------------------------------
        btnUpdate.setText("Aktualisieren");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnUpdate(evt);
            }
        });
//---------------------------------------------------------------------------------
        btnDelete.setText("Löschen");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDelete(evt);
            }
        });
//---------------------------------------------------------------------------------
        btnFind.setText("Finden");
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFind(evt);
            }
        });
//--------------------------------------------------------------------------------------
        btnAll.setText("Alle");
        btnAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAll(evt);
            }
        });
//-------------------------------------------------------------------------------------
        btnClear.setText("klar");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnClear(evt);
            }
        });
//-----------------------------------------------------------------------------------
        btnBack.setText("Zurück");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBack(evt);
            }
        });
//---------------------------------------------------------------------------------
        jLabel6.setFont(new Font("Tahoma", 1, 14)); 
        jLabel6.setText("Search By :");

        rdoProjectNO.setBackground(new Color(255, 255, 255));
        rdoProjectNO.setSelected(true);
        rdoProjectNO.setText("ProjektNummer");

        rdoName.setBackground(new Color(255, 255, 255));
        rdoName.setText("ProjektName");

        rdoLocation.setBackground(new Color(255, 255, 255));
        rdoLocation.setText("ProjektDauer");

        rdoDepartment.setBackground(new Color(255, 255, 255));
        rdoDepartment.setText("Kurs");
//------------------------------------------------------------------------------------------
        tblProject.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProjektNummer", "ProjektName", "ProjektDauer","KursNummer " ,"KursName und Dauer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
    //---------------------------------------------------------------------------------    
        tblProject.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblProjectMouseClicked(evt);
            }
        });
        
    //-------------------------------------------------------------------------    
        jScrollPane1.setViewportView(tblProject);

        btnSearch.setText("Suchen");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSearch(evt);
            }
        });
//----------------------------------------------------------------------------------
        btnAddDept.setText("Kurs Hinzufügen");
        btnAddDept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddDept(evt);
            }
        });

//---------------------------------------------------------------------------------------
        pack();
    }
//--------------------------------------------------------------------------------------------    

    //-------------------------------------------------------------------------------------------
//bo barmaja krdne  bottone methode add department objekt la daraway fanctionakay ta3ref dakayn......
    Department dept = new Department();
 //obektek bo projekt drust dakayn chunka bo buttone clear u awane tr pewest dabet........
    Project proj = new Project();
    private void btnAddDept(ActionEvent evt) {//GEN-FIRST:event_btnAddDeptActionPerformed
        
        int DeptNO = Integer.parseInt( dept.getAutoNumber() );
        String DeptName = (String) Tools.InputBox("Geben Sie den KursName ein");
        String Location = (String) Tools.InputBox("Ort eingeben");
        
        dept.setDeptNO(DeptNO);
        dept.setDeptName(DeptName);
        dept.setLocation(Location);
        dept.add();
        
        db.go.fillCombo("Department", "DeptName", cbxDept);
    }
    
    //------------------------------------------------------------------------------------
//barmaja krdne bottone back la forme projekt....................................
    private void btnBack(java.awt.event.ActionEvent evt) {
        
        this.dispose();
        Tools.openForm(new frmMain("Alfatraining Formular"));
    }
    //---------------------------------------------------------------------------------------
//barmaja krdne buttone clear la forme projekt......................................
    //sarata methodeke bo drust dakayn la darawa bo away ba assane la hamu shwenek bange bkayn......
    private void clearData(){
    
        Tools.clearText(this);
        txtProjectNO.setText(proj.getAutoNumber());
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        txtProjectName.requestFocus();
    
    }
    private void btnClear(java.awt.event.ActionEvent evt) {
        //pashan lerada ba assane bange methodaka dakayn ka drustman krdwa la sare............
        clearData();
    }
    
 //----------------------------------------------------------------------------------------------   
//bo // bo barmaja krdne buttone add sarata methodek drust dakayn la saraway faunktionaka bo away ba assane bange bkayn......
    private void setValues(){
    
        int ProjectNO = Integer.parseInt(txtProjectNO.getText());
        String ProjectName = txtProjectName.getText();
        String Location = txtLocation.getText();
        
        String DeptName = cbxDept.getSelectedItem().toString();
        int DeptNO = Integer.parseInt(dept.getValueByName(DeptName));
        
        
        proj.setProjectNO(ProjectNO);
        proj.setProjectName(ProjectName);
        proj.setLocation(Location);
        proj.setDeptNO(DeptNO);
    
    }
 //------------------------------------------------------------------------------------   
    private void btnAdd(ActionEvent evt) {
      //lerada ba assany bange methodaka dakayn u bas.........  
        setValues();
        proj.add();
        clearData();
        //am koda bo prkrdnaway jadwalakaya la hamu buttonakan bange dakayn ........
        proj.getAllRows(tblProject);
    }
//----------------------------------------------------------------------------------------
    private void btnUpdate(ActionEvent evt) {
        //lerada ba assane methode setvalues bakar dennen bo upadatesh..................
        setValues();
        proj.update();
        clearData();
        proj.getAllRows(tblProject);
    }
//-------------------------------------------------------------------------------------
    private void btnDelete(ActionEvent evt) {
        //lerashda ba assane methode setvalues bakar denen u bass...............
        if(Tools.confirmMsg("Möchten Sie löschen ?")){
        setValues();
        proj.delete();
        clearData();
        //lerash rwoakan pr dakaynawa chunka la dway add update delet bayanat dagoret boya dabet law 3 jegay am koda bnusen.....
        proj.getAllRows(tblProject);
        }
    }
//------------------------------------------------------------------------------------    
    
//barmajay buttone find...........................................................
    private void btnFind(ActionEvent evt) {
        String strProjNO = (String)Tools.InputBox("Geben Sie die ProjektNummer ein");
        int ProjectNO =Integer.parseInt(strProjNO);
        proj.setProjectNO(ProjectNO);
        proj.getOneRow(tblProject);
        
    }
//----------------------------------------------------------------------------------------
    private void btnAll(ActionEvent evt) {
        proj.getAllRows(tblProject);
    }
 //---------------------------------------------------------------------------------------   
    
//lerada methode henane hamu ma3lumate naw table bo xanay dastkare krdn drust dakayn bo away btwanen update yan delet lasar datakan bkayn....
    private void tblProjectMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tblProjectMouseClicked
        try{
        
            int row = tblProject.getSelectedRow();
            String ProjNO = tblProject.getValueAt(row, 0).toString();
            String ProjName = tblProject.getValueAt(row, 1).toString();
            String Location = tblProject.getValueAt(row, 2).toString();
            String DeptName = tblProject.getValueAt(row, 4).toString();
            
            txtProjectNO.setText(ProjNO);
            txtProjectName.setText(ProjName);
            txtLocation.setText(Location);
            cbxDept.setSelectedItem(DeptName);
            
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            
        }
        catch(Exception ex){
        Tools.msgBox(ex.getMessage());
        }
    }
  //----------------------------------------------------------------------------------  
    
//methode u kode search krdn la table project.........................................
    private void btnSearch(ActionEvent evt) {
        String strSearch = "select * from Project_Data where ";
        if(rdoProjectNO.isSelected()){
            strSearch += "Project_NO";
        
        }
        else if(rdoName.isSelected()){
        strSearch += "Project_Name";
        }
        else if(rdoLocation.isSelected()){
        
        strSearch += "Location";
        }
        else{
        
            strSearch += "Department";
        }
        strSearch += " like'%" + txtSearch.getText() + "%'";
        
        proj.getCustomRows(strSearch, tblProject);
    }
    
 //---------------------------------------------------------------------------   

}
