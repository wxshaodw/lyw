package function;

public class diary {
	private String id="";
	private String date="";
	private String title="";
	private String diary_data="";
	private String u_id="";
	private String address="";
	public void setdata(String id,String date,String diary_data,String u_id,String title,String address){
		this.id=id;
		this.date=date;
		this.title=title;
		this.diary_data=diary_data;
		this.u_id=u_id;
		this.address=address;
	}
	public String getid(){
		return id;
	}
	public String getdate(){
		return date;
	}
	public String gettitle(){
		return title;
	}
	public String getdiary_data(){
		return diary_data;
	}
	public String getu_id(){
		return u_id;
	}
	public String getaddress(){
		return address;
	}
}
