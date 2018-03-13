package com.capgemini.mobilerecharge;

public interface AccountServices {
	public Account getAccountDetails(String id);
	public double rechargeAccount(String id,double amt);
}
