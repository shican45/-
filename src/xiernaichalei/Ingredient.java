package xiernaichalei;
import java.util.Calendar;
import java.util.Scanner;
public abstract class Ingredient {
	protected String name;
	protected Calendar calendar;
	protected int freshnessday;
	protected int count;//配料的剩余量
    Ingredient(){
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        count=10;
    }
    Ingredient(int t){
    	calendar = Calendar.getInstance();
    }
    public void setcalendar1() {//设置生产日期（已过期）
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        count=100;
    }
    public void setcalendar2() {//设置生产日期（未过期）
        calendar = Calendar.getInstance();
    }
    public String toString() {//输出生产日期
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return "\n名字:"+name+"\n生产日期：" + year + "年" + month 
        		+ "月" + day + "日"+"/n保质期："+freshnessday+"天"+"\n";
    }
    public void setcount(int i){//设置配料的剩余量
    	count=i;
    }
    public int getcount(){//设置配料的初始量
    	return count;
    }
}
