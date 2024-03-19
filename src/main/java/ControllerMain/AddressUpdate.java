package ControllerMain;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/aupd")
public class AddressUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddressUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' type='text/css' href='CSS/aupd.css'>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div class='form-2'>");
		pw.println("<form name='frm' action='adupd' method='post'><br>");
		pw.println("<h1>Update Hotel Information</h1>");
		pw.println("<input type='hidden' name='aid' value='"+request.getParameter("aid")+"'>");
		pw.println("<input type='text' name='name' value='"+request.getParameter("name")+"' readonly='readonly' placeholder='Enter Hotel Name'><br>");
		pw.println("<input type='text' name='address' value='"+request.getParameter("address")+"' placeholder='Enter Hotel Address'><br>");
		pw.println("<input type='text' name='number' value='"+request.getParameter("number")+"' placeholder='Enter Hotel Number'><br>");
		pw.println("<input type='text' name='email' value='"+request.getParameter("email")+"' placeholder='Enter Hotel Email'><br>");
		pw.println("<input type='text' name='city' value='"+request.getParameter("city")+"' readonly='readonly' placeholder='Enter Hotel City'><br>");
		pw.println("<input type='submit' name='s' value='Update Hotel'><br><br>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
