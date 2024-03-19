package ControllerMain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Models.Address;
import Service.AddHotelService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/viewall")
public class ViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewAll() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");;
	PrintWriter pw=response.getWriter();
	RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
	rd.include(request, response);
	pw.println("<!DOCTYPE html>");
	pw.println("<html>");
	pw.println("<head>");
	pw.println("<meta charset='utf-8'>");
	pw.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
	pw.println("<title>View All</title>");
	pw.println("<link rel='stylesheet' type='text/css' href='CSS/ViewAll.css'>");
	pw.println("</head>");
	pw.println("<body>");
	AddHotelService ah=new AddHotelService();
	List<Address>li=ah.getAllInfo();
	pw.println("<div class='divdiv'>");
	pw.println("<table class='formdiv'>");
	pw.println("<span>Total : "+li.size()+"</span><br><br>");
	pw.println("<tr>");
	pw.println("<th>Sr.No.</th>");
	pw.println("<th>Hotel Name</th>");
	pw.println("<th>Email</th>");
	pw.println("<th>City</th>");
	pw.println("<th>Address</th>");
	pw.println("<th>Number</th>");
	pw.println("<th>Update</th>");
	pw.println("<th>Delete</th>");
	pw.println("</tr>");
	int count=0;
	for(Address a:li)
	{
		count++;
		pw.println("<tr>");
		pw.println("<td>"+count+"</td>");
		pw.println("<td>"+a.getName()+"</td>");
		pw.println("<td>"+a.getEmail()+"</td>");
		pw.println("<td>"+a.getCity()+"</td>");
		pw.println("<td>"+a.getAddresses()+"</td>");
		pw.println("<td>"+a.getNumber()+"</td>");
		pw.println("<td><a href='aupd?aid="+a.getHid()+"&name="+a.getName()+"&address="+a.getAddresses()+"&number="+a.getNumber()+"&email="+a.getEmail()+"&city="+a.getCity()+"' class='anc'>Update<a></td>");
		pw.println("<td><a href='adel?aid="+a.getHid()+"' class='anc'>Delete<a></td>");
		pw.println("</tr>");
	}
	pw.println("</table>");
	pw.println("</div>");
	pw.println("</body>");
	pw.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
