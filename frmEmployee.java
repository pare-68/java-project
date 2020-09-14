
package JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
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

import Entity.Department;
import Entity.Employee;
import Entity.Employee_Phones;
import company.Tools;
import controls.JMyButton;
import controls.JMyCombo;
import controls.JTextBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class frmEmployee extends JFrame {

    
     private JFrame frame;
    private JMyButton btnAdd;
    private JMyButton btnAddDept;
    private JMyButton btnAddPhone;
    private JMyButton btnAll;
    private JMyButton btnBack;
    private JMyButton btnClear;
    private JMyButton btnDelete;
    private JMyButton btnFind;
    private ButtonGroup btnGroup;
    private JMyButton btnRemovePhones;
    private JMyButton btnSearch;
    private JMyButton btnUpdate;
    private JMyCombo cbxDept;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private Menu menu1;
    private Menu menu2;
    private MenuBar menuBar1;
    private JRadioButton rdoAddress;
    private JRadioButton rdoBirth;
    private JRadioButton rdoDept;
    private JRadioButton rdoHiring;
    private JRadioButton rdoName;
    private JRadioButton rdoNumber;
    private JRadioButton rdoPhone;
    private JRadioButton rdoSalary;
    private JTable tblEmp;
    private JTable tblPhones;
    private JTextField txtAddress;
    private JTextField txtBirthDate;
    private JTextField txtEmpNO;
    private JTextField txtEmpName;
    private JTextField txtHiringDate;
    private JTextField txtPhone;
    private JTextField txtSalary;
    private JTextField txtSearch;
    
    
//-------------------------------------------------------------------------    
    
    public frmEmployee(String title) {
        
        super(title);
        this.setSize(700,300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
      pack();
        
        
        los();
    }
 //-----------------------------------------------------------------------   
  private void los() {

        frame = new JFrame();
        menuBar1 = new MenuBar();
        menu1 = new Menu();
        menu2 = new Menu();
        btnGroup = new ButtonGroup();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txtEmpNO = new JTextBox(15);
        txtEmpName = new JTextBox(15);
        txtAddress = new JTextBox(15);
        txtSalary = new JTextBox(15);
        txtBirthDate = new JTextBox(15);
        txtHiringDate = new JTextBox(15);
        cbxDept = new JMyCombo();
        btnAdd = new JMyButton();
        btnUpdate = new JMyButton();
        btnDelete = new JMyButton();
        btnFind = new JMyButton();
        btnAll = new JMyButton();
        btnClear = new JMyButton();
        btnBack = new JMyButton();
        jLabel9 = new JLabel();
        rdoNumber = new JRadioButton();
        rdoName = new JRadioButton();
        rdoAddress = new JRadioButton();
        rdoSalary = new JRadioButton();
        rdoHiring = new JRadioButton();
        rdoBirth = new JRadioButton();
        rdoDept = new JRadioButton();
        txtSearch = new JTextBox(30);
        btnSearch = new JMyButton();
        btnAddDept = new JMyButton();
        jScrollPane1 = new JScrollPane();
        tblEmp = new JTable();
        jLabel10 = new JLabel();
        txtPhone = new JTextBox(15);
        btnAddPhone = new JMyButton();
        btnRemovePhones = new JMyButton();
        jScrollPane2 = new JScrollPane();
        tblPhones = new JTable();
        rdoPhone = new JRadioButton();

        Container maincontainer = this.getContentPane();
        maincontainer.setLayout(new BorderLayout(8,5));
        
        maincontainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE));
 //-------------------------------------------------------------------       
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
        topPanel.add(rdoAddress);
        topPanel.add(rdoSalary);
        topPanel.add(rdoHiring);
        topPanel.add(rdoPhone);
        topPanel.add(rdoBirth);
        topPanel.add(rdoDept);
        
        maincontainer.add(topPanel,BorderLayout.NORTH);
       
   //--------------------------------------------------------------------------     
    
//panel middle
        
        JPanel middlepanel = new JPanel();
        middlepanel.setBorder(new LineBorder(Color.BLACK,3));
        middlepanel.setLayout(new FlowLayout(5,5,5));
        middlepanel.setBackground(Color.RED);
        
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(10,4,10,10));
        gridPanel.setBorder(new LineBorder(Color.BLACK,3));
        gridPanel.setBackground(Color.CYAN);
        
        
        frame.add(gridPanel);
        
        
        gridPanel.add(jLabel2);
        gridPanel.add(txtEmpNO);
        gridPanel.add(jLabel3);
        gridPanel.add(txtEmpName);
        gridPanel.add(jLabel4);
        gridPanel.add(txtAddress);
        gridPanel.add(jLabel5);
        gridPanel.add(txtSalary);
        gridPanel.add(jLabel6);
        gridPanel.add(txtHiringDate);
        gridPanel.add(jLabel7);
        gridPanel.add(txtBirthDate);
        gridPanel.add(jLabel8);
        gridPanel.add(cbxDept);
        gridPanel.add(btnAddDept);
        gridPanel.add(jLabel10);
        gridPanel.add(btnAddPhone);
        gridPanel.add(txtPhone);
        gridPanel.add(btnRemovePhones);
        
      
        
   //---------------------------------------------------kode table phones    
     
        jScrollPane2.setViewportView(tblPhones);
        jScrollPane2.setOpaque(true);
        jScrollPane2.setBorder(new LineBorder(Color.BLACK,3));
        
        maincontainer.add(jScrollPane2);
       
        jScrollPane2.add(tblPhones);
        middlepanel.add(jScrollPane2);
       
    //-----------------------------------------------------table  tblEmp daxayna naw scrollpanelawa    
        jScrollPane1.setViewportView(tblEmp);
        jScrollPane1.setOpaque(true);
        jScrollPane1.setBorder(new LineBorder(Color.BLACK,3));
        
        frame.add(middlepanel);
        middlepanel.add(gridPanel);
        maincontainer.add(jScrollPane1);
        maincontainer.add(middlepanel,BorderLayout.WEST);
        jScrollPane1.add(tblEmp);
 
        
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
        btnGroup.add(rdoAddress);
        clearData();
        dept.getAllRows(tblEmp);
        //kodek bo away headere tableka nagordret u la gee xoy..............................
        tblEmp.getTableHeader().setReorderingAllowed(false);
        btnGroup.add(rdoNumber);
        btnGroup.add(rdoName);
        btnGroup.add(rdoAddress);
        btnGroup.add(rdoSalary);
        btnGroup.add(rdoHiring);
        btnGroup.add(rdoBirth);
        btnGroup.add(rdoDept);
        btnGroup.add(rdoPhone);
        db.go.fillCombo("department", "DeptName", cbxDept);
        emp.getAllRows(tblEmp);
        //lerada bange cleardata dakayn bo away har ka forme employeeman krdawa yaksar loxoy beta sar namaeka ............
        clearData();
        //kodek bo away xanakan la jee xoyan najulen....................................
        tblEmp.getTableHeader().setReorderingAllowed(false);
        
        tblPhones.getTableHeader().setReorderingAllowed(false);
        
   //---------------------------------------------------------------------------     
        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);
