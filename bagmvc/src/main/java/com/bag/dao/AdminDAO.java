package com.bag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;

import com.bag.Model.AdminModel;
import com.bag.Model.UserModel;


public class AdminDAO {
	
	public static boolean login(AdminModel admin) {
		boolean flag = false;
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admindetails where admin=? and pwd=?");
			ps.setString(1,admin.getUsername());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return flag;
	}
	
	public static long isRandom2() {
		 ArrayList<Long> accno = new ArrayList<>();

       Random rand = new Random();
       long res = 0;
       
       for (int i = 0; i < 15; i++) {
           int digit = rand.nextInt(10);
           res = res * 10 + digit;
       }
       String in=res+"";

       if (!accno.contains(res) ||  in.length()!=15) {
           accno.add(res);
           return res;
       }
       
       return isRandom2();
   }
	
	public static int isRandom() {
		ArrayList<Integer> pin = new ArrayList<>();
        Random rand = new Random();
        int res = 0;
        
        for (int i = 0; i < 4; i++) {
            int digit = rand.nextInt(10);
            res = res * 10 + digit;
        }
        String in=res+"";

        if (!pin.contains(res) || in.length()!=4) {
            pin.add(res);
            return res;
        }
        
        return isRandom();
    }
	
	public static boolean createUser(UserModel user) {
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into userDetails values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getAddress());
			ps.setLong(3, user.getPhno());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAccType());
			ps.setLong(6, user.getBalance());
			ps.setString(7, user.getDob());
			ps.setLong(8, user.getAadhaar());
			ps.setLong(9, user.getAccno());
			ps.setInt(10, user.getPin());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static UserModel modifyRequestUser(long accno) {
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select fullname,address,mobno,email,acctype,dob,aadhaar,accno from userDetails where accno=?");
			ps.setLong(1,accno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				um.setFullname(rs.getString(1));
				um.setAddress(rs.getString(2));
				um.setPhno(rs.getLong(3));
				um.setEmail(rs.getString(4));
				um.setAccType(rs.getString(5));
				um.setDob(rs.getString(6));
				um.setAadhaar(rs.getLong(7));
				um.setAccno(rs.getLong(8));
			}
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
	public static boolean modifyUser(UserModel user) {
		boolean flag = false;
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("update userDetails set fullname=?,mobno=?,address=?,email=?,acctype=?,dob=?,aadhaar=? where accno=?");
			ps.setString(1, user.getFullname());
			ps.setLong(2, user.getPhno());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getEmail());
			ps.setString(5,user.getAccType());
			ps.setString(6, user.getDob());
			ps.setLong(7, user.getAadhaar());
			ps.setLong(8, user.getAccno());
			ps.executeUpdate();
            flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
//	public static String name1 = "",acctype1="";
//	public static long accountno1=0;
	public static UserModel deleteRequest(long accno) {
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select fullname,acctype,accno from userDetails where accno=?");
			ps.setLong(1,accno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				name1=rs.getString(1);
//				acctype1 = rs.getString(2);
//				accountno1 = rs.getLong(3);	
				um.setFullname(rs.getString(1));
				um.setAccType(rs.getString(2));
				um.setAccno(rs.getLong(3));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
	public static boolean deleteUser(UserModel user) {
		boolean flag = false;
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from userDetails where accno=?");
			ps.setLong(1, user.getAccno());
			ps.executeUpdate();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
//	public static String name2 = "",address2="",email2="",acctype2="",dob2="";
//	public static long accno2=0,mobno2=0,aadhaar2=0;
	public static UserModel viewUser(long accno) {
//		boolean flag = false;
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select fullname,address,mobno,email,acctype,dob,aadhaar,accno from userDetails where accno=?");
			ps.setLong(1, accno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				flag = true;
//				name2=rs.getString(1);
//				address2 = rs.getString(2);
//				mobno2 = rs.getLong(3);
//				email2 = rs.getString(4);
//				acctype2 = rs.getString(5);
//				dob2 = rs.getString(6);
//				aadhaar2 = rs.getLong(7);
//				accno2 = rs.getLong(8);
				um.setFullname(rs.getString(1));
				um.setAddress(rs.getString(2));
				um.setPhno(rs.getLong(3));
				um.setEmail(rs.getString(4));
				um.setAccType(rs.getString(5));
				um.setDob(rs.getString(6));
				um.setAadhaar(rs.getLong(7));
				um.setAccno(rs.getLong(8));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
		
	}
	
	public List<UserModel> userDetails(){
		List<UserModel> ul = new ArrayList<>();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select fullname,mobno,accno from userDetails");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserModel um = new UserModel();
				um.setFullname(rs.getString(1));
				um.setPhno(rs.getLong(2));
				um.setAccno(rs.getLong(3));
				ul.add(um);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ul;
	}
	
}


