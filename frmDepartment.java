 
package JFrame;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import Entity.Department;
import company.Tools;
import controls.JMyButton;
import controls.JTextBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class frmDepartment extends JFrame {

    private static final long serialVersionUID = 1L;

   
    private JFrame frame;
    private  JMyButton btnAdd;
    private  JMyButton btnAll;
    private  JMyButton btnBack;
    private  JMyButton btnClear;
    private  JMyButton btnDelete;
    private  JMyButton btnFind;
    private  ButtonGroup btnGroup;
    private  JMyButton btnSearch;
    private  JMyButton btnUpdate;
    private  JLabel jLabel1;
    private  JLabel jLabel2;
    private  JLabel jLabel3;
    private  JLabel jLabel4;
    private  JLabel jLabel6;
    private  JScrollPane jScrollPane1;
    private  JRadioButton rdoLocation;
    private  JRadioButton rdoName;
    private  JRadioButton rdoNumber;
    private  JTable tblDept;
    private  JTextField txtDeptNO;
    private  JTextField txtDeptName;
    private  JTextField txtLocation;
    private  JTextField txtSearch;
    private  JTextArea area ;
    
    
    
   //-------------------------------------------------------------------- constractor
    
    public frmDepartment(String title) {
       
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        pack();
        los();
    }

   //-------------------------------------------------------------------------
    
    private void los() {
        
       
       frame = new JFrame("department");
        btnGroup = new ButtonGroup();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        txtDeptNO = new JTextBox(20);
        txtDeptName = new JTextBox(20);
        txtLocation = new JTextBox(20);
        btnAdd = new controls.JMyButton();
        btnUpdate = new JMyButton();
        btnDelete = new JMyButton();
        btnFind = new JMyButton();
        btnAll = new JMyButton();
        btnClear = new JMyButton();
        btnBack = new JMyButton();
        rdoNumber = new JRadioButton();
        rdoName = new JRadioButton();
        rdoLocation = new JRadioButton();
        txtSearch = new JTextBox(15);
        btnSearch = new JMyButton();
        jScrollPane1 = new JScrollPane();
        tblDept = new JTable();
        jLabel6 = new JLabel();
        
        
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
        
        topPanel.add(rdoNumber);
        
        topPanel.add(rdoName);
        
        topPanel.add(rdoLocation);
       
        topPanel.add(btnBack);
        
        
        
        maincontainer.add(topPanel,BorderLayout.NORTH);
       
        
        
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
        gridPanel.add(jLabel1);
        gridPanel.add(txtDeptNO);
        gridPanel.add(jLabel2);
        gridPanel.add(txtDeptName);
        gridPanel.add(jLabel3);
        gridPanel.add(txtLocation);
        
        
    //-----------------------------------------------------table daxayna naw scrollpanelawa    
        jScrollPane1.setViewportView(tblDept);
        
        jScrollPane1.setOpaque(true);
        jScrollPane1.setBorder(new LineBorder(Color.BLACK,3));
        
        frame.add(middlepanel);
        middlepanel.add(gridPanel);
        maincontainer.add(jScrollPane1);
        maincontainer.add(middlepanel,BorderLayout.WEST);
        jScrollPane1.add(tblDept);
     //--------------------------------------------------------------------   
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

   //-----------------------------------------------------------------------------     
        btnGroup.add(rdoNumber);
        btnGroup.add(rdoName);
        btnGroup.add(rdoLocation);
        clearData();
        dept.getAllRows(tblDept);
        //kodek bo away headere tableka nagordret u la gee xoy..............................
        tblDept.getTableHeader().setReorderingAllowed(false);
        
        
     //------------------------------------------------   
        
      

       //---------------------------------------------------- 
        
        
        jLabel1.setFont(new Font("Tahoma", 1, 14)); 
        jLabel1.setText("KursNummer:");

        jLabel2.setFont(new Font("Tahoma", 1, 14)); 
        jLabel2.setText("KursName und Dauer:");

        jLabel3.setFont(new Font("Tahoma", 1, 14)); 
        jLabel3.setText("Bildungszentrum:");

        jLabel4.setFont(new Font("Tahoma", 1, 24)); 
        jLabel4.setText("Abteilung Bilden");

        txtDeptNO.setEditable(false);
//-----------------------------------------------------------------------
        txtDeptName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtDeptName(evt);
            }
        });
//---------------------------------------------------------------------
        btnAdd.setText("Hinzufügen");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAdd(evt);
            }
        });
//--------------------------------------------------------------------
        btnUpdate.setText("Aktualisieren");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnUpdate(evt);
            }
        });
//--------------------------------------------------------------------
        btnDelete.setText("Löschen");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnDelete(evt);
            }
        });
//-------------------------------------------------------------------------
        btnFind.setText("Finden");
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnFind(evt);
            }
        });
//------------------------------------------------------------------------
        btnAll.setText("Alle");
        btnAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAll(evt);
            }
        });
//----------------------------------------------------------------------------
        btnClear.setText("klar");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnClear(evt);
            }
        });
//--------------------------------------------------------------------------
        btnBack.setText("Zurück");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnBack(evt);
            }
        });
