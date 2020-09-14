package Entity;

import javax.swing.JTable;

import company.Tools;

public class Department implements mainData {

	private int DeptNO;
	private String DeptName;
	private String Location;
	//methode geter & seter bo hamu dalakan awha dakret................................................
	public int getDeptNO() {
		return DeptNO;
	}
	
	public void setDeptNO(int DeptNO) {
		
		this.DeptNO = DeptNO;
	}
	
	public String getDeptName() {
		
		return DeptName;
	}
	
	public void setDeptName(String DeptName) {
		
		this.DeptName =DeptName;
	}
	
	public String getLocation() {
		
		return Location;
	}
	
	public void setLocation(String Location) {
		
		this.Location = Location;
	}
//methodek bo add krdne data la form ..................................................................
	@Override
	public void add() {
		
		String strInsert = "insert into department values("
				+ DeptNO + ","
				+ "'" + DeptName + "',"
				+ "'" + Location + "')";
		boolean isAdd = db.go.runNonQuery(strInsert);
		if(isAdd) {
			
			Tools.msgBox("Abteilung wird hinzugefügt");
		}
	}
//methode update krdne datakan la naw form..........................................................................
	@Override
	public void update() {
		
		String strUpdate = "update department set "
				+ "DeptName='" + DeptName + "',"
				+ "Location='" + Location + "' "
				+ " where DeptNO=" + DeptNO;
		boolean isUpdate = db.go.runNonQuery(strUpdate);
		if(isUpdate) {
			Tools.msgBox("Abteilung wird aktualisiert");
			
		}
		
	}

	@Override
	public void delete() {
		String strDelete = "delete from department"
				+ " where DeptNO=" + DeptNO;
		boolean isDelete = db.go.runNonQuery(strDelete);
	if(isDelete) {
		Tools.msgBox("Abteilung wird gelöscht");
		
	}
		
		
	}
//methode getautonumber............................................................................................................
	@Override
	public String getAutoNumber() {
		//regay yakam.............................................................
		
		//String strAuto = db.go.getAutoNumber("department", "DeptNO");
		//return strAuto;
		
		//regay dwam............................................................
		return db.go.getAutoNumber("department", "DeptNO");
		
	}
	
	//methode pr krdnaway u henane hamu  rwakan.............................................................................................

	@Override
	public void getAllRows(JTable table) {
		db.go.fillToJTable("department_data", table);
	}
	

	@Override
	public void getOneRow(JTable table) {
		String srtSelect;
            srtSelect = "select * from department "
                    + " where deptno=" + DeptNO;
		db.go.fillToJTable(srtSelect, table);
		
	}

	@Override
	public void getCustomRows(String statement, JTable table) {
		db.go.fillToJTable(statement, table);
		
	}

	@Override
	public String getValueByName(String name) {
		
		String strSelect = "select deptno from department"
				+ " where deptname='" + name + "'";
		String strVal = (String)db.go.getTableData(strSelect).Items[0][0];
		return strVal;
	}

	@Override
	public String getNameByValue(String value) {
		String strSelect = "select deptname from department"
				+ " where deptno=" + value;
		String strName = (String)db.go.getTableData(strSelect).Items[0][0];
		
		return strName;
	}
}


