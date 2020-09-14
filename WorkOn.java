
package Entity;

import company.Tools;
import javax.swing.JTable;


public class WorkOn implements mainData {
    
    private int EmpNO;
    private int ProjectNO;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public int getProjectNO() {
        return ProjectNO;
    }

    public void setProjectNO(int ProjectNO) {
        this.ProjectNO = ProjectNO;
    }
//barmajay methode add......................................
    @Override
    public void add() {
        
        String strInsert = "insert into WorkOn values("
                + EmpNO + ","
                + ProjectNO + ")";
        boolean isAdd = db.go.runNonQuery(strInsert);
        if(isAdd){
        
        Tools.msgBox("Work on is Added...");
        
        }
        
        
        
        
    }
//labar away hardu 7aqlman primary keya boya update esh nakat lera la workon......
    @Override
    public void update() {
        Tools.msgBox("update method not working in workon class");
    }
//barmajay methode delete...........................................
    @Override
    public void delete() {
        
        String strDelete = "delete from WorkOn where "
                + "EmpNO=" + EmpNO
                + " and "
                + "ProjectNO=" + ProjectNO;
        boolean isDelete = db.go.runNonQuery(strDelete);
        if(isDelete){
        Tools.msgBox("Work On Is Deleted");
        }
    }
//am methodash pewest nya esh nakat lam basha..............................
    @Override
    public String getAutoNumber() {
                Tools.msgBox("getAutoNumber method not working in workon class");
                return "";

    }

    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTable("WorkOn_Data", table);
    }
//barmajay getonerow....................................
    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from WorkOn_Data where "
                + "Employee_NO=" + EmpNO
                + " and "
                + "Project_NO=" + ProjectNO;
        db.go.fillToJTable(strSelect, table);
        
        
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.go.fillToJTable(statement, table);
    }
//am methodash esh nakat.............................................
    @Override
    public String getValueByName(String name) {
         Tools.msgBox("getValueByName method not working in workon class");
                return "";

    }
// am methodash esh nakat.........................................
    @Override
    public String getNameByValue(String value) {
        Tools.msgBox("getNameByValue method not working in workon class");
                return "";

    }
    
    
    
}
