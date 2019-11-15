package xiernaichalei;

import java.util.Calendar;

public class Coconut extends Ingredient{
	Coconut(int i) {
		freshnessday=5;
		name="Coconut"+i;
		calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
	}
	Coconut(int i,int t) {
		freshnessday=5;
		name="Coconut"+i;
		calendar = Calendar.getInstance();
	}
	public String toString() {//输出生产日期
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return "\n配料名字："+name+"\n生产日期：" + year + "年" + month 
        		+ "月" + day + "日"+"\n"+"保质期："+freshnessday+"天"+"\n\n";
    }
}
