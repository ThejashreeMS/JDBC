
public class MyOwnException extends RuntimeException {
	@Override
	public String getLocalizedMessage()
	{
		return "invalid";
	}
	
}
