package xiernaichalei;
import java.util.*;
import java.util.Calendar;
public class demo {
	public static void main(String[] args) {
		TeaShop shop=new TeaShop();
		int k=1,count1=10,count2=10;//count1、count2分别为两种配料的初始量； k为奶茶命名所用
		String milkname="奶茶"+k;
		Bubble temp1=new Bubble(0,0);
		Coconut temp2=new Coconut(0,0);
		int i;
		//出售未过期的Bubble
		for(i=1;i<6;++i)
		{
			try {
				if(shop.list1.isEmpty())//出售Bubble时，若Bubble配料已售完则抛出异常
				{
					SoldOutException e=new SoldOutException();
					throw e;
				}
				Bubble temp0=shop.list1.get(shop.list1.size()-1);
				Date date1 = temp1.calendar.getTime();
				Date date2 = temp0.calendar.getTime();
				//int days=getsdays(temp1.calendar,temp.calendar);
				int days=daysBetween(date1,date2);
				if(Math.abs(days)<=7) {
					shop.sellMilkTea(milkname,"Bubble");
					System.out.print("出售成功！商品信息为：\n");
					MilkTea milktea=new MilkTea(k);
					k++;
					System.out.print(milktea.toString());
					System.out.print(temp0.toString());
				}
				else {
					System.out.println("该配料已过期，请重新购买！");
					System.out.println("该过期配料信息："+temp0.toString());
				}
			}
			catch(SoldOutException e){
				System.out.println("Bubble配料已售完！");
			}
		}
		//出售过期的Bubble，最后一个为该配料售完的告知
		for(i=6;i<12;++i)
		{
			try {
				if(shop.list1.isEmpty())
				{
					SoldOutException e=new SoldOutException();
					throw e;
				}
				Bubble temp=shop.list1.get(shop.list1.size()-1);
				Date date1 = temp1.calendar.getTime();
				Date date2 = temp.calendar.getTime();
				//int days=getsdays(temp1.calendar,temp.calendar);
				int days=daysBetween(date1,date2);
				if(Math.abs(days)<=7) {
					shop.sellMilkTea(milkname,"Bubble");
					System.out.print("出售成功！商品信息为：\n");
					MilkTea milktea=new MilkTea(k);
					k++;
					System.out.print(milktea.toString());
					System.out.print(temp.toString());
				}
				else {
					int cout=shop.list1.size();
					shop.list1.remove(cout-1);
					System.out.println("出售失败！该配料已过期，请重新购买！");
					System.out.println("该过期配料信息："+temp.toString());
				}
			}
			catch(SoldOutException e){
				System.out.println("Bubble配料已售完！");
			}
		}
		
		//出售未过期的Coconut
		int j;
		for(j=1;j<6;++i,++j)
		{
			try {
				if(shop.list2.isEmpty())//出售Coconut时，若Coconut配料已售完则抛出异常
				{
					SoldOutException e=new SoldOutException();
					throw e;
				}
				Coconut temp3=shop.list2.get(shop.list2.size()-1);
				Date date1 = temp2.calendar.getTime();
				Date date2 = temp3.calendar.getTime();
				//int days=getsdays(temp1.calendar,temp.calendar);
				int days=daysBetween(date1,date2);
				if(Math.abs(days)<=7) {
					shop.sellMilkTea(milkname,"Coconut");
					System.out.print("出售成功！商品信息为：\n");
					MilkTea milktea=new MilkTea(k);
					k++;
					System.out.print(milktea.toString());
					System.out.print(temp3.toString());
				}
				else {
					System.out.println("该配料已过期，请重新购买！");
					System.out.println("该过期配料信息："+temp3.toString());
				}
			}
			catch(SoldOutException e){
				System.out.println("Coconut配料已售完！");
			}
		}
		//出售过期的Coconut，最后一个为该配料售完的告知
		for(j=6;j<12;++i,++j)
		{
			try {
				if(shop.list2.isEmpty())
				{
					SoldOutException e=new SoldOutException();
					throw e;
				}
				Coconut temp3=shop.list2.get(shop.list2.size()-1);
				Date date1 = temp1.calendar.getTime();
				Date date2 = temp3.calendar.getTime();
				//int days=getsdays(temp1.calendar,temp.calendar);
				int days=daysBetween(date1,date2);
				if(Math.abs(days)<=7) {
					shop.sellMilkTea(milkname,"Coconut");
					System.out.print("出售成功！商品信息为：\n");
					MilkTea milktea=new MilkTea(k);
					k++;
					System.out.print(milktea.toString());
					System.out.print(temp3.toString());
				}
				else {
					int cout=shop.list2.size();
					shop.list2.remove(cout-1);
					System.out.println("出售失败！该配料已过期，请重新购买！");
					System.out.println("该过期配料信息："+temp3.toString());
				}
			}
			catch(SoldOutException e){
				System.out.println("Coconut配料已售完！");
			}
		}
		
		//进货后出售
		System.out.println("\n\n\n");
		Coconut temp4=new Coconut(count1,1);
		shop.addIngredient(temp4,count1);
		count1+=100;//一次进货100个该种配料；（使配料名和以前的都 不一样）
		System.out.print("成功进货100个Coconut配料！\n\n");
		Coconut temp5=shop.list2.get(0);
		shop.sellMilkTea(milkname,"Coconut");
		System.out.print("出售成功！商品信息为：\n");
		MilkTea milktea=new MilkTea(k);
		k++;
		System.out.print(milktea.toString());
		System.out.print(temp5.toString());
		
		System.out.println("\n\n\n");
		Bubble temp6=new Bubble(count2,1);
		shop.addIngredient(temp6,count2);
		count2+=100;//一次进货100个该种配料；（使配料名和以前的都 不一样）
		System.out.print("成功进货100个Bubble配料！\n\n");
		Bubble temp7=shop.list1.get(0);
		shop.sellMilkTea(milkname,"Bubble");
		System.out.print("出售成功！商品信息为：\n");
		MilkTea milktea1=new MilkTea(k);
		k++;
		System.out.print(milktea1.toString());
		System.out.print(temp7.toString());
	}
/*	public static int getsdays(Calendar a,Calendar b) {
		if(b.after(a)) {
			Calendar temp;
			temp=a;
			a=b;
			b=temp;
		}
		int days=a.get(Calendar.DAY_OF_YEAR)-b.get(Calendar.DAY_OF_YEAR);
		if(a.get(Calendar.YEAR)!=b.get(Calendar.YEAR)) {
			do {
				days+=a.getActualMaximum(Calendar.DAY_OF_YEAR);
				a.add(Calendar.YEAR, 1);
			}
			while(a.get(Calendar.YEAR)!=b.get(Calendar.YEAR));
		}
		return days;
	}*/
	public static int daysBetween(Date date1,Date date2)     //获得当前日期和生产日期的相差的天数
    {     
        Calendar cal = Calendar.getInstance();     
        cal.setTime(date1);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(date2);     
        long time2 = cal.getTimeInMillis();          
        long between_days=(time2-time1)/(1000*3600*24);     
             
       return Integer.parseInt(String.valueOf(between_days));            
    }    
}
