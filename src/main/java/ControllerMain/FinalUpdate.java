package ControllerMain;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Models.Hotel;
import Service.HotelDelUpdService;

@SuppressWarnings("serial")
@WebServlet("/fu")
public class FinalUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id1=Integer.parseInt(request.getParameter("hid"));
		String name1=request.getParameter("name");
		System.out.println(id1+"\t"+name1);
		Hotel h=new Hotel();
		
		h.setId(id1);
		h.setName(name1);
		HotelDelUpdService hd=new HotelDelUpdService();
		boolean b=hd.updatedata(h);
		System.out.println(b);
		if(b)
		{
			RequestDispatcher rd=request.getRequestDispatcher("view");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("upd");
			rd.include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
