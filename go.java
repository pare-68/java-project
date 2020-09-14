
package db;

import company.Tools;
import company.Tools.Table;

import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class go {
    
    private static String url="";
    private static Connection con;

    
    private static void setURL(){
    
        //method bo gayshtn ba database...........
        url="jdbc:mysql://localhost:3306/company" 
                
                //method bo away btwane ba zmane 3arabesh karbkay lanaw database...........
                + "?useUnicode=true&characterEncoding=UTF-8 ";
    
    }
    
    public static void setConnection(){
    
        
        try {
            setURL();
            con=DriverManager.getConnection(url,"root","");
        } catch (SQLException ex) {
           Tools.msgBox(ex.getMessage());
        }
    
    }
    //methode bo bastnaway sql u java la forme login bo away tatbeq bkret formaka....................
    public static boolean checkUserAndPass(String username,String password){
    
        try{
        
            setConnection();
            Statement stmt = (Statement) con.createStatement();
            String strCheck = " select * from users where "
                    + "username='" + username + "' and "
                    + "pass='" + password + "'";
            
           
                  stmt.executeQuery(strCheck);

                 while(stmt.getResultSet().next()){
                     
                      con.close();
                 return true;
                 }
                 con.close();
                 
        }
        catch(SQLException ex){
        
            Tools.msgBox(ex.getMessage());
        }
        return false;
    }
    //methodek bo statement tatbeqe update u delete u add dakat la naw tableka......................................
    public static boolean runNonQuery(String sqlStatement) {
    	
    	try {
    		
    		setConnection();
    		 Statement stmt = con.createStatement();
    		 stmt.execute(sqlStatement);
    		 con.close();
    		 return true;
    	}
    	catch(SQLException ex){
    		
    		Tools.msgBox(ex.getMessage());
    		
    		return false;
    	}
    	
    }
    
    //methodek bo away jadwalakat bo pr bkatawa ka nawe dalakaw nawe 3amudakay dadayte u pre dakatawa......................
    public static String getAutoNumber(String tableName , String culomenName) {
    	
    	try {
    		
    		setConnection();
    		Statement stmt = con.createStatement();
    		String strAuto = "select max(" + culomenName +")+1 as autonum" + " from " 
    		+ tableName;
    		stmt.executeQuery(strAuto);
    		String Num ="";
    		
    		while(stmt.getResultSet().next()) {
    			
    			Num = stmt.getResultSet().getString("autonum");
    			
    			
    		}
    		
    		con.close();
    		
    		if(Num == null || "".equals(Num)) {
    			
    			return "1";
    			
    			
    		}
    		
    		else {
    			return Num;
    		}
    	}
    	
    	catch(SQLException ex){
    		
    		Tools.msgBox(ex.getMessage());
    		return "0";
    	}
    	
    }
    
    
    //drustkrdne methodek bo garandnaway mutagher ba jadwal...........
    
    public static Table getTableData(String statement) {
    	
    	Tools t = new Tools();
    	try {
    		setConnection();
    		Statement stmt = con.createStatement();
    		ResultSet rs;
    		rs = stmt.executeQuery(statement);
    		
    		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
    		int c = rsmd.getColumnCount();
    		
    		Table table = t.new Table(c);
    		while(rs.next()) {
    			
    			Object row[] = new Object[c];
    			
    			for(int i = 0 ; i < c ; i++) {
    				
    				row[i] = rs.getString(i + 1);
    			}
    			table.addNewRow(row);
    		}
    		con.close();
    		return table;
    		
    	}
    	catch(SQLException ex){
    		
    		Tools.msgBox(ex.getMessage());
    		return t.new Table(0);
    		
    		
    	}
    }
    //methodek bo prkrdnaway combobox.................................................................
    public static void fillCombo(String tableName,String columnName,JComboBox<?> combo) {
    	
    	try {
    		setConnection();
    		Statement stmt = con.createStatement();
    		ResultSet rs;
    		
    		String strSelect = "select " + columnName + " from " + tableName; 
    		rs = stmt.executeQuery(strSelect);
    		rs.last();
    		int c = rs.getRow();
    		rs.beforeFirst();
    		
    		String values[] = new String[c];
    		
    		int i = 0;
    		while(rs.next()) {
    			values[i] = rs.getString(1);
    			i++;
    			
    		}
    		con.close();
    		combo.setModel(new DefaultComboBoxModel(values));
    		
    	}
    	catch(SQLException ex) {
    		Tools.msgBox(ex.getMessage());
    		
    	}
    	
    }
   //methode pr krdnaway jtable ............................................................................................... 
    public static void fillToJTable(String tableNameOrSelectStatement, JTable table) {
    	
    	try {
    		setConnection();
    		Statement stmt = con.createStatement();
    		ResultSet rs;
    		
    		String SPart =  tableNameOrSelectStatement.substring(0, 7).toLowerCase();
    		
    		String strSelect;
    		if("select ".equals( SPart )) {
    			
    			strSelect = tableNameOrSelectStatement;
    		}
    		else {
    			strSelect = "select * from " + tableNameOrSelectStatement;
    		}
    		rs = stmt.executeQuery(strSelect);
    		
    		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
    		int c = rsmd.getColumnCount();
    		
    		DefaultTableModel model = (DefaultTableModel) table.getModel();
    		// vector mutaghyreka bo pr krdnaway jtable bakare denen wak row kar dakat........................................
    		Vector<String> row = new Vector<String>(); 
    		model.setRowCount(0);
    		
    		while(rs.next()) {
    			
    			row = new Vector<String>(c);
    			for(int i = 1; i<= c ; i++) {
    				
    				row.add(rs.getString(i));
    				
    			}
    			model.addRow(row);
    		}
    		
    		if(table.getColumnCount() !=c) {
    			
    			//Tools.msgBox("JTable columns count not equal to Query columns count\n JTable columns count is" + table.getColumnCount() + "\nQuery columns count is :" + c);
    			
    		}
    		con.close();
    	}
    	catch(SQLException ex) {
    		Tools.msgBox(ex.getMessage());
    		
    	}
    }
    
}
