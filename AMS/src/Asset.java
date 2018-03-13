
public class Asset 
{
private int assetid;
private String assetname;
private String assetdes;
private int quantity;
private String status;

public void setAsset(int assetid, String assetname, String assetdes, int quantity, String status) 
{
	
	this.assetid = assetid;
	this.assetname = assetname;
	this.assetdes = assetdes;
	this.quantity = quantity;
	this.status = status;
}

public int getAssetid() {
	return assetid;
}


public String getAssetname() {
	return assetname;
}


public String getAssetdes() {
	return assetdes;
}


public int getQuantity() {
	return quantity;
}


public String getStatus() {
	return status;
}


}
