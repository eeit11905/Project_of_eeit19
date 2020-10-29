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
		
			String sql = "SELECT �s��, ���O, �W��, ����, ��m, ���i�ɶ�  FROM dbo.�x�n�j��2";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Trip> tripLists = new ArrayList<Trip>();
			
			while(rs.next()) {
				Trip trip = new Trip();
				trip.setNumber(rs.getString("�s��"));
				trip.setType(rs.getString("���O"));
				trip.setName(rs.getString("�W��"));
				trip.setLevel(rs.getString("����"));
				trip.setLocation(rs.getString("��m"));
				trip.setTime(rs.getString("���i�ɶ�"));
				tripLists.add(trip);

			}
//			for(Trip t:tripLists) {
//				System.out.println(t.getInfoByCsv());		�P�U�C�ۦP
//			}
			tripLists.stream().forEach(t->System.out.println(t.getInfoByCsv()));
		
			System.out.println("===============================================================================================");
			

			tripLists.stream()
					.filter(t->"��w".equals(t.getLevel()))
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
			System.out.print("�s�� :" + number);
			System.out.print("	���O :" + type);
			System.out.print("	    �W�� :" + name);
			System.out.println("	���� :" + level);
			System.out.println("��m : " + location);
			System.out.println("���i�ɶ� : " + time + "\n");

		}
		
		public String getInfoByCsv() {
	      return number + "," + type + "," + name + "," + level + "," + location + "," + time;

		}	
		
	}//end public static class Trip
	
	public static void outputToCsv(List<Trip> tripLists) {
	    try {
	        File csv = new File("D:\\�䤤�M�D\\�x�n��w�j��.csv");//CSV�ɮ�
	        BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
	
	        for(Trip t:tripLists) {
	        	bw.newLine();  //�s�W�@����	
	
	        	bw.write(t.getInfoByCsv());
	        }
	        	//tripLists.stream().forEach(t->{bw.newLine();
//									 bw.write(t.getInfoByCsv());
//	    							});
	
	        bw.close();
	    } catch (FileNotFoundException e) {
	        //����File����ͦ��ɪ����`
	    	e.printStackTrace();
	    } catch (IOException e) {
	        //����BufferedWriter���������ɪ����`
	    	e.printStackTrace();
	    }
	}//end public static void outputToCsv
	

}
