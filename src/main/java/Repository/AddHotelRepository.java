package Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Models.Address;
import Models.Hotel;

public class AddHotelRepository extends DBConfig{

	public boolean addhotelr(Hotel h)
	{
		try {
				stmt=con.prepareStatement("insert into hotel values('0',?)");
				stmt.setString(1, h.getName());
				int val=stmt.executeUpdate();
				return val>0?true:false;		
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	public boolean addaddress(Address a)
	{
		try {
			PreparedStatement stmt4=con.prepareStatement("select * from city");
			ResultSet rs1=stmt4.executeQuery();
			boolean b=true;
			while(rs1.next())
			{
				if(rs1.getString(2).equals(a.getCity()))
				{
					b=false;
					break;
				}
			}
			if(b)
			{
				PreparedStatement stmt2=con.prepareStatement("insert into city values('0',?)");
				stmt2.setString(1,a.getCity());
				stmt2.executeUpdate();
			}
			PreparedStatement stmt3=con.prepareStatement("select * from city where city=?");
			stmt3.setString(1, a.getCity());
			rs=stmt3.executeQuery();
			int cid=0;
			if(rs.next())
			{
				cid=rs.getInt(1);
			}
			stmt=con.prepareStatement("insert into address values('0',?,?,?,?,?)");
			stmt.setString(1, a.getAddresses());
			stmt.setString(2, a.getNumber());
			stmt.setString(3, a.getEmail());
			stmt.setInt(4, a.getHid());
			stmt.setInt(5, cid);
			
			int val=stmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	public List<Hotel> getdata()
	{
		try {
			stmt=con.prepareStatement("select * from hotel");
			rs=stmt.executeQuery();
			List<Hotel> l=new ArrayList<Hotel>();
			while(rs.next())
			{
				Hotel h=new Hotel();
				h.setId(rs.getInt(1));
				h.setName(rs.getString(2));
				l.add(h);
			}
			return l;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
	}
	public List<Address> getAllHotel()
	{
		List<Address> li=new ArrayList<Address>();
		try {
			stmt=con.prepareStatement("select h.hname,a.address,a.number,a.email,c.city, a.aid from hotel h inner join address a inner join city c on c.cid=a.cid and h.hid=a.hid");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				Address a=new Address();
				a.setName(rs.getString(1));
				a.setAddresses(rs.getString(2));
				a.setNumber(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setCity(rs.getString(5));
				a.setHid(rs.getInt(6));
				li.add(a);
			}
			return li;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
	}
}
