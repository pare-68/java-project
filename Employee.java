
package Entity;

import company.Tools;
import javax.swing.JTable;


public class Employee implements mainData {
    
    private int EmpNO;
    private String EmpName;
    private String Address;
    private String Salary;
    private String HiringDate;
    private String BirthDate;
    private int DeptNO;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public String getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(String HiringDate) {
        this.HiringDate = HiringDate;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getDeptNO() {
        return DeptNO;
    }

    public void setDeptNO(int DeptNO) {
        this.DeptNO = DeptNO;
    }

    @Override
    public void add() {
     
        String strInsert = "insert into employee values("
                + EmpNO + "," 
                + "'" + EmpName + "',"
                + "'" + Address + "',"
                + "'" + Salary +  "',"
                + "'" + HiringDate + "',"
                + "'" + BirthDate + "',"
                + DeptNO + ")";
        boolean isAdd = db.go.runNonQuery(strInsert);
        if(isAdd){
        Tools.msgBox("Teilnehmer wird hinzugefügt");
        
        }
        
    }
//methode add bo employee.............................................
    @Override
    public void update() {
        String strUpdate = "update employee set "
                + "EmpName='" + EmpName + "',"
                + "Address='" + Address + "',"
                + "Salary='" + Salary + "',"
                + "HiringDate='" + HiringDate + "',"
                + "BirthDate='" + BirthDate + "',"
                + "DeptNO=" + DeptNO 
                + " where EmpNO=" + EmpNO;
        boolean isUpdate = db.go.runNonQuery(strUpdate);
        if(isUpdate){
        
        Tools.msgBox("Teilnehmer wird aktualisiert");
        
        }
        
    }
//methode delet bo jadwaly employee........................................
    @Override
    public void delete() {
        String strDelete = "delete from employee"
                + " where EmpNO=" + EmpNO;
        boolean isDelete = db.go.runNonQuery(strDelete);
        if(isDelete){
        Tools.msgBox("Teilnehmer wird gelöscht");
        }
    }
//methodakane select la forme employee methodakane jumlay est3lama.............................................
    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("employee", "EmpNO");
    }

    @Override
    public void getAllRows(JTable table) {
        
        db.go.fillToJTable("employee_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from employee_data"
                + " where Number=" + EmpNO;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.go.fillToJTable(statement, table);
    }
//du method bo henane yak row u yak colom la table employee............................
    @Override
    public String getValueByName(String name) {
        String strSelect = "select EmpNO from employee"
                + " where EmpName='" + name + "'";
        String strVal = db.go.getTableData(strSelect).Items[0][0].toString();
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        
        String strSelect = "select EmpName from employee"
                + " where EmpNO=" + value;
        String strName = db.go.getTableData(strSelect).Items[0][0].toString();
        return strName;
    }
    
    
}
