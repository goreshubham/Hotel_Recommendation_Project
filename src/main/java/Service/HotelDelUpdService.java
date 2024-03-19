package Service;

import Models.Address;
import Models.Hotel;
import Repository.HotelDelUpdRepository;

public class HotelDelUpdService {
	HotelDelUpdRepository ad=new HotelDelUpdRepository();
	public boolean hdel(int id)
	{
		return ad.hdelete(id);
	}
	public boolean updatedata(Hotel h)
	{
		return ad.updatehotel(h);
	}
	public boolean deleteaddress(int id)
	{
		return ad.addressdelete(id);
	}
	public boolean UpdateAddress(Address a)
	{
		return ad.updateaddress(a);
	}
}
