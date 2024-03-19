package Service;

import java.util.List;

import Models.Address;
import Models.Hotel;
import Repository.AddHotelRepository;

public class AddHotelService {
	AddHotelRepository ad=new AddHotelRepository();
	public boolean addhotel(Hotel h)
	{
		return ad.addhotelr(h);
	}
	public boolean getadd(Address a)
	{
		return ad.addaddress(a);
	}
	public List<Hotel> getHotel()
	{
		return ad.getdata();
	}
	public List<Address> getAllInfo()
	{
		return ad.getAllHotel();
	}
}
