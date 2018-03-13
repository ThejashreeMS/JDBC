
public class Account {
private String accountID;
private String accountType;
private String customerName;
private double accountBalance;
public String getAccountID() {
	return accountID;
}
public void setAccountID(String accountID) {
	this.accountID = accountID;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public double getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}
@Override
public String toString() {
	return "Account [accountID=" + accountID + ", accountType=" + accountType + ", customerName=" + customerName
			+ ", accountBalance=" + accountBalance + "]";
}


}
