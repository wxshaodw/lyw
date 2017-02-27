package function;

import java.sql.ResultSet;
import java.sql.SQLException;


public class M_friends_info {
	private String User_id;
	public M_friends_info(String User_id){
		this.User_id=User_id;
	}
	public void insert_friends_info( friends_info in ) throws ClassNotFoundException, SQLException{
		jdbc j_insert=new jdbc();
		String sql="exec insert_f_i"+"'"+in.getname()+"',"+"'"+in.getsex()+"',"+"'"+in.getage()+"',"+"'"+in.getphone()+"',"+"'"+in.getbirthday()+"',"+"'"+in.getmobile()+"',"+"'"+in.getemail()+"',"+"'"+in.getQQ()+"',"+"'"+this.User_id+"',"+"'"+in.getmobile2()+"',"+"'"+in.getcompany()+"',"+"'"+in.getposition()+"',"+"'"+in.getremark()+"'";
		j_insert.get_state().execute(sql);
		j_insert.close();
	}
	public friends_info[] cheak_friends_info(String type,String key) throws ClassNotFoundException, SQLException{
		jdbc j_cheak=new jdbc();
		int i=0,j=0;
		String sql="select * from [Friend's info] where "+type+" like '%"+key+"%'"+"and u_id='"+User_id+"'";
		j_cheak.get_state().execute(sql);
		ResultSet r_row=j_cheak.get_state().getResultSet();
		while(r_row.next())j=j+1;
		j_cheak.get_state().execute(sql);
		ResultSet r_cheak=j_cheak.get_state().getResultSet();
		friends_info[] info =new friends_info[j];
		while(r_cheak.next()){
			info[i]=new friends_info();
			info[i].setdata(r_cheak.getString(1),r_cheak.getString(2),r_cheak.getString(3),r_cheak.getString(4),r_cheak.getString(5),r_cheak.getString(6),r_cheak.getString(7),r_cheak.getString(8),r_cheak.getString(9),r_cheak.getString(10),r_cheak.getString(11),r_cheak.getString(12),r_cheak.getString(13),r_cheak.getString(14));
			i++;
		}
		return info;
	}
	public void  updata (String id,friends_info updata) throws ClassNotFoundException, SQLException{
		jdbc j_updata=new jdbc();
		String sql="exec updata_f_i"+"'"+updata.getid()+"',"+"'"+updata.getname()+"',"+"'"+updata.getsex()+"',"+"'"+updata.getage()+"',"+"'"+updata.getphone()+"',"+"'"+updata.getbirthday()+"',"+"'"+updata.getmobile()+"',"+"'"+updata.getemail()+"'"+",'"+updata.getQQ()+"'"+",'"+updata.getmobile2()+"'"+",'"+updata.getcompany()+"',"+"'"+updata.getposition()+"',"+"'"+updata.getremark()+"'";
		j_updata.get_state().execute(sql);
		j_updata.close();
	}
	public friends_info[] return_f_i() throws ClassNotFoundException, SQLException{
		int i=0,j=0;
		jdbc j_return=new jdbc();
		ResultSet r_row=j_return.get_state().executeQuery("select * from [Friend's info] where u_id ='"+this.User_id+"'");
		while(r_row.next())j=j+1;
		friends_info[] info =new friends_info[j];
		ResultSet r_return=j_return.get_state().executeQuery("select * from [Friend's info] where u_id ='"+this.User_id+"'");
		while(r_return.next()){
			info[i]=new friends_info();
			info[i].setdata(r_return.getString(1),r_return.getString(2),r_return.getString(3),r_return.getString(4),r_return.getString(5),r_return.getString(6),r_return.getString(7),r_return.getString(8),r_return.getString(9),r_return.getString(10),r_return.getString(11),r_return.getString(12),r_return.getString(13),r_return.getString(14));
			i++;
		}
		j_return.close();
		return info;
	}
	public void  delete_f_i(String id) throws ClassNotFoundException, SQLException{
		jdbc j_delete=new jdbc();
		j_delete.get_state().executeUpdate("delete from [Friend's info] where FI_id='"+id+"'" );
		j_delete.close();
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
	}*/

}
