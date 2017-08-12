package function;


public class personal_info {
	private String id;
	private String name;
	private String sex;
	private String age;
	private String moblie;
	private String birthday; 
	private String email;
	private String QQ;
	private String U_id;
	private String company;
	private String position;
	public void setdata(String id,String name,String sex,String age,String moblie,String birthday,String email,String QQ,String U_id,String company,String position){
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.moblie=moblie;
		this.birthday=birthday;
		this.email=email;
		this.QQ=QQ;
		this.U_id=U_id;
		this.company=company;
		this.position=position;
	}
	public String getid(){
		return id;
	}
	public String getage(){
		return age;
	}
	public String getname(){
		return name;
	}
	public String getsex(){
		return sex;
	} 
	public String getmobile(){
		return moblie;
	}
	public String getbirthday(){
		return birthday;
	}
	public String getemail(){
		return email;
	}
	public String getQQ(){
		return QQ;
	}
	public String getU_id(){
		return U_id;
	}
	public String getcompany(){
		return company;
	}
	public String getposition(){
		return position;
	}
	}
