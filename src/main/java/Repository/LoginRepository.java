package Repository;

import Models.Login;

public class LoginRepository extends DBConfig{
	public boolean logrepo(Login l)
	{
		try
		{
		stmt=con.prepareStatement("select * from login where user=? and password=?");
		stmt.setString(1,l.getUser());
		stmt.setString(2, l.getPassword());
		rs=stmt.executeQuery();
		while(rs.next())
		{
			if(rs.getString(5).equals(l.getUser()) && rs.getString(6).equals(l.getPassword()))
			{
				return true;
			}
				
		}
		return false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
}
