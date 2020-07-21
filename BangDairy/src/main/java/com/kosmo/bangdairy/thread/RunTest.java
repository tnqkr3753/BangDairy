package com.kosmo.bangdairy.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		String strDate = "20100101";
		try {
			cal.setTime(sdf.parse(strDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for (int i = 0; i < 5; i++) {
			cal.add(Calendar.MONTH, 1);
			ApiConnection ac = new ApiConnection(sdf.format(cal.getTime()));
			Thread getM = new Thread(ac,"getM");
			getM.start();
//		}
	}

}
