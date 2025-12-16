package libraryPR;

public class Dvd extends LibraryItem {
	private double duration;
	private int rating;
	
	public Dvd(int id , String name,String author,boolean isborrowed,double duration,int rating)
	{
		super(id,name,author,isborrowed);
		if(duration<1)
		{
			this.duration=1.0;
		}
		else
		{
			this.duration=duration;
		}
		this.rating=rating;
	}
	public double getduration()
	{
		return duration;
	}
	public void setduration(double durationyeni)
	{
		if(durationyeni<1)
		{
			System.out.println("degistirilecek sure gecersiz 1 atandi");
			this.duration=1.0;
		}
		else
		{
			this.duration=durationyeni;
		}
	}
	public int getrating()
	{
		return rating;
	}
	public void setrating(int ratingyeni)
	{
		if(ratingyeni<0)
		{
			this.rating=0;
		}
		else
		{
			this.rating=ratingyeni;
		}
	}
	
	@Override
	public String info()
	{
		return " id:" +getid () + " ,adi:" + getname() + " ,yazari:" +getauthor() + " ,borc verilmismi/bulunuyormu:"+getisborrowed() + 
				" ,sure:" + getduration() + " ,yassinir:" + getrating();
	}
}
