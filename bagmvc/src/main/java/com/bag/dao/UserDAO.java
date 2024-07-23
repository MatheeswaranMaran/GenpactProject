package com.bag.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bag.Model.*;

public class UserDAO {
//	public static String namel ,addressl,emaill,acctypel,dobl;
//	public static long mobnol,aadhaarl,accountnol,balancel;
	public static UserModel login(long accno,int pin) {
//		boolean flag = false;
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select fullname,address,mobno,email,acctype,dob,aadhaar,accno,balance  from userDetails where accno=? and pin=?");
			ps.setLong(1,accno);
			ps.setInt(2,pin);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				flag = true;
//				namel=rs.getString(1);
//				addressl = rs.getString(2);
//				mobnol = rs.getLong(3);
//				emaill = rs.getString(4);
//				acctypel = rs.getString(5);
//				dobl = rs.getString(6);
//				aadhaarl = rs.getLong(7);
//				accountnol = rs.getLong(8);
//				balancel = rs.getLong(9);
				um.setFullname(rs.getString(1));	
				um.setAddress(rs.getString(2));
				um.setPhno(rs.getLong(3));
				um.setEmail(rs.getString(4));
				um.setAccType(rs.getString(5));
				um.setDob(rs.getString(6));
				um.setAadhaar(rs.getLong(7));
				um.setAccno(rs.getLong(8));
				um.setBalance(rs.getLong(9));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return um;
	}
//	public static long balance=0,accno=0;
	public static UserModel depositVerify(int pin) {
//		boolean result = false;
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select balance,accno from userDetails where pin=?");
			ps.setInt(1,pin);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				balance = rs.getLong(1);
//				accno = rs.getLong(2);
//				result = true;
				um.setBalance(rs.getLong(1));
				um.setAccno(rs.getLong(2));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
	public static boolean depositCompletion(long amount,long accno) {
		boolean flag = false;
		String type = "Deposit";
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("update userDetails set balance = balance+? where accno=? ");
			ps.setLong(1,amount);
			ps.setLong(2, accno);
			int rs = ps.executeUpdate();
			if(rs>0) {
				PreparedStatement ps1 = con.prepareStatement("insert into transactionDetails(accno,amount,type) values(?,?,?) ");
				ps1.setLong(1, accno);
				ps1.setLong(2, amount);
				ps1.setString(3, type);
				int rs1 = ps1.executeUpdate();
				if(rs1>0) {
					flag = true;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
//	public static long balance1=0,accno1=0;
	public static UserModel withdrawVerify(int pin) {
//		boolean flag = false;
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select balance,accno from userDetails where pin=?");
			ps.setInt(1,pin);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				balance1 = rs.getLong(1);
//				accno1 = rs.getLong(2);
//				flag = true;
				um.setBalance(rs.getLong(1));
				um.setAccno(rs.getLong(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
	public static boolean withdrawCompletion(long amount,long accno,long balance) {
		boolean flag = false;
		String type = "Withdraw";
		try {
			Connection con = JDBConnectivity.getConnection();
			if(balance>=amount) {
				PreparedStatement ps = con.prepareStatement("update userDetails set balance = balance-? where accno=? ");
				ps.setLong(1,amount);
				ps.setLong(2, accno);
				int rs = ps.executeUpdate();
				if(rs>0) {
					PreparedStatement ps1 = con.prepareStatement("insert into transactionDetails(accno,amount,type) values(?,?,?) ");
					ps1.setLong(1, accno);
					ps1.setLong(2, amount);
					ps1.setString(3, type);
					int rs1 = ps1.executeUpdate();
					if(rs1>0) {
						flag = true;
					}
				}
			}
			else {
				flag = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static List<TransactionModel> viewTransaction(long accno){
			List<TransactionModel> list = new ArrayList<>();
	     try (Connection con = JDBConnectivity.getConnection()) {
	    	 String query = "select * from transactionDetails where accno=? order by id desc limit 10";
	    	 PreparedStatement pst = con.prepareStatement(query);
				pst.setLong(1, accno);
				ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						TransactionModel cm = new TransactionModel();
						cm.setId(rs.getInt(1));
						cm.setAccno(rs.getLong(2));
						cm.setDate(rs.getTimestamp(3));
						cm.setAmount(rs.getLong(4));
						cm.setType(rs.getString(5));
						list.add(cm);
					}
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     System.out.println("List:"+list);
	     return list;
	}
//	public static long balance3,accno3;
	public static UserModel closeVerify(int pin) {
//		boolean flag = false;
		UserModel um = new UserModel();
		try {
				Connection con = JDBConnectivity.getConnection();
				PreparedStatement ps = con.prepareStatement("select balance,accno from userDetails where pin=?");
				ps.setInt(1,pin);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
//					balance3 = rs.getLong(1);
//					accno3 = rs.getLong(2);
//					flag = true;
					um.setBalance(rs.getLong(1));
					um.setAccno(rs.getLong(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
	public static boolean closeCompletion(long accno) {
		boolean flag = false;
		try {
		Connection con = JDBConnectivity.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from userDetails where accno=? ");
		ps.setLong(1, accno);
		int rs = ps.executeUpdate();
		if(rs>0) {
			PreparedStatement ps1 = con.prepareStatement("delete from transactionDetails where accno=?");
			ps1.setLong(1, accno);
			int rs1 = ps1.executeUpdate();
			if(rs1>0) {
				flag = true;
			}
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return flag;
	}
//	public static long accnom = 0;
	public static UserModel modifyRequest(long accno,int pin) {
//		boolean flag = false;
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select accno,pin from userDetails where accno=? and pin=?");
			ps.setLong(1,accno);
			ps.setInt(2,pin);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
//				flag = true;
//				accnom = rs.getLong(1);
				um.setAccno(rs.getLong(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
	
	public static boolean modifyCompletion(int pass,long accno) {
		boolean flag = false;
		try {
		Connection con = JDBConnectivity.getConnection();
		PreparedStatement ps = con.prepareStatement("update userDetails set pin=? where accno=? ");
		ps.setInt(1,pass);
		ps.setLong(2, accno);
		int rs = ps.executeUpdate();
		if(rs>0) {
			flag = true;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
//	public static long balanceg = 0;
	public static UserModel getBalance(long accno) {
		UserModel um = new UserModel();
		try {
			Connection con = JDBConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select balance from userDetails where accno=?");
			ps.setLong(1,accno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
//				balanceg = rs.getLong(1);
				um.setBalance(rs.getLong(1));			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return um;
	}
}
