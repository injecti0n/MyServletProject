package com.MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getParameters")
public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	int count;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		handleRequest(req, resp);
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		count++;
		resp.setContentType("text/html");
		
		// Get Parameters From The Request
		String param1 = req.getParameter("param1");
		String param2 = req.getParameter("param2");
		String[] paramArray = req.getParameterValues("paramArray");

		if (param1 == null || param2 == null || paramArray == null) {

		} else if ("".equals(param1) || "".equals(param2) || "".equals(paramArray)) {

		} else {
			System.out.println("Parameter1?= " + param1 + ", Parameter2?= " + param2 + ", Array Parameters?= "
					+ Arrays.toString(paramArray));

			// Print The Response
			PrintWriter out = resp.getWriter();
			out.write("<html><body><style>body{background-color:#000} h2{color:yellow} p{color:white}</style><div id='serlvetResponse'>");
			out.write("<h2>Follow the params"+count+"</h2>");
			out.write("<p>getParameters?param1=STRINGparam2=STRING&paramArray=DAY&paramArray=MONTH&paramArray=YEAR</p>");
			out.write("<p>param1: " + param1 + "</p>");
			out.write("<p>param2: " + param2 + "</p>");
			out.write("<p>paramArray: " + Arrays.toString(paramArray) + "</p>");
			out.write("</div></body></html>");
			out.close();
		}
	}
}