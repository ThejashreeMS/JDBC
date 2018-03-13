package com.capgemini.mobilerecharge;

public class Account {
private String accountID;
private String accounttype;
private String cname;
private double accountbal;

public void accSet(String aId,String atype,String cname,double abal)
{
	this.accountID=aId;
	this.accounttype=atype;
	this.cname=cname;
	this.accountbal=abal;
}
public String accGet()
{
	return "The account id is= "+accountID+" The balance is = "+accountbal+" account type is = "+accounttype;
}
}
