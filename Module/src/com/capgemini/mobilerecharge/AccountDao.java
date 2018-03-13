package com.capgemini.mobilerecharge;

public interface AccountDao {
	public Account getAccountDetails(String id);
	public double rechargeAccount(String id,double amt);
}