//--------------------------------------------------------------------------------------    
      
  //-------------------------------------------------------------------------------------
        jLabel1.setFont(new Font("Tahoma", 1, 24));
        jLabel1.setText("teilnehmer Form");

        jLabel2.setFont(new Font("Tahoma", 1, 14)); 
        jLabel2.setText("Nummer :");

        jLabel3.setFont(new Font("Tahoma", 1, 14));
        jLabel3.setText("Name :");

        jLabel4.setFont(new Font("Tahoma", 1, 14));
        jLabel4.setText("Email :");

        jLabel5.setFont(new Font("Tahoma", 1, 14)); 
        jLabel5.setText("Firma :");

        jLabel6.setFont(new Font("Tahoma", 1, 14)); 
        jLabel6.setText("Ort :");

        jLabel7.setFont(new Font("Tahoma", 1, 14)); 
        jLabel7.setText("Beruf :");

        jLabel8.setFont(new Font("Tahoma", 1, 14));
        jLabel8.setText("kurs  :");

        txtEmpNO.setEditable(false);
//------------------------------------------------------------------
        txtEmpName.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtEmpName(evt);
            }
        });
//----------------------------------------------------------------------
        txtSalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtSalary(evt);
            }
        });
//-------------------------------------------------------------------------
        btnAdd.setText("Hinzufugen");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
//------------------------------------------------------------------------
        btnUpdate.setText("Aktualisieren");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnUpdate(evt);
            }
        });
//----------------------------------------------------------------------------
        btnDelete.setText("Löschen");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnDelete(evt);
            }
        });
//------------------------------------------------------------------------------
        btnFind.setText("Finden");
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnFind(evt);
            }
        });
//-----------------------------------------------------------------------------
        btnAll.setText("Alle");
        btnAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAll(evt);
            }
        });
