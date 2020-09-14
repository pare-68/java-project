
package Entity;

import company.Tools;
import javax.swing.JTable;


public class Employee_Phones implements mainData {
    
    private int EmpNO;
    private String Phone;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
//methode add bo zhmaray talafone muazaf......................................
    @Override
    public void add() {
        
        String strInsert = "insert into employee_phones values("
                + EmpNO + ","
                + "'" + Phone + "')";
        boolean isAdd = db.go.runNonQuery(strInsert);
        if(isAdd){
            //am koda agar pewest bu bekawa agar na pewestt nya....................
       // Tools.msgBox("Phone is Added");
        }
    }
//methode update pewestman nya la phones boya heche bo nakayn batal bajee dahelen chonka hardu xanakay primary keya boya dast kare nakret...................
    @Override
    public void update() {
  // ......................batala.............
  Tools.msgBox("update method in employee phones class not working");
    }
    //methode delete bas yak yak delet dakat nak hamue pekawa...........................
    @Override
    public void delete() {
        
        String strDelete = "delete from employee_phones "
                + " where "
                + " empno=" + EmpNO
                + " and phone='" + Phone + "'";
        boolean isDelete = db.go.runNonQuery(strDelete);
        if(isDelete){
            //am koda radagren chonka zor pewest nya bakarebenen ................................
       // Tools.msgBox("Phone Is Deleted");
        }
    }

    //am methoda drust dakayn taybata ba employee phones ka hamu phonakan pekawa delet dakat...............................
    public void deleteByEmp(){
    
        String strDelete = "delete from employee_phones"
                + " where empNO=" + EmpNO;
        boolean isDelete = db.go.runNonQuery(strDelete);
        if(isDelete){
            //am koda radagren chonka zarur nya.......................................
        //Tools.msgBox("Phone Is Deleted");
        }
    
    }
    
    //am methodaman pewest nya la phon chonka hardu 7aqlakay primary keyn........................
    @Override
    public String getAutoNumber() {
        Tools.msgBox("getAutoNumber method in employee phones class not working");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
        
        String strSelect = "select phone from employee_phones"
                + " where empno=" + EmpNO;
        db.go.fillToJTable(strSelect, table);
    }
//am methodanay xwarawaman pewest nya la phon boya barmajayan nakayn...........................
    @Override
    public void getOneRow(JTable table) {
        Tools.msgBox("getOneRow method in employee phones class not working");
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        Tools.msgBox("getCustomRows method in employee phones class not working");
        
    }

    @Override
    public String getValueByName(String name) {
        
        Tools.msgBox("getValueByName method in employee phones class not working");
        return "";
    }

    @Override
    public String getNameByValue(String value) {
        
        Tools.msgBox("getNameByValue method in employee phones class not working");
        return "";
    }
    
    //methodeke tybat ba phone drust dakayn bo away lakate search phone har muazafekman da ba dway ma3lumate aw muzafada bgaret......
    public String getEmpNOByPhone(String requestPhone){
    
        String strSelect = "select empno from employee_phones"
                + " where phone='" + requestPhone + "'";
        Object row[][] = db.go.getTableData(strSelect).Items;
        
        String strEmpNO = "";
        if(row.length>0){
         strEmpNO = (String)row[0][0];
        }
        else{
        
        strEmpNO = "0";
        }
    return strEmpNO;
    }
    
}
