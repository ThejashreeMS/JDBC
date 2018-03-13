package com.capgemini.mobilerecharge;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	boolean flag=true;
	do
	{
	System.out.println("Enter choice:");
	System.out.println("1. Get Account Details");
	System.out.println("2. Recharge Account");
	System.out.println("3. Exit");
	Scanner scn=new Scanner(System.in);
	int n=scn.nextInt();
	AccountServicesImpl asi=new AccountServicesImpl();
	if(n==1)
	{
		System.out.println("Enter id:");
		String id=scn.next();
		System.out.println("*********************************");
		asi.getAccountDetails(id);
		System.out.println("*********************************");
}
	else if(n==2)
	{
		System.out.println("Enter id:");
		String id=scn.next();
		System.out.println("Enter amount:");
		Double amt=scn.nextDouble();
		System.out.println("*********************************");
		asi.rechargeAccount(id, amt);
		System.out.println("*********************************");
	}
	else if(n==3)
	{
		flag=false;
		System.out.println("*********************************");
		System.out.println("Transanction Complete");
		System.out.println("*********************************");
	}
	else
	{
		System.out.println("*********************************");
		System.out.println("Enter valid option");
		System.out.println("*********************************");

	}
	}while(flag);
}
}
