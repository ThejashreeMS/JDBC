package com.capgemini.mobilerecharge;

public class AccountServicesImpl implements AccountServices {
	public Account getAccountDetails(String id)
	{
		AccountDaoImpl ad=new AccountDaoImpl();
		Account a=ad.getAccountDetails(id);
		return a;

	}
	public double rechargeAccount(String id,double amt)
	{
		double bal=0;
		AccountDaoImpl ad=new AccountDaoImpl();
		bal=ad.rechargeAccount(id, amt);
		return bal;	
	}
}
