package ControllerMain;

import java.io.IOException;
import java.io.PrintWriter;

import Models.Login;
import Service.LoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logg")
public class LoginMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginMain() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		 Login l=new Login();
		 HttpSession sess=request.getSession(true);
		 System.out.println(sess);
		l.setUser(request.getParameter("user"));
		 l.setPassword(request.getParameter("pass"));
		 LoginService ls=new LoginService();
		 boolean b=ls.logserv(l);
		 if(b)
		 {
			 RequestDispatcher rd=request.getRequestDispatcher("Admin2.html");
			 rd.forward(request, response);
		 }
		 else{
			 RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			 rd.forward(request, response);
			 pw.println("<h4 style='color: darkred; text-align: center; margin-top: 5%;'>Invalid user & password</h4>");
		 };
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
