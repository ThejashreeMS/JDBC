import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	boolean flag=true;
	do
	{
	System.out.println("*******************");
	System.out.println("Enter you choice");
	System.out.println("1. Login");
	System.out.println("2. Exit ");
	System.out.println("*******************");
	int n=scn.nextInt();
	if(n==1)
	{
		System.out.println("Enter your username: ");
		String usern=scn.next();
		System.out.println("Enter your password: ");
		String userp=scn.next();
		UserValidation uv=new UserValidation();
		String utype=uv.validateUser(usern, userp);
		if(utype!=null)
		if(utype.equals("admin"))
		{
			System.out.println("Enter your choice: ");
			System.out.println("1. Add asset ");
		    int xx=scn.nextInt();
		    if(xx==1)
		    {
			Asset aid=new Asset();
			System.out.println("Enter asset ID");
			int assetid=scn.nextInt();
			System.out.println("Enter asset name");
			String assetname=scn.next();
			System.out.println("Enter asset description");
			String assetdes=scn.next();
			System.out.println("Enter quantity");
			int quantity=scn.nextInt();
			System.out.println("Enter status");
			String status=scn.next();
			aid.setAsset(assetid, assetname, assetdes, quantity, status);
			UserValidation uv1=new UserValidation();
			uv1.addAsset(aid);
		    }
		    }
	}
	else if(n==2)
	{
		flag=false;
	}
	else
	{
		System.out.println("Choose correct option please");
	}
}while(flag);
}
}
