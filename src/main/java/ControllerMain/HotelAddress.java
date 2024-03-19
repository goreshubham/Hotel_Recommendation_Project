package ControllerMain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Models.Address;
import Models.Hotel;
import Service.AddHotelService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addre")
public class HotelAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HotelAddress() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Address a=new Address();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		pw.println("<title>index</title>");
		pw.println("<link rel='stylesheet' href='CSS/addr.css' type='text/css'>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div class='form-2'>");
		pw.println("<form name='frm' action='addre' method='post'>");
		pw.println("<h2>Enter Hotel Address</h2><br>");
		pw.println("<input type='text' name='address' value='' placeholder='Enter Hotel Address' required><br><br>");
		pw.println("<input type='text' name='city' value='' placeholder='Enter City' required><br><br>");
		pw.println("<input type='text' name='email' value='' placeholder='Enter Email' required><br><br>");
		pw.println("<input type='text' name='number' value='' placeholder='Enter Contact Number' required><br><br>");
		pw.println("<select name='hname' class='elect'>");
		pw.println("<option>select Hotel</option>");
		AddHotelService ah=new AddHotelService();
		List<Hotel> al=ah.getHotel();
		for(Hotel h:al)
		{
			pw.println("<option value='"+h.getId()+"'>"+h.getName()+"</option>");
		}
		pw.println("</select><br><br><br>");
		pw.println("<input type='submit' name='s' value='Add Address'>");
		pw.println("</form>");
		a.setAddresses(request.getParameter("address"));
		a.setCity(request.getParameter("city"));
		a.setNumber(request.getParameter("number"));
		a.setEmail(request.getParameter("email"));
		a.setHid(Integer.parseInt(request.getParameter("hname")));
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");		
		
		AddHotelService as=new AddHotelService();
		boolean b=as.getadd(a);
		if(b)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Admin2.html");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("Admin2.html");
			pw.println("Hotel Not Added......");
			rd.include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
