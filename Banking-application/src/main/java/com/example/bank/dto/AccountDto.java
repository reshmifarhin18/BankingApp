package com.example.bank.dto;

public class AccountDto {
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDto(int id, String accHolderName, int age, double balance) {
		super();
		this.id = id;
		this.accHolderName = accHolderName;
		this.age = age;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	private int id;
	private String accHolderName;
	private int age;
	private double balance;

	

}
