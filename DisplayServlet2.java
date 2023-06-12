package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DisplayServlet2")
public class DisplayServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		PrintWriter out = response.getWriter();
		
		if(session!=null) {
			
			String name=(String)session.getAttribute("name");
			
			String company =(String)session.getAttribute("company");
			
	
			
			out.print(name);
			out.print(company);
			
		}else {
			
			
			 out.print("Please create session first");  
			 out.print("<br>");
	            request.getRequestDispatcher("createSession.html").include(request, response); 
		}
		
	}

}
