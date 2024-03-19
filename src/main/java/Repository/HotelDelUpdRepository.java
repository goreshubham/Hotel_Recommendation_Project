package Repository;

import Models.Address;
import Models.Hotel;

public class HotelDelUpdRepository extends DBConfig {
	public boolean hdelete(int id)
	{
		try {
			stmt=con.prepareStatement("delete from hotel where hid=?");
			stmt.setInt(1,id);
		int val=stmt.executeUpdate();
		return val>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public boolean updatehotel(Hotel h)
	{
		
		
		try {
			stmt=con.prepareStatement("update hotel set hname=? where hid=?");
			stmt.setString(1,h.getName());
			stmt.setInt(2, h.getId());
			int val=stmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	public boolean addressdelete(int id)
	{
		try
		{
			stmt=con.prepareStatement("delete from address where aid=?");
			stmt.setInt(1, id);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	public boolean updateaddress(Address a)
	{
		try {
			stmt=con.prepareStatement("update address set address=?,number=?,email=? where aid=?");
			stmt.setString(1, a.getAddresses());
			stmt.setString(2,a.getNumber());
			stmt.setString(3, a.getEmail());
			stmt.setInt(4, a.getHid());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
}
