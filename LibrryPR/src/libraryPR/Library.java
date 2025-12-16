package libraryPR;

public class Library {
	
	protected LibraryItem[] items;
	protected Members[] membersitem;
	private int itemcount;
	private int memberscount;
	
	public Library(int maxitemcount,int maxmemberscount)
	{
		this.items=new LibraryItem[maxitemcount];
		this.membersitem=new Members[maxmemberscount];
		this.itemcount=0;
		this.memberscount=0;
	}
	public int getitemcount()
	{
		return itemcount;
	}
	public void setitemcount(int bookcountyeni)
	{
		if(bookcountyeni<0)
		{
			System.out.println("degistirilecek deger gecersiz 0 atandi");
			this.itemcount=0;
		}
		else
		{
			this.itemcount=bookcountyeni;
		}
	}
	
	public int getmemberscount()
	{
		return memberscount;
	}
	
	public void setmemberscount(int memberscountyeni)
	{
		if(memberscountyeni<0)
		{
			System.out.println("degisitrilecek uye say gecersiz 0 atandi..");
			this.memberscount=0;
		}
		else
		{
			this.memberscount=memberscountyeni;
		}
	}
	
	
	public void additems(LibraryItem itemsyeni)
	{
		if(this.itemcount>=items.length)
		{
			System.out.println("materyal alma limiti doldu");
			return;
		}
		this.items[this.itemcount]=itemsyeni;
		this.itemcount++;
		System.out.println(itemsyeni.getname()+" kutuphaneye eklendi");
	}
	
	public void addmembers(Members memberyeni)
	{
		if(this.memberscount>=membersitem.length)
		{
			System.out.println("uye limiti dolu.. ");
			return;
		}
		this.membersitem[this.memberscount]=memberyeni;
		this.memberscount++;
		System.out.println("yeni " +memberyeni.getmembername()+" uyesi sisteme kayitlandi..");
	}
	
	public Members findmemberbyid(int id)
	{
		for(int i=0;i<memberscount;i++)
		{
			if(membersitem[i] instanceof Members)
			{
				Members m=(Members) membersitem[i];
				if(m.getmemberid()==id)
				{
					return m;
				}
			}
		}
		return null;
	}
	
	public LibraryItem finditembyname(String name)
	{
		for(int i=0;i<itemcount;i++)
		{
			if(items[i].getname().equalsIgnoreCase(name))
			{
				return items[i];
			}
		}
		return null;
	}
	
	public void listallmaterials()
	{
		System.out.println("kayitli materyaller:");
		for(int i=0;i<itemcount;i++)
		{
			System.out.println((i+1)+"."+items[i].info());
		}
	}
	
	public void listallmembers()
	{
		System.out.println("kayitli kullanicilar:");
		for(int i=0;i<memberscount;i++)
		{
			System.out.print((i+1)+".");  membersitem[i].show();
		}
	}
	
	public void listborrowedmaterials()
	{
		System.out.println("odunc verilen materyaller:");
		for(int i=0;i<itemcount;i++)
		{
			if(items[i].getisborrowed())
			{
				System.out.println(items[i].info());
			}
		}
			
	}
	
	public void listnotborrowedmaterials()
	{
		System.out.println("odunc alinmamis materyaller:");
		for(int i=0;i<itemcount;i++)
		{
			if(!items[i].getisborrowed())
			{
				System.out.println(items[i].info());
			}
		}
	}
}
		