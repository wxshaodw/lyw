package function;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M_finance {
	private String User_id;
	public M_finance(String User_id){
		this.User_id=User_id;
	}
	public boolean insert_finance( finance in ) throws ClassNotFoundException, SQLException{
		jdbc j_insert=new jdbc();
		String sql="exec insert_finance"+"'"+in.getdate()+"',"+"'"+in.getpayment()+"',"+"'"+this.User_id+"',"+"'"+in.getsource()+"',"+"'"+in.getremark()+"'";
		j_insert.get_state().execute(sql);
		j_insert.close();
		return true;
	}
	public finance[] cheak_finance(String type,String key) throws ClassNotFoundException, SQLException{
		jdbc j_cheak=new jdbc();
		int i=0,j=0;
		if(type.equals("F_payment"))Float.parseFloat(key);
		String sql="select * from finance where "+type+" like '%"+key+"%'"+"and u_id='"+User_id+"'";
		ResultSet r_row=j_cheak.get_state().executeQuery(sql);
		while(r_row.next())j=j+1;
		ResultSet r_cheak=j_cheak.get_state().executeQuery(sql);
		finance[] info =new finance[j];
		while(r_cheak.next()){
			info[i]=new finance();
			info[i].setdata(r_cheak.getString(1),r_cheak.getString(2),r_cheak.getString(3),r_cheak.getString(4),r_cheak.getString(5),r_cheak.getString(6));
			i++;
		}
		return info;
	}
	public boolean updata (finance updata) throws ClassNotFoundException, SQLException{
		jdbc j_updata=new jdbc();
		String sql="exec updata_finance"+"'"+updata.getid()+"',"+"'"+updata.getdate()+"',"+"'"+updata.getpayment()+"',"+"'"+updata.getu_id()+"',"+"'"+updata.getsource()+"'";
		j_updata.get_state().execute(sql);
		j_updata.close();
		return true;
	}
	public finance[] return_finance() throws ClassNotFoundException, SQLException{
		int i=0,j=0;
		jdbc j_return=new jdbc();
		String sql="select * from finance where u_id ='"+this.User_id+"'";
		ResultSet r_row=j_return.get_state().executeQuery(sql);
		while(r_row.next())j=j+1;
		ResultSet r_return=j_return.get_state().executeQuery(sql);
		finance[] info =new finance[j];
		while(r_return.next()){
			info[i]=new finance();
			info[i].setdata(r_return.getString(1),r_return.getString(2),r_return.getString(3),r_return.getString(4),r_return.getString(5),r_return.getString(6));
			i++;
		}
		j_return.close();
		return info;
	}
	public boolean delete__finance(String id) throws ClassNotFoundException, SQLException{
		jdbc j_delete=new jdbc();
		j_delete.get_state().executeUpdate("delete from finance where F_id='"+id+"'" );
		j_delete.close();
		return true;
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