//----------------------------------------------------------------------------------
        btnClear.setText("klar");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnClear(evt);
            }
        });
//--------------------------------------------------------------------------------
        btnBack.setText("Zurück");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnBack(evt);
            }
        });
//------------------------------------------------------------------------------
        jLabel9.setBackground(new Color(255, 255, 255));
        jLabel9.setFont(new Font("Tahoma", 1, 14)); 
        jLabel9.setText("Search By:");

        rdoNumber.setBackground(new Color(255, 255, 255));
        rdoNumber.setSelected(true);
        rdoNumber.setText("Nummer");

        rdoName.setBackground(new Color(255, 255, 255));
         
        rdoName.setText("Name");

        rdoAddress.setBackground(new Color(255, 255, 255));
        rdoAddress.setText("Email");

        rdoSalary.setBackground(new Color(255, 255, 255));
        rdoSalary.setText("Firma");

        rdoHiring.setBackground(new Color(255, 255, 255));
        rdoHiring.setText("Ort");

        rdoBirth.setBackground(new Color(255, 255, 255));
        rdoBirth.setText("Beruf");

        rdoDept.setBackground(new Color(255, 255, 255));
        rdoDept.setText("Kurs");
//---------------------------------------------------------------
        btnSearch.setText("Suchen");
        
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnSearch(evt);
            }
        });
//-------------------------------------------------------------------
        btnAddDept.setText("Kurs hinzufügen");
        btnAddDept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAddDept(evt);
            }
        });
        
        

        tblEmp.setForeground(new Color(35, 27, 23));
        
        
        
     //---------------------------------------------------------------------   
        tblEmp.setModel(new DefaultTableModel(
            new Object [][] {
                //{null, null, null, null, null, null, null, null},
            },
        new String [] {
                "Nummer", "Name", "Email", "Firma", "Ort", "Beruf", "Kurs Nummer", "KursName und Dauer"
            }
        ) 
        
        {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        
     //---------------------------------------------------------------------------   
        
       
        tblEmp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tblEmpMouseClicked(evt);
            }
        });
        
    
        jScrollPane1.setViewportView(tblEmp);
    
     //------------------------------------------------------------------------   
        
        jLabel10.setFont(new Font("Tahoma", 1, 14)); 
        jLabel10.setText("Phone :");
        
        
//---------------------------------------------------------------
        txtPhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtPhone(evt);
            }
        });

      //----------------------------------------------------------------  
        
        btnAddPhone.setText("Phone Hinzufügen");
        btnAddPhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAddPhone(evt);
            }
        });

     //-------------------------------------------------------------   
        
        btnRemovePhones.setText("Phone Entfernen");
        btnRemovePhones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnRemovePhones(evt);
            }
        });

      //-------------------------------------------------------------------  
        
        tblPhones.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teilnehmer Phones"
            }
        ));
        
       
        jScrollPane2.setViewportView(tblPhones);
        
 //-------------------------------------------------------------------------    
    
        rdoPhone.setBackground(new Color(255, 255, 255));
        rdoPhone.setText("Phone");
        
     //----------------------------------------------------------------   

        pack();
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
 //===================================================================================================   
    
   private void txtEmpName(ActionEvent evt) {
       
    }

   private void txtSalary(ActionEvent evt) {
       
   }
 
 //---------------------------------------------------------------------------------------------------------------   
    
//kode add krdne department la forme employee la regay bottonawa.......................
    Department dept = new Department();
    Employee emp = new Employee();
    
    private void btnAddDept(ActionEvent evt) {
       
        int DeptNO = Integer.parseInt(dept.getAutoNumber());
        String DeptName = (String) Tools.InputBox("Geben Sie den KursName ein");
        String Location = (String) Tools.InputBox("Bildungszentrum eingeben");
        dept.setDeptNO(DeptNO);
        dept.setDeptName(DeptName);
        dept.setLocation(Location);
        dept.add();
        db.go.fillCombo("department", "DeptName", cbxDept);
        
    }

//-------------------------------------------------------------------------------------------------------    
    
    private void btnBack(ActionEvent evt) {
        this.dispose();
        Tools.openForm(new frmMain("Alfatraining Formular"));
    }
   
 //-----------------------------------------------------------------------------------------------------------   
    

    private void btnClear(ActionEvent evt) {

        clearData();
    }
 
  //----------------------------------------------------------------------------------------------------------------------
  
  public void Date1() throws ParseException{
  
  }
  
//----------------------------------------------------------------------------------------------------------------------------  
    
