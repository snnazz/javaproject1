package libraryPR;

import java.util.Scanner;

public class Librarymain {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		Library maxcount=new Library(50,30); 
		
		                     //library turunde max count nesnesi item ve memberin 
		                    //max countunu tutar
		                   //library sinifindan bir sey kullanilacaksa  
		                  //bu nesne adi ile kullanilir program boyuncaa
				
		while(true)
		{
			System.out.println("-----------kutuph otomasyonu--------------");
			System.out.println("1-envanter ekleme");
			System.out.println("2-uye ekleme");
			System.out.println("3-materyal odunc ver");
			System.out.println("4-materyal iade et");
			System.out.println("5-uyenin aldigi  materyallerin listesi yazdir");
			System.out.println("6-sistemdeki tum materyalleri listele");
			System.out.println("7-odunc verilen tum meteryalleri listele");
			System.out.println("8-odunc verilmemis kutuph de bulunan materyalleri listele");
			System.out.println("9-sistemde kayitli uye bilgileri");
			System.out.println("0-cikis");
			
			System.out.println("yapmak istenilen islemi secin:");
			int islem=scan.nextInt();
			scan.nextLine();
			
			switch(islem)
			{
			    case 1:
			    {
			    	System.out.println("--envanter ekleme--");
			    	System.out.println("eklenecek envanter bilgileri gir:");
			    	int id=scan.nextInt();
			    	scan.nextLine();
			    	String name=scan.nextLine();
			    	String author=scan.nextLine();
			    	System.out.println("envanter  turunu seci:(1-kitap,2-dvd,3-magazin)");
			    	int tur=scan.nextInt();
			    	scan.nextLine();
			    	
			    	switch(tur)
			    	{
			    	    case 1:
			    	    	System.out.println("sayfa say girin:");
			    	    	int pagecount=scan.nextInt();
			    	    	scan.nextLine();
			    	    	System.out.println("turunu gir:");
			    	    	String genre=scan.nextLine();
			    	    	Book yenibook=new Book(id,name,author,false,pagecount,genre);
			    	    	maxcount.additems(yenibook); //kitap turu envanterine ekler
			    	    	break;
			    	    case 2:
			    	    	System.out.println("kaset suresini girin:");
			    	    	double duration=scan.nextDouble();
			    	    	System.out.println("yas siniri gir:");
			    	    	int rating=scan.nextInt();
			    	    	scan.nextLine();
			    	    	Dvd yenidvd=new Dvd(id,name,author,false,duration,rating);
			    	    	maxcount.additems(yenidvd);
			    	    	break;
			    	    case 3:
			    	    	System.out.println("baski numarasi girin:");
			    	    	int issuenumber=scan.nextInt();
			    	    	scan.nextLine();
			    	    	System.out.println("basim ayini girin:");
			    	    	String month=scan.nextLine();
			    	    	Magazine yenimagazine=new Magazine(id,name,author,false,issuenumber,month);
			    	    	maxcount.additems(yenimagazine);
			    	    	break;
			    	    default:
			    	    	System.out.println("gecersiz tur secimi..");
			    	    	break;
			    	}
			    	break;
			    }
			    case 2:
			    {
			    	System.out.println("--uye ekleme--");
			    	
			    	System.out.println("uye numarasini girin:");
			    	int memberid=scan.nextInt();
			    	scan.nextLine();
			    	System.out.println("uye adini girin:");
			    	String membername=scan.nextLine();
			    	Members memberyeni=new Members(memberid,membername);
			    	maxcount.addmembers(memberyeni);
			    	break;
			    }
			    case 3:
			    {
			    	System.out.println("---materyal odunc ver---");
			    	
			    	System.out.println("uye id si girin:");
			    	int membersid=scan.nextInt();
			    	scan.nextLine();
			    	System.out.println("alinacak materyal ismi  girin:");
			    	String materyalname=scan.nextLine();
			    	
			    	Members uyemevcut=maxcount.findmemberbyid(membersid);
			    	LibraryItem itemmevcut=maxcount.finditembyname(materyalname);
			    	
			    	if(uyemevcut==null || itemmevcut==null )
			    	{
			    		System.out.println("istenilen veri sistemde yok..");
			    		break;
			    	}
			    	if(itemmevcut.getisborrowed())
			    	{
			    		System.out.println("materyal  zaten oduc verilmis..");
			    		
			    	}
			    	else
			    	{
			    		uyemevcut.borrowbook(itemmevcut);
			    		itemmevcut.setisborrowed(true);
			    		System.out.println("materyalodunc alindi!");
		
			    	}
			    	break;
			    }
			    case 4:
			    {
			    	System.out.println("---materyal iade etme---");
			    	System.out.println("uye id si girin:");
			    	int membersid=scan.nextInt();
			    	scan.nextLine();
			    	System.out.println("verilecek materyal adi:");
			    	String materyalname=scan.nextLine();
			    	
			    	LibraryItem itemiade=maxcount.finditembyname(materyalname);
			    	Members uyemevcut=maxcount.findmemberbyid(membersid);
			    	
			    	if(uyemevcut == null || itemiade==null)
			    	{
			    		System.out.println("islem yapilacak materyal veya kullanici sistemde kayitli degil..");
			    		break;
			    	}
			    	
			    	boolean bulunuyormu=false;
			    	//kullanicini odunc aldiklari listesinde (borroweditwms de)
			    	
			    	for(int i=0;i<uyemevcut.getborrowedcount();i++)
			    	{
			    		if(uyemevcut.borroweditems[i].getname().equalsIgnoreCase(itemiade.getname()))
			    		{
			    			bulunuyormu=true;
			    			break;
			    		}
			    	}
			    	if(bulunuyormu)
			    	{
			    		uyemevcut.returnbook(itemiade);
			    		System.out.println("materyal iade edildi!");
			    	}
			    	else
			    	{
			    		System.out.println("materyali zaten odunc almamissiniz..");
			    	}
			    	break;			
			    }
			    case 5:
			    {
			    	System.out.println("--uyenin odunc aldigi materyalleri yazdir---");
			    	
			    	System.out.println("uye id nizi girin:");
			    	int membersid=scan.nextInt();
			    	scan.nextLine();
			    	
			    	Members uyemevcut=maxcount.findmemberbyid(membersid);
			    	if(uyemevcut==null)
			    	{
			    		System.out.println("uye sistemde kayitli degil!");
			    		break;
			    	}		
			    		uyemevcut.show();
			    		break;
			    }
			    case 6:
			    {
			    	System.out.println("--sistemdeki tum materyalleri yazdir--");
			    	maxcount.listallmaterials();
			    	break;
			    }
			    case 7:
			    {
			    	System.out.println("--odunc verilmis tum materyalleri listele--");
			    	maxcount.listborrowedmaterials();
			    	break;
			    	
			    }
			    case 8:
			    {
			    	System.out.println("--kutuph de odunc verilmemis materyaller--");
			    	maxcount.listnotborrowedmaterials();
			    	break;
			    }
			    case 9:
			    {
			    	System.out.println("--sistemdeki kayitli uyeler---");
			    	maxcount.listallmembers();
			    	break;
			    }
			    case 0:
			    {
			        System.out.println("cikis yapiliyor...");
			        scan.close();
			        System.exit(0);
			        break;
			    }
			    default:
			    {
			    	System.out.println("gecersiz islem!");
			    	break;
			    }			    
			        
			}
			
		}
      
	}
	
}
