package ControllerMain;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Service.HotelDelUpdService;
@WebServlet("/del")
public class DeleteHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteHotel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HotelDelUpdService ad=new HotelDelUpdService();
		int a=Integer.parseInt(request.getParameter("hid"));
		boolean b=ad.hdel(a);
		if(b)
		{
			pw.println("Hotel Deleted......");
			RequestDispatcher rd=request.getRequestDispatcher("view");
			rd.forward(request, response);
		}
		else {
			pw.println("Hotel Not Deleted......");
			RequestDispatcher rd=request.getRequestDispatcher("view");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
