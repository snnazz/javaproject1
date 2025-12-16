package libraryPR;

public class Magazine extends LibraryItem {
	private int issuenumber;
	private String month;
	
	public Magazine(int id,String name,String author,boolean isborrowed,int issuenumber,String month)
	{
		super(id,name,author,isborrowed);
		if(issuenumber<1)
		{
			this.issuenumber=1;
		}
		else
		{
			this.issuenumber=issuenumber;
		}
		this.month=month;
	}
	public int getissuenumber()
	{
		return issuenumber;
	}
	public void setissuenumber(int issuenumberyeni)
	{
		if(issuenumberyeni<1)
		{
			System.out.println("degistirilecek deger gecersiz 1 atandi");
			this.issuenumber=1;
		}
		else
		{
			this.issuenumber=issuenumberyeni;
		}
	}
	public String getmonth()
	{
		return month;
	}
	public void setmonth(String monthyeni)
	{
		this.month=monthyeni;
	}
	
	@Override
	
	public String info()
	{
		return " id:" +getid () + " ,adi:" + getname() + " ,yazari:" +getauthor() + " ,borc verilmismi/bulunuyormu:"+getisborrowed()+
		         " ,baski no:" + getissuenumber() + " ,ay:" + getmonth();
	}
	

}
