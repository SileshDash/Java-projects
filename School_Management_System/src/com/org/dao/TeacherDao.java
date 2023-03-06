package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.teacher;
import com.org.helper.ConnectionHelper;

public class TeacherDao {

	Connection con = ConnectionHelper.getConObj();
	public boolean saveTeacher(teacher t) {
		String sql = "INSERT INTO school.teacher VALUES( ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getSubject());
			ps.setInt(4, t.getPhone());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// Executing the Select query
	
	public List<teacher> getTeachers(){
		String query = "SELECT * FROM teacher";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ArrayList<teacher> li = new ArrayList<>();
		
			while(rs.next()) {
				teacher t = new teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setSubject(rs.getString(3));
				t.setPhone(rs.getInt(4));
				li.add(t);
			}
			return li;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	//Delete Teacher data
	public boolean deleteTeacher(int id) {
		String sql = "DELETE FROM teacher WHERE id = "+id;
		try {
			Statement st = con.createStatement();
			int res = st.executeUpdate(sql);
			if(res!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Update Operation On Name
	public boolean updateTeacherName(int id,String name) {
		String query ="UPDATE teacher SET name = '"+name+"' WHERE ID ="+id;
		try {
			Statement st = con.createStatement();
			int res = st.executeUpdate(query);
			if(res!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Update Operation On Subject
	public boolean updateTeacherSubject(int id,String subject) {
		String query = "UPDATE teacher SET subject ='"+subject+"' WHERE id ="+id;
		try {
			Statement st = con.createStatement();
			int res = st.executeUpdate(query);
			if(res!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Update Operation On Phone
	public boolean updateTeacherPhone(int id,int phone) {
		String query = "UPDATE teacher SET phone = "+phone+" WHERE ID ="+id;
		try {
			Statement st = con.createStatement();
			int res = st.executeUpdate(query);
			if(res != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Prepared Statement for add all detailed of teacher all at a time
	public boolean updateAllDeatiled(int id,String name,String subject,int phone) {
		 String query = "UPDATE teacher SET name = ? , subject = ? , phone = ? where id = ?";
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			 ps.setString(1, name);
			 ps.setString(2, subject);
			 ps.setInt(3, phone);
			 ps.setInt(4, id);
			 int res = ps.executeUpdate();
			 if(res != 0) {
				 return true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return false;
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
}
