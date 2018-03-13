
public class Foo {
public static void main(String[] args) {
	int i=1;
	int c=1;
	while(i<=4)
	{
	int j=1;
	while(j<=i&&c<=9)
	{
		System.out.print(c);
		j++;
		c++;
	}
	System.out.println();
	i++;		
}
}
}