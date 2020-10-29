package TainanTrip;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TainanTrip {
	private static final String className =
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=TainanTrip";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = DB_URL;
			conn = DriverManager.getConnection(url, USER, PASSWORD);
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String url = "jdbc:sqlserver://localhost:1433;databaseName=TainanTrip";
//			conn = DriverManager.getConnection(url, "sa", "passw0rd");
		
			String sql = "SELECT 編號, 類別, 名稱, 等級, 位置, 公告時間  FROM dbo.台南古蹟2";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Trip> tripLists = new ArrayList<Trip>();
			
			while(rs.next()) {
				Trip trip = new Trip();
				trip.setNumber(rs.getString("編號"));
				trip.setType(rs.getString("類別"));
				trip.setName(rs.getString("名稱"));
				trip.setLevel(rs.getString("等級"));
				trip.setLocation(rs.getString("位置"));
				trip.setTime(rs.getString("公告時間"));
				tripLists.add(trip);

			}
//			for(Trip t:tripLists) {
//				System.out.println(t.getInfoByCsv());		與下列相同
//			}
			tripLists.stream().forEach(t->System.out.println(t.getInfoByCsv()));
		
			System.out.println("===============================================================================================");
			

			tripLists.stream()
					.filter(t->"國定".equals(t.getLevel()))
					.forEach(t->t.printAllInfo());
			
			outputToCsv(tripLists);
			
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}

	}
	
	public static class Trip {
		
		private String number;
		private String type;
		private String name;
		private String level;
		private String location;
		private String time;
		
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		
		public void printAllInfo() {
			System.out.print("編號 :" + number);
			System.out.print("	類別 :" + type);
			System.out.print("	    名稱 :" + name);
			System.out.println("	等級 :" + level);
			System.out.println("位置 : " + location);
			System.out.println("公告時間 : " + time + "\n");

		}
		
		public String getInfoByCsv() {
	      return number + "," + type + "," + name + "," + level + "," + location + "," + time;

		}	
		
	}//end public static class Trip
	
	public static void outputToCsv(List<Trip> tripLists) {
	    try {
	        File csv = new File("D:\\其中專題\\台南國定古蹟.csv");//CSV檔案
	        BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
	
	        for(Trip t:tripLists) {
	        	bw.newLine();  //新增一行資料	
	
	        	bw.write(t.getInfoByCsv());
	        }
	        	//tripLists.stream().forEach(t->{bw.newLine();
//									 bw.write(t.getInfoByCsv());
//	    							});
	
	        bw.close();
	    } catch (FileNotFoundException e) {
	        //捕獲File物件生成時的異常
	    	e.printStackTrace();
	    } catch (IOException e) {
	        //捕獲BufferedWriter物件關閉時的異常
	    	e.printStackTrace();
	    }
	}//end public static void outputToCsv
	

}
