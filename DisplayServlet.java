package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		
		String company=request.getParameter("company");
		
		
		request.getRequestDispatcher("index.html").include(request, response);
		
		if(name!=null) {
			
			
			HttpSession session =request.getSession();
			
			session.setAttribute("name",name);
			session.setAttribute("company",company);
			out.print("Successfully created session");
			out.print("<br>");
			out.print(name);
			out.print("<br>");
			out.print(company);
			
			
		}else {
			
			out.print("Company name and name does not match");
			out.print("<br>");
			request.getRequestDispatcher("index.html").include(request, response);
			
		}
	}

}
