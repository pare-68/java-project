package company;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Tools{

    public static void msgBox(String message){
    JOptionPane.showMessageDialog(null,message);
    }
    //methodek bo confirm krdn agar aw qematay bakarhenar daxele dakat awa true bu boy dagaretawa agar na false dagaretawa...........................................
    public static boolean confirmMsg(String message){
    
    int msgC = JOptionPane.showConfirmDialog(null, message);
    
    if(msgC == JOptionPane.YES_OPTION){
    
        return true;
    
    }
    else{
        
        return false;
    }
    
    }
    
    
    //kode drustktdne folder la naw driv
    public static void CreateFolder(String foldername,String path){
        File f =new File(path +"/"+ foldername);
        f.mkdir();
        
    }
    //kode drustktdne folder la naw malafe netbeans.......
     public static void CreateFolder(String foldername){
        File f =new File( foldername);
        f.mkdir();
}

//methode krdnaway 2 form pekawa..........
   public static void openForm(JFrame form){
   form.setLocationRelativeTo(null);
   form.setDefaultCloseOperation(2);
   //kode rangkrdne bakgrounde formakan ba gshte................
   form.getContentPane().setBackground(Color.white);
   form.setVisible(true);
   }
//methode rashkrdnaway nusene naw text la regay klik lasar botton........
   public static void clearText(Container form){
   for(Component c : form.getComponents() ){
       if( c instanceof JTextField){
       JTextField txt =(JTextField)c;
       txt.setText("");
       }
       else if(c instanceof Container){
           clearText((Container)c);
       }
   }
   }
   
   //methode drustkrdne file batal la regay formawa..........
   public static void createEmptyFile(String fileName){
        try {
           
            File f = new File(fileName+".txt");
            f.createNewFile();
           
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Tools.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   }
   
    public static void createFile(String fileName,Object date[]){
            PrintWriter p = null;
        try {
            // try {
            p = new PrintWriter(fileName + ".txt");
            for(Object obj :date){
                p.println(obj);
            }
            p.close();
            //} catch (FileNotFoundException ex) {
            //    Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            // }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            p.close();
        }
   
   }
   
   //methode drustkrdne botton bo daxel krdne nawek yan shtek walamdanawy ba botton.....
   public static Object InputBox(String title){
       Object myObj = JOptionPane.showInputDialog(title);
       return myObj;
   }
   
   //2 methode rega bo garandnaway zhmara la naw wshada...........
   public static String getNumber(String text){
       String val ="";
       for(char c : text.toCharArray()){
           if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
           val += c;
           }
       }
       return val;
   }
   
   
    //methode jea krdnaway wsha la raqam........
    public static String removeNumber(String text){
       String val ="";
       for(char c : text.toCharArray()){
           if(  !(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')  ){
           val += c;
           }
       }
       return val;
   }
    
    //drustkrdne chand malafek ba yak jar...........
   public static void createEmptyFiles(String fileNames[]){
       for(String str : fileNames){
           createEmptyFile(str);
       }
   }
   
   
   //drustkrdne chand filek u danane data lanawayan ba yak jar ba array............
   public static void createFiles(String fileNames[],Object allDate[][]){
   for(int x =0 ; x < fileNames.length ; x++){
   
       createFile(fileNames[x],allDate[x]);
   }
   }
   
   //methode tab3krdne shasha 
    public static void printScreen(String Imagename){
        try {
            Robot r = new Robot();
            Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img = r.createScreenCapture(rec);
            ImageIO.write(img , "jpg", new File(Imagename + ".jpg"));
            
            
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


public static class StringTools{

public static void printCharByChar(String text){

for(char c : text.toCharArray()){
    System.out.print(c);

}
}
}

public static void printCharByCharInverse(String text){

StringBuilder sb = new StringBuilder(text);
        String inverseText = sb.reverse().toString();
for(char c :  inverseText.toCharArray()){

System.out.println(c);
}
}
public class Table{

public int columns;
public Object [][] Items;

public Table(int columns){

    this.columns = columns;
    
    Items = new Object[0][columns];
}

public void addNewRow(Object row[]){
    
    //parastne 3unsurakan bo mawayake kate....
    Object  TempItems[][]=Items;
    //zyad krdne mutaxere asase ba 3unsure azafe.......
    Items = new Object[Items.length +1][columns];
    for(int x = 0 ; x< TempItems.length ; x++){
    
    Items[x]=TempItems[x];
    }
    //zyad krdne row taza bo 3unsure asase.....
    Items[Items.length-1]=row;
}

public void printItems(){

for(Object objs[]: Items){

for(Object obj : objs){
System.out.print(obj + " ; ");
}
System.out.println();
}
}

public void editRow(int rowIndex , int columnIndex ,Object newData){

    Items[rowIndex][columnIndex]= newData;
}
}
public class MergeArray{

public Object[] array1;
public Object[] array2;

public MergeArray(Object[] array1 , Object[] array2){

    this.array1= array1;
    this.array2= array2;
    

}

public Object[] mergeToArrays(){

int a1 = array1.length;
int a2 = array2.length;
Object[] arrayR = new Object[a1 + a2];

System.arraycopy(array1, 0, arrayR, 0, a1);
System.arraycopy(array2, 0, arrayR, a1, a2);

return arrayR;
}

}
//am methoda drust dakayn bo away range gshte hakgrauond u forgraunde hamu reportakan wak yak bn tanha la shwene pewest bange am methoda dakayn......
public  static void setReport(JTable table){

    table.getTableHeader().setBackground(new Color(0,0,100));
    table.getTableHeader().setForeground(Color.white);


}
//am methoda drust dakayn bo away la hamu reportakan tanha bange classacabkayn am methoda tatbiq bet....
public static void PrintReport(JTable table,String title){

 //datwanen bam shywaya yaksar bange bkayn la naw try u catch........
        try{
       // tblDept.print();
       
    //yanesh bam shywaya dabet agar westet headere u footere bo reportaka daneet har la naw try u catch.................................................
    
    MessageFormat header = new MessageFormat(title + " Bericht");
    MessageFormat footer = new MessageFormat("Page - {0}");
    table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
       }
       catch(Exception ex){
       Tools.msgBox(ex.getMessage());
       }
}


}

        
        
       