package com.carwale;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/viewcardetails")
public class viewcardetails extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/carwale?user=root&password=silesh95");
			String sql="SELECT * FROM car";
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			PrintWriter pWriter=res.getWriter();
			pWriter.write("<html><body><table border=1>");
			pWriter.write("<thead><th>ID</th><th>NAME</th><th>PRICE</th><th>TYPE</th><thead>");
			while(resultSet.next()) {
				pWriter.write("<tr><td>"+resultSet.getInt(1)+"</td>");
				pWriter.write("<td>"+resultSet.getString(2)+"</td>");
				pWriter.write("<td>"+resultSet.getInt(3)+"</td>");
				pWriter.write("<td>"+resultSet.getString(4)+"</td></tr>");
			}
			pWriter.write("</table></body></html");
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
