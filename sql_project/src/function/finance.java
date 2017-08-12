package function;

public class finance {
	private String id="";
	private String date="";
	private double payment;
	private String u_id="";
	private String source="";
	private String remark="";
	public void setdata(String id,String date,String payment,String u_id,String source,String remark){
		this.id=id;
		this.date=date;
		this.payment=Double.parseDouble(payment);
		this.u_id=u_id;
		this.source=source;
		this.remark=remark;
	}
	public String getid(){
		return id;
	}
	public String getdate(){
		return date;
	}
	public String getpayment(){
		return Double.toString(payment);
	}
	public String getu_id(){
		return u_id;
	}
	public String getsource(){
		return source;
	}
	public String getremark(){
		return remark;
	}
}
