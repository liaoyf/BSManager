package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ObjectGeter.Function_geter;
import com.ObjectGeter.User_geter; 
import com.bsObject.Function;
import com.bsObject.User;
import com.ins.Connectsql;
import com.ins.exeInsertUpdateDelete;

public class ChangePower extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChangePower() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ispowerchangesuccess = false;
		exeInsertUpdateDelete exidu = new exeInsertUpdateDelete(
				new Connectsql().Getconnection());
		String user_id = request.getParameter("user_id");
		String[] selected = request.getParameterValues("left");

		Hashtable<String, String> hs_delete = new Hashtable<String, String>();
		hs_delete.put("USER_ID", user_id);
		try {
			if (exidu.execSql("D_R_USERFUN", exeInsertUpdateDelete.DELETE,
					hs_delete))
				System.out.println("删除成功�");
			if (selected == null)
				ispowerchangesuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (selected != null) {
			String sql_hearder = "insert into D_R_USERFUN(USER_ID,FUNCTION_ID) values("
					+ user_id + ",";
			String[] sql_insert = new String[selected.length];
			for (int i = 0; i < selected.length; i++) {
				sql_insert[i] = sql_hearder + selected[i] + ")";
			}
			if (exidu.execSql(sql_insert)) {
				System.out.println("修改权限成功!");
				ispowerchangesuccess = true;
			}
		}
		response.sendRedirect("../Usermanage.jsp?ispowerchangesuccess="
				+ ispowerchangesuccess + "&uid=" + user_id);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
