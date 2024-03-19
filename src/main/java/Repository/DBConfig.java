package Repository;
import java.sql.*;
public class DBConfig {
protected Connection con;
protected ResultSet rs;
protected PreparedStatement stmt;
	DBConfig()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root","root");
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
		}
	}
}
