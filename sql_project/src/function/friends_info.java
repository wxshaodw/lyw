package function;

public class friends_info {
	private String id="";
	private String name="";
	private String sex="";
	private String age="";
	private String phone="";
	private String birthday="";
	private String mobile="";
	private String email="";
	private String QQ="";
	private String U_id="";
	private String mobile2="";
	private String company="";
	private String position="";
	private String remark="";
	public friends_info(){};
	public void setdata(String id,String name,String sex,String age,String phone,String birthday,String mobile,String email,String QQ,String U_id,String mobile2,String company,String position,String remark){
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.phone=phone;
		this.birthday=birthday;
		this.mobile=mobile;
		this.email=email;
		this.QQ=QQ;
		this.U_id=U_id;
		this.mobile2=mobile2;
		this.company=company;
		this.position=position;
		this.remark=remark;
	}
	public String getid(){
		return id;
	}
	public String getname(){
		return name;
	}
	public String getsex(){
		return sex;
	}
	public String getage(){
		return age;
	}
	public String getphone(){
		return phone;
	}
	public String getbirthday(){
		return birthday;
	}
	public String getmobile(){
		return mobile;
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
	public String getmobile2(){
		return mobile2;
	}
	public String getcompany(){
		return company;
	}
	public String getposition(){
		return position;
	}
	public String getremark(){
		return remark;
	}
}
