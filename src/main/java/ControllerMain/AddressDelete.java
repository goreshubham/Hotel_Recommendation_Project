package ControllerMain;

import java.io.IOException;
import java.io.PrintWriter;

import Service.HotelDelUpdService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/adel")
public class AddressDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddressDelete() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HotelDelUpdService hd=new HotelDelUpdService();
		boolean b=hd.deleteaddress(Integer.parseInt(request.getParameter("aid")));
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