//sarata fankshnek bo addy forme employy drust dakay bo away 3unsurakan wargret u bexata naw employee.............
    
    private void setValues(){
    
    emp.setEmpNO( Integer.parseInt(txtEmpNO.getText()) );
    emp.setEmpName(txtEmpName.getText());
    emp.setAddress(txtAddress.getText());
   // emp.setSalary(Integer.parseInt(txtSalary.getText()) );
     emp.setSalary(txtSalary.getText() );
    //emp.setSalary( Double.parseDouble(txtSalary.getText()) );
    emp.setHiringDate(txtHiringDate.getText());
    emp.setBirthDate(txtBirthDate.getText());
  /////////////////////////////////////////
       // kode pedane qemat ba dept no u deptname la forme employee...................................
       String dName = cbxDept.getSelectedItem().toString();
       String dNO = dept.getValueByName(dName);
       emp.setDeptNO( Integer.parseInt(dNO) );  
    }
   
    
   //------------------------------------------------------------------------------------------------------ 
    
    //lerada object bo employee_phones drust dakayn bo away la xwarawa lanaw add barmajay phone bkayn...................
    Employee_Phones phones = new Employee_Phones();
    
    private void btnAddActionPerformed(ActionEvent evt) {
      
          setValues();
          emp.add();
          //barmajakrdne add  phones bo employee lerada dakayn.................................
          phones.setEmpNO( Integer.parseInt( txtEmpNO.getText() ) );
          for(int x = 0 ; x < tblPhones.getRowCount() ; x++){
              
              phones.setPhone( tblPhones.getValueAt(x, 0).toString() );
              phones.add();
              //................................................................................
              
          }
          clearData();
          emp.getAllRows(tblEmp);
      
    }
    
    //-----------------------------------------------------------------------------------------------------

    private void btnUpdate(ActionEvent evt) {
       setValues();
       emp.update();
       //kode tybat ba employee phones.........
        phones.setEmpNO( Integer.parseInt( txtEmpNO.getText() ) );
        
        //kode delete phones dakayn......
        phones.deleteByEmp();
        //kode add phones dakayn...
          for(int x = 0 ; x < tblPhones.getRowCount() ; x++){
              
              phones.setPhone( tblPhones.getValueAt(x, 0).toString() );
              phones.add();
          }
          //.........................................
       clearData();
       emp.getAllRows(tblEmp);
    }
    
   //------------------------------------------------------------------------------------------------------------ 
   private void btnDelete(ActionEvent evt)
    {
        if(Tools.confirmMsg("Möchten Sie löschen ?")){
        
       //ama bo  delet krdne phon bakar det ......
        phones.setEmpNO( Integer.parseInt( txtEmpNO.getText() ) );
        
        //kode delete phones dakayn......
        phones.deleteByEmp();
       //.................................... 
        setValues();
        emp.delete();
        clearData();
        emp.getAllRows(tblEmp);
        }
    }

  //--------------------------------------------------------------------------------------  
    
    private void btnFind(ActionEvent evt)
    {
       String EmpNO = (String) Tools.InputBox("Geben Sie die Teilnehmernummer ein ");
       int ENO = Integer.parseInt(EmpNO);
       emp.setEmpNO(ENO);
       emp.getOneRow(tblEmp);
    }

  //--------------------------------------------------------------------------------------------  
   private void btnAll(ActionEvent evt)
    {
        emp.getAllRows(tblEmp);
    }

    private void tblEmpMouseClicked(MouseEvent evt)
    {
        try{
        int row = tblEmp.getSelectedRow();
        txtEmpNO.setText( tblEmp.getValueAt(row, 0).toString() );
        txtEmpName.setText( tblEmp.getValueAt(row, 1).toString() );
        txtAddress.setText( tblEmp.getValueAt(row, 2).toString() );
        txtSalary.setText( tblEmp.getValueAt(row, 3).toString() );
        //am koda stringa ka bakarman henawa bo hiring u birthdate wata muaqata.......................
        txtHiringDate.setText( tblEmp.getValueAt(row, 4).toString() );
        txtBirthDate.setText( tblEmp.getValueAt(row, 5).toString());
        
      //T.B  ama kode date agar hatu birthdate u hiring dateman ba date barmaja krd wata(Jdatechooser)................................  
        //SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        //Date dateH = sdf.parse( tblEmp.getValueAt(row, 4).toString() );
        //Date dateB = sdf.parse( tblEmp.getValueAt(row, 5).toString() );
        
        //txtHiringDate.setDate(dateH);
        //txtBirthDate.setDate(dateB);
        //...........................................................................................
        cbxDept.setSelectedItem( tblEmp.getValueAt(row, 7));
        
        // am koda tybata ba phones employee..........
        phones.setEmpNO( Integer.parseInt( txtEmpNO.getText() ) );
        phones.getAllRows(tblPhones);
        
        
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        }
        catch(Exception ex){
        Tools.msgBox(ex.getMessage());
        }
    }
    
  //----------------------------------------------------------------------------------------------------------  
    
    
