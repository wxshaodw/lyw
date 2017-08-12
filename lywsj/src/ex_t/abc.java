package ex_t;

import java.text.SimpleDateFormat;
import java.util.Date;

public class abc {

	public static <singleDatefomat> void main(String[] args) {
		Date now=new Date();
		SimpleDateFormat a=new SimpleDateFormat("dd");
		Integer.parseInt(a.format(now));
		System.out.println(Integer.parseInt(a.format(now))%2);
		// TODO Auto-generated method stub

	}

}
