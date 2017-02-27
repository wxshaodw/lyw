package function;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class M_diary {
	private String User_id;
	public M_diary(String User_id){
		this.User_id=User_id;
	}
	public String insert_diary(diary in ,String path) throws ClassNotFoundException, SQLException, IOException{
		jdbc j_insert=new jdbc();
		String sql="exec insert_diary'"+in.getdate()+"',"+"'"+path+"',"+"'"+this.User_id+"'"+",'"+in.gettitle()+"'";
		ResultSet a=j_insert.get_state().executeQuery("select max(d_id) from diary");
		a.next();
		String name=a.getString(1);
		j_insert.get_state().execute(sql);
		j_insert.close();
		return name;
	}
	public diary[] cheak_diary(String type,String key) throws ClassNotFoundException, SQLException, IOException{
		jdbc j_cheak=new jdbc();
		int i=0,j=0;
		String sql="select * from diary where "+type+" like '%"+key+"%'"+"and u_id='"+User_id+"'";
		ResultSet r_row=j_cheak.get_state().executeQuery(sql);
		while(r_row.next())j=j+1;
		ResultSet r_return=j_cheak.get_state().executeQuery(sql);
		diary[] info =new diary[j];
		while(r_return.next()){
			info[i]=new diary();
			info[i].setdata(r_return.getString(1),r_return.getString(2),file.out_file(r_return.getString(3)), r_return.getString(4), r_return.getString(5),r_return.getString(3));
			i++;
		}
		j_cheak.close();
		return info;
	}
	public void updata_diary (diary updata) throws ClassNotFoundException, SQLException{
		jdbc j_updata=new jdbc();
		String sql="exec updata_diary"+"'"+updata.getid()+"',"+"'"+updata.getdate()+"',"+"'"+updata.getu_id()+"','"+updata.gettitle()+"'";
		j_updata.get_state().execute(sql);
		j_updata.close();
	}
	public diary[] return_diary() throws ClassNotFoundException, SQLException, IOException{
		int i=0,j=0;
		jdbc j_return=new jdbc();
		String sql="select * from diary where U_id ='"+this.User_id+"'";
		ResultSet r_row=j_return.get_state().executeQuery(sql);
		while(r_row.next())j=j+1;
		ResultSet r_return=j_return.get_state().executeQuery(sql);
		diary[] info =new diary[j];
		while(r_return.next()){
			info[i]=new diary();
			info[i].setdata(r_return.getString(1),r_return.getString(2),file.out_file(r_return.getString(3)), r_return.getString(4), r_return.getString(5),r_return.getString(3));
			i++;
		}
		j_return.close();
		return info;
	}
	public void delete_diary(String id) throws ClassNotFoundException, SQLException{
		jdbc j_delete=new jdbc();
		j_delete.get_state().executeUpdate("delete from diary where d_id='"+id+"'" );
		j_delete.close();
	}
}