//----------------------------------------------------------------------------
        rdoNumber.setBackground(new Color(255, 255, 255));
        rdoNumber.setSelected(true);
        rdoNumber.setText("KursNummer");

        rdoName.setBackground(new Color(255, 255, 255));
        rdoName.setText("KursName");

        rdoLocation.setBackground(new Color(255, 255, 255));
        rdoLocation.setText("Bildungszentrum");

        btnSearch.setText("Suche");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnSearch(evt);
            }
        });
//-----------------------------------------------------------------------------
        tblDept.setModel(new DefaultTableModel(
            new Object [][] { },new String [] {"KursNummer", "KursName und Dauer", "Bildungszentrum "})
         
            {
                
            boolean[] canEdit = new boolean [] {false, false, false };
                
           

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            });
        tblDept.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tblDeptMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDept);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel6.setText("Suche nach:");

       
        
      
     //---------------------------------------------------------------------------------------------------------------------setVerticalGroup   
       
     //----------------------------------------------------------------------------------------------------------
        
        pack();
   
        //-----------------------------------------------------------------------------
    }

    private void txtDeptName(ActionEvent evt) {
        
    }
//----------------------------------------------------------------------------------
//methode back...................................
    private void btnBack(ActionEvent evt) {
        this.dispose();
        
        Tools.openForm(new frmMain("Alfatraining Formular"));
    }
    
    
  //----------------------------------------------------------------------  
    
//methode clear................................................
    
    //sarata object bo department drust dakayn............................
    Department dept = new Department();
   //lera methode bo clear drust dakayn bo away la hamu shwenek ba asane bange bkayn......................... 
    public void clearData(){
    
    Tools.clearText(this);
    txtDeptNO.setText(dept.getAutoNumber());
    btnAdd.setEnabled(true);
    btnUpdate.setEnabled(false);
    btnDelete.setEnabled(false);
    txtDeptName.requestFocus();
    
    }
    
    //----------------------------------------------------------------
    
    
    
    
    //lera bange methodaka dakayn bo away clear eshbkat............................
    private void btnClear(ActionEvent evt) {
       clearData(); 
    }
    
    
    //-------------------------------------------------------------------

    //sarata methodek drust dakayn bo eshkrdn lasar add u update u delete...............................................
    private void setValues(){
        dept.setDeptNO(Integer.parseInt(txtDeptNO.getText()));
        dept.setDeptName(txtDeptName.getText());
        dept.setLocation(txtLocation.getText());
    
    }
  //------------------------------------------------------------------------------  
    //lerada bange methode add dakayn bo jebaje krdn bam shywaya......................................
    private void btnAdd(ActionEvent evt) {
        
        setValues();
        dept.add();
        clearData();
        dept.getAllRows(tblDept);
    }

    //-----------------------------------------------------------------
    
    private void btnUpdate(ActionEvent evt) {
        setValues();
        dept.update();
        clearData();
        dept.getAllRows(tblDept);
    }
    
    
    //------------------------------------------------------------------

    private void btnDelete(ActionEvent evt) {
        if(Tools.confirmMsg("Möchten Sie löschen ?")){
        setValues();
        dept.delete();
        clearData();
        dept.getAllRows(tblDept);
        }
    }

   //--------------------------------------------------------------- 
    
    private void btnFind(ActionEvent evt) {
        String strDeptNO = (String)Tools.InputBox("Geben Sie die KursNummer ein\n" +
"");
        int DeptNO = Integer.parseInt(strDeptNO);
        dept.setDeptNO(DeptNO);
        dept.getOneRow(tblDept);
    }

   //------------------------------------------------------------------- 
    
    private void btnAll(ActionEvent evt) {
        dept.getAllRows(tblDept);
    }
    
    //---------------------------------------------------------------------
    
//methodek bo away ka klikt lasar rowk krd la xanakane baranbar darbchet ka xanay daxel krdne dataya........
    private void tblDeptMouseClicked(MouseEvent evt) {
        try{
        
            int row = tblDept.getSelectedRow();
            
            String strNO = tblDept.getValueAt(row, 0).toString();
            String strName = tblDept.getValueAt(row, 1).toString();
            String strLoc = tblDept.getValueAt(row, 2).toString();
            
            txtDeptNO.setText(strNO);
            txtDeptName.setText(strName);
            txtLocation.setText(strLoc);
            
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            
            
            
        
        }
        catch(Exception ex){
        
        Tools.msgBox(ex.getMessage());
        }
    }
    
  //-------------------------------------------------------------------------  
    
    
//methode taybat ba search ba naw yan zhmara yan location........................................
    private void btnSearch(ActionEvent evt) {
        
        String strSearch = "select * from department_data where ";
        if(rdoNumber.isSelected()){
        
            strSearch += "department_no";
            
        }
        else if(rdoName.isSelected()){
        
            strSearch += "department";
        }
        else{
        
        strSearch += "location";
        }
        
        strSearch += " like'%" + txtSearch.getText() + "%'";
        dept.getCustomRows(strSearch, tblDept);
    }

   } 
    
    
    
    
  