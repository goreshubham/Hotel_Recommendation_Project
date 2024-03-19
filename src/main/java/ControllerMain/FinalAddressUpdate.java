package ControllerMain;

import java.io.IOException;

import Models.Address;
import Service.HotelDelUpdService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/adupd")
public class FinalAddressUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FinalAddressUpdate() {
        super();
 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address a=new Address();
		a.setHid(Integer.parseInt(request.getParameter("aid")));
		a.setAddresses(request.getParameter("address"));
		a.setNumber(request.getParameter("number"));
		a.setEmail(request.getParameter("email"));
		HotelDelUpdService hd=new HotelDelUpdService();
		boolean b=hd.UpdateAddress(a);
		if(b)
		{
			RequestDispatcher rd=request.getRequestDispatcher("viewall");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("viewall");
			rd.include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
