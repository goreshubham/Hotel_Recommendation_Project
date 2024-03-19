package ControllerMain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import Models.Hotel;
import Service.AddHotelService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewHotel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' type='text/css' href='CSS/view.css'>");
		pw.println("</head>");
		pw.println("<body>");
		RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
		rd.include(request, response);
		pw.println("<div class='form-2'>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<th>Sr.No</th>");
		pw.println("<th>Hotel Name</th>");
		pw.println("<th>Update</th>");
		pw.println("<th>Delete</th>");
		pw.println("</tr>");
		AddHotelService ah=new AddHotelService();
		List<Hotel> al=ah.getHotel();
		int count=0;
		for(Hotel h:al)
		{
			count++;
			pw.println("<tr>");
			pw.println("<td>"+count+"</td>");
			pw.println("<td>"+h.getName()+"</td>");
			pw.println("<td><a href=upd?hid="+h.getId()+"&name="+h.getName()+" class='anchor''> Update Hotel</a></td>");
			pw.println("<td><a href=del?hid="+h.getId()+" class='anchor''> Delete Hotel</a></td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("<br><span>Total Hotels : "+al.size()+"</span>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
