
package Entity;

import company.Tools;
import javax.swing.JTable;


public class Project implements mainData {
    
    private int ProjectNO;
    private String ProjectName;
    private String Location;
    private int DeptNO;

    public int getProjectNO() {
        return ProjectNO;
    }

    public void setProjectNO(int ProjectNO) {
        this.ProjectNO = ProjectNO;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getDeptNO() {
        return DeptNO;
    }

    public void setDeptNO(int DeptNO) {
        this.DeptNO = DeptNO;
    }
//barmajay methode add bo project..................................
    @Override
    public void add() {
        
        String strInsert = "insert into Project values("
                + ProjectNO + ","
                + "'" + ProjectName + "',"
                + "'" + Location + "',"
                + DeptNO + ")";
        boolean isAdd = db.go.runNonQuery(strInsert);
        if(isAdd){
        Tools.msgBox("Projekt wird hinzugefügt....");
        }
    }
//barmajay methode update bo project..............................
    @Override
    public void update() {
        
        String strUpdate = "update Project set "
                + "ProjectName='" + ProjectName + "',"
                + "Location='" + Location + "',"
                + "DeptNo=" + DeptNO
                + " where ProjectNO=" + ProjectNO;
        boolean isUpdate = db.go.runNonQuery(strUpdate);
        if(isUpdate){
        
        Tools.msgBox("Projekt wird aktualisiert...");
        
        
        }
    }
//barmaja krdne methode delete.....................
    @Override
    public void delete() {
        
        String strDelete = "delete from Project "
                + " where ProjectNO=" + ProjectNO;
        boolean isDelete = db.go.runNonQuery(strDelete);
        if(isDelete){
        
            Tools.msgBox("Projekt wird gelöscht...");
        
        }
        
        
        
    }
//barmaja krdne methode getautonumber.......................
    @Override
    public String getAutoNumber() {
        
        return db.go.getAutoNumber("Project", "ProjectNO");
    }
//barmaja krdne methode get allrows.............................
    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTable("Project_Data", table);
       
    }
//barmaja krdne methode getonerow.................................
    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from Project_Data"
                + " where Project_NO=" + ProjectNO;
        db.go.fillToJTable(strSelect, table);
        
        
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        
        db.go.fillToJTable(statement, table);
    }
//barmajakrdne methode getvaluebyname...........................
    @Override
    public String getValueByName(String name) {
        String strSelect = "select ProjectNO from Project"
                + " where ProjectName='" + name + "'";
        //pesh away return bkayn methodaka mutaxerek ta3ref dakayn bo away qematakay la naw halgren bam shywaya.....
        String strVal = (String) db.go.getTableData(strSelect).Items[0][0];
        return strVal;
    }
//barmajakrdne methode getnamebyvalue................................
    @Override
    public String getNameByValue(String value) {
        
        String strSelect = "select ProjectName from Project"
                + " where ProjectNO=" + value;
        //pesh return mutaxerek ta3ref dakay bo away qematakay lanaw halgren bam shywaya.....
        String strName = (String) db.go.getTableData(strSelect).Items[0][0];
        return strName; 
    }
    
    
}
