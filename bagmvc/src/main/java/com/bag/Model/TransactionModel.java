package com.bag.Model;

import java.sql.Timestamp;

import com.mysql.cj.protocol.InternalTimestamp;
public class TransactionModel {
	private int id;
	private long accno;
	private Timestamp date;
	private long amount;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp timestamp) {
		this.date = timestamp;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String acctype) {
		this.type = acctype;
	}
	
	
}
