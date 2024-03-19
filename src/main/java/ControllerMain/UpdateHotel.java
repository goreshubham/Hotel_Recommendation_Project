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
import Service.HotelDelUpdService;
@WebServlet("/upd")
public class UpdateHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateHotel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("hid");
		String name=request.getParameter("name");
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' type='text/css' href='CSS/upd.css'>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div class='form-2'>");
		pw.println("<form name='frm' action='fu' method='post'><br>");
		pw.println("<h1>Update Hotel</h1>");
		pw.println("<input type='hidden' name='hid' value='"+id+"'>");
		pw.println("<input type='text' name='name' value='"+name+"' placeholder='Enter Hotel Name'>");
		pw.println("<input type='submit' name='su' value='Update Hotel'><br><br>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
