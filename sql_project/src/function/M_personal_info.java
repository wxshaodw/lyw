package function;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M_personal_info {
	private String User_id;
	public M_personal_info(String User_id){
		this.User_id=User_id;
	}
	public boolean insert_personal_info( personal_info in ) throws ClassNotFoundException, SQLException{
		jdbc j_insert=new jdbc();
		String sql="exec insert_personalinfo"+"'"+in.getname()+"',"+"'"+in.getsex()+"',"+"'"+in.getage()+"',"+"'"+in.getbirthday()+"',"+"'"+in.getmobile()+"',"+"'"+in.getemail()+"',"+"'"+in.getQQ()+"',"+"'"+this.User_id+"'";
		j_insert.get_state().execute(sql);
		j_insert.close();
		return true;
	}
	public boolean updata_personal_info (String id,personal_info updata) throws ClassNotFoundException, SQLException{
		jdbc j_updata=new jdbc();
		String sql="exec updata_personalinfo"+"'"+id+"',"+"'"+updata.getname()+"',"+"'"+updata.getsex()+"',"+"'"+updata.getage()+"',"+"'"+updata.getbirthday()+"',"+"'"+updata.getmobile()+"',"+"'"+updata.getemail()+"',"+"'"+updata.getQQ()+"',"+"'"+this.User_id+"',"+"'"+updata.getcompany()+"',"+"'"+updata.getposition()+"'";
		j_updata.get_state().execute(sql);
		j_updata.close();
		return true;
	}
	public personal_info[] return_personal_info() throws ClassNotFoundException, SQLException{
		int i=1;
		jdbc j_return=new jdbc();
		ResultSet r_return=j_return.get_state().executeQuery("select * from personalinfo where p_id ='"+this.User_id+"'");
		j_return.close();
		personal_info[] info =new personal_info[r_return.getRow()];
		while(r_return.next()){
			info[i].setdata(r_return.getString(1),r_return.getString(2),r_return.getString(3),r_return.getString(4),r_return.getString(5),r_return.getString(6),r_return.getString(7),r_return.getString(8),r_return.getString(9),r_return.getString(10),r_return.getString(11));
		}
		return info;
	}


}
