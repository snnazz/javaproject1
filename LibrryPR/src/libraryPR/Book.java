package libraryPR;

public class Book extends LibraryItem{
	
	private int pagenumber;
	private String genre;
	
	public Book(int id,String name,String author,boolean isborrowed,int pagenumber,String genre)
	{
		super(id,name,author,isborrowed);
		this.pagenumber=pagenumber;
		this.genre=genre;
	}
	public int getpagenumber()
	{
		return pagenumber;
	}
	public void setpagenumber(int pagenumberyeni)
	{
		if(pagenumberyeni<1)
		{
			System.out.println("degistirilecek sayfa say gecersiz 1 atandi..");
			this.pagenumber=1;
		}
		else
		{
			this.pagenumber=pagenumberyeni;
		}
	}
	public String getgenre()
	{
		return genre;
	}
	public void setgenre(String genreyeni)
	{
		this.genre=genreyeni;
	}
	
	@Override
	
	public String info()
	{
		return " id:" +getid () + " ,adi:" + getname() + " ,yazari:" +getauthor() + " ,borc verilmismi/bulunuyormu:"+getisborrowed() + 
				" ,sayfa say:"+getpagenumber() + " ,turu:" +getgenre();
	}
	
	

}
