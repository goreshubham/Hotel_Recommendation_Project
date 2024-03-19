package ControllerMain;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Models.Hotel;
import Service.AddHotelService;
@SuppressWarnings("serial")
@WebServlet("/addh")
public class AddHotels extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' type='text/css' href='CSS/add.css'>");
		pw.println("</head>");
		pw.println("<body>");
		RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
		rd.include(request, response);
		pw.println("<div class='form-1'>");
		pw.println("<h2>Add Hotel</h2><br>");
		pw.println("<form name='frm' action='' method='post'>");
		pw.println("<input type='text' name='hotel' value='' placeholder='Enter Hotel Name'><br><br>");
		pw.println("<input type='submit' name='s' value='Add Hotel'>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</body>");	
		pw.println("</html>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			Hotel h=new Hotel();
			AddHotelService ah=new AddHotelService();
			h.setName(request.getParameter("hotel"));
			ah.addhotel(h);
			RequestDispatcher r=request.getRequestDispatcher("addre");
			r.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
