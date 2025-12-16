package libraryPR;

public class Members {
	
	private int memberid;
	private String membername;
	protected LibraryItem[] borroweditems;
	private int borrowedcount;
	private int maxborrowedcount;
	
	public Members(int memberid,String membername)
	{
		this.memberid=memberid;
		this.membername=membername;
		this.borrowedcount=0;
		this.maxborrowedcount=5;
		this.borroweditems=new LibraryItem[5];
	}
	
	public int getmaxborrowedcount()
	{
		return maxborrowedcount;
	}
	public void setmaxborrowedcount(int maxborrowedcountyeni)
	{
		if(maxborrowedcount<1)
		{
			System.out.println("degistirlmek istenen degr gecersiz 1 atandi...");
			this.maxborrowedcount=1;
			return;
		}
		this.maxborrowedcount=maxborrowedcountyeni;
	}
	
	public int getmemberid()
	{
		return memberid;
	}
	public void setmemberid(int memberidyeni)
	{
		if(memberidyeni<1)
		{
			System.out.println("degistirilecek kullanici id gecersiz 1 atandi");
			this.memberid=1;
		}
		else
		{
			this.memberid=memberidyeni;
		}
	}
	
	
	public String getmembername()
	{
		return membername;
	}
	public void setmembername(String membernameyeni)
	{
		this.membername=membernameyeni;
	}
	
	
	public int getborrowedcount()
	{
		return borrowedcount;
	}
	public void setborrowedcount(int borrowedcountyeni)
	{
		if(borrowedcountyeni<0)
		{
			System.out.println("degistirilmek istenen miktar gecersiz 0 atandi ..");
			this.borrowedcount=0;
		}
		else
		{
			this.borrowedcount=borrowedcountyeni;
		}
	}
	
	public void borrowbook(LibraryItem itemyeni)
	{
		for(int i=0;i<borrowedcount;i++)
		{
			if(borroweditems[i]==itemyeni)
			{
				System.out.println("bu materyal zaten oduncte..");
				return;
			}
		}
		if(borrowedcount>=borroweditems.length)
		{
			System.out.println("daha fazla materyal alinamaz odunc siniri doldu..");
		}
		else
		{
			borroweditems[borrowedcount]=itemyeni;
			borrowedcount++;
			itemyeni.setisborrowed(true);
			
			System.out.println(itemyeni.getname()+"  odunc verildi");
		}
	}
	
	public void returnbook(LibraryItem geriverilecek)
	{
		if(borrowedcount==0)
		{
			System.out.println("su an oduc alinan materyal yok geri verlemez...");
			return;
		}
		for(int i=0;i<borroweditems.length;i++)
		{
			if(borroweditems[i]==geriverilecek)
			{
				borroweditems[i]=null;
				borrowedcount--;
				geriverilecek.setisborrowed(false);
				System.out.println(geriverilecek.getname() +" materyali geri verildi");
				return;
			}
		}
		System.out.println("bu materyal listede yok..");
	}
	
	
	public void show()
	{
			if(borrowedcount==0)
			{
				System.out.println(membername+" adli uyenin oduc aldigi materyal yok..");
				return;
			}
			System.out.println(membername+ "adli uyenin odunc aldigi materyaller:");
			for(int i=0;i<borrowedcount;i++)
			{
				if(borroweditems[i]!=null)
				{
					System.out.println(borroweditems[i].info());
				}
			}
		
	}
}