//methode search krdn ba naw yan zmara yan addresss yan birth yan tarexe damazrandn...................
    //sarata la daree faunktionaka methodek drust dakayn bo asankare bang krdne kodakan...............
    private String getMyLike (){
    // am koda ta3ref dakayn bo away la xware ba asane bange bkayn la naw (if)................................
        return " like'%" + txtSearch.getText() + "%'";
    }
    
  //-------------------------------------------------------------------------------------------------------------  
    
    private void btnSearch(ActionEvent evt)
    
    {
       
        String strSearch = "select * from employee_data where ";
        if(rdoNumber.isSelected()){
        //bam shewaya lerada tanha bange methode getmylike dakayn u bas .....................
            strSearch += " Number " + getMyLike() ;
            
        
        }
        else if(rdoName.isSelected()){
        strSearch += " name " + getMyLike();
        }
        else if(rdoAddress.isSelected()){
        
            strSearch += " address " + getMyLike();
        }
        else if(rdoSalary.isSelected()){
        
            strSearch += " Salary " + getMyLike();
        }
        else if(rdoHiring.isSelected()){
        
            strSearch += " Hiring_Date " + getMyLike();
        
        }
        else if(rdoBirth.isSelected()){
        
            strSearch += " Date_Of_Birth " + getMyLike();
        
        }
        else if(rdoDept.isSelected()){
        
            strSearch += " Department_NO " + getMyLike()
                    + " or Department " + getMyLike();
        
        }
        //kodek bo searche ba phone bam shywaya dakret chonka lerada atu la jadwalek bo jadwaleke tr dagareet boya kodakay bam shewaya dabet.....................
        else{
        
        String strEmpNum = phones.getEmpNOByPhone(txtSearch.getText());
        strSearch += " Number like'%" + strEmpNum + "%'";
        
        }
        emp.getCustomRows(strSearch, tblEmp);
    }
    
 //--------------------------------------------------------------------------------------------------------------   
   private void txtPhone(ActionEvent evt) {
      
    }
    
 //---------------------------------------------------------------------------------------------------------------   
    
//barmajay batne add phones..........................................................
    private void btnAddPhone(ActionEvent evt)
    {
        DefaultTableModel model =(DefaultTableModel)tblPhones.getModel();
        model.addRow(new Object[]{txtPhone.getText()});
        //dway away addman krd bam koday xwaratawa batale dakaynawa.....................
        txtPhone.setText("");
        txtPhone.requestFocus();
    }
    
   //-------------------------------------------------------------------------------------------------------------- 
    
    
//drust krdne methodek bo removephones bo away lahar shwenek btawy bange bkayt.........
    private void removePhones(){
    DefaultTableModel model = (DefaultTableModel) tblPhones.getModel();
        model.setNumRows(0);
    }
    
    
  //---------------------------------------------------------------------------------------------------------------------  
    
    
    //...............................................................................
    private void btnRemovePhones(ActionEvent evt) 
    {
        
        //DefaultTableModel model = (DefaultTableModel) tblPhones.getModel();
       // model.setNumRows(0);
       removePhones(); 
    }
    
   //------------------------------------------------------------------------------------------------------------------- 
    
    
    
//methode clear krdne datakane forme employee..................................
    private void clearData(){
    
        Tools.clearText(this);
        txtEmpNO.setText( emp.getAutoNumber() );
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        //am koda bakar det bo rashkrdnaway raqamakane naw fonesh katek cleare 3am dakayn bo hamu datakan.....
       //bam shywaya bange evente remove dakayn wata 7adasakay.(1)...................
       //regay 1...
// btnRemovePhonesActionPerformed(null);
        //regay 2.....
        //(2).yanesh lanaw batne remove methodek drust dakayn u bange dakayn......
        removePhones();
        //....................................................................
        txtEmpName.requestFocus();
    
    }
    
   //--------------------------------------------------------------------------------------------------------------------- 
 
    
}
