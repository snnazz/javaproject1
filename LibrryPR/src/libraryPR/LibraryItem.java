package libraryPR;

public abstract class LibraryItem {
	
	
	private int id;
	private String name;
	private String author;
	protected boolean isborrowed=false;
	
	public LibraryItem(int id,String name,String author,boolean isborrowed)
	{
		this.id=id;
		this.name=name;
		this.author=author;
		this.isborrowed=isborrowed;
	}
	
	public int getid()
	{
		return id;
	}
	public void setid(int id)
	{
		this.id=id;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String nameyeni)
	{
		this.name=nameyeni;
	}
	public String getauthor()
	{
		return author;
	}
	public void setauthor(String authoryeni)
	{
		this.author=authoryeni;
	}
	public boolean getisborrowed()
	{
		return isborrowed;
	}
	public void setisborrowed(boolean isborrowedyenidurum)
	{
		this.isborrowed=isborrowedyenidurum;
	}
	
	public abstract String info();
	
	

}
