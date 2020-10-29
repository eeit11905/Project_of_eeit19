package taichung ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class insert_work1 {
	private static final String JDBC_DRIVER = 
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=work1";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);;
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=work1";//資料庫選擇
//			java.sql.Connection conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			FileReader fr = new FileReader("D:\\臺中市百大名攤名產_1.csv");//抓CSV檔進java
            BufferedReader brdFile = new BufferedReader(fr);//bufferedReader
            String strLine = null;
            brdFile.readLine();//跳一行
            while((strLine = brdFile.readLine())!=null){//將CSV檔字串一列一列讀入並存起來直到沒有列為止
            
			String[] array=strLine.split(",");//因為預設是用"，"分開所以用split切開存入字串陣列
			System.out.println(strLine);
//			for(int i=0;i<array.length;i++){//偷看陣列元素有沒有切對
//			//System.out.println(array[i]);
//			}
			String qryInsert="insert into dbo.臺中百大地攤 values (?,?,?,?,?)";//動態SQL指令 寫入
					
			PreparedStatement pstmt= conn.prepareStatement(qryInsert);//因為是insert所以用PreparedStatement來接
			
			pstmt.setInt(1,Integer.valueOf(array[0]));//因為這欄是用int的格式，所以將array[1]值抓出來轉int
			pstmt.setString(2,array[1]);			
			pstmt.setString(3,array[2]);			
			pstmt.setString(4,array[3]);
			pstmt.setString(5,array[4]);
			pstmt.execute();
			};
			conn.close();
			brdFile.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e){
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}


