package Code;
//Values class is created to store key,values and status when two key-value pairs are compared


public class Values {
	public String key;
	public String value1;
	public String value2;
	public String status;
	
	public Values(String key,String value1, String value2, String status)				//parameterized constructor
	{
		this.key=key;
		this.value1=value1;
		this.value2=value2;
		this.status=status;
	}
	public String myGetKey()															//getter methods
	{
		return key;
	}
	public String getValue1()
	{
		return value1;
	}
	public String getValue2()
	{
		return value2;
	}
	public String getStatus()
	{
		return status;
	}

}
