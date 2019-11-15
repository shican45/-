package xiernaichalei;

import java.util.Calendar;

public class MilkTea {
	public String name;
	public Ingredient ingredient;
	MilkTea(int i){
		name="奶茶"+i;
	}
	public String toString() {//输出生产日期
        return "奶茶名字："+name;
    }
}
