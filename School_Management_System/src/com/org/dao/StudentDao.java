package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.student;
import com.org.helper.ConnectionHelper;

public class StudentDao {
	
	Connection con = ConnectionHelper.getConObj();

	public boolean saveStudent(student s) {
		String sql = "INSERT INTO school.student VALUES( ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, s.getRoll());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setInt(4, s.getAge());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//Close Coonecrtion Method
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Executing the Select query
	
	public List<student> getStudents(){
		String query = "SELECT * FROM student";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ArrayList<student> li = new ArrayList<student>();
		
			while(rs.next()) {
				student s = new student();
				s.setRoll(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAge(rs.getInt(4));
				li.add(s);
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
	
	// For delete Operation
	
	public boolean deleteStudent(int roll) {
		String sql = "DELETE FROM student WHERE id = "+roll;
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
	
	// Upadate Operation on Name
	
	 public boolean updateStudentName(int roll ,String name) {
		 String query = "UPDATE student SET name ='"+name+"' where id ="+roll;
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
	 
	 //Update Operation On Email 
	 
	 public boolean updateStudentEmail(int roll,String email) {
		 String query = "UPDATE student SET email ='"+email+"' where id ="+roll;
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
	 
	 // Update Operation On Age
	 
	 public boolean updateStudentAge(int roll,int age) {
		 String query = "UPDATE student SET age ="+age+" where id ="+roll;
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
	 
	 //Prepared Statement 

	 public boolean updateAllDetails(int roll,String name,String email,int age) {
		 String query = "UPDATE student SET name = ? , email = ? , age = ? where id = ?";
		 try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, age);
			ps.setInt(4, roll);
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
	 
}