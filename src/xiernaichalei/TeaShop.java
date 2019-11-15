package xiernaichalei;
import java.util.ArrayList;
public class TeaShop implements Shop{
	
	public ArrayList<Bubble> list1=new ArrayList();
	public ArrayList<Coconut> list2=new ArrayList();
	public TeaShop() {
		for(int i=0;i<5;++i) {//过期配料
			Bubble bubble=new Bubble(i);
			Coconut coconut=new Coconut(i);
			list1.add(bubble);
			list2.add(coconut);
		}
		for(int i=5;i<10;++i) {//未过期配料
			Bubble bubble=new Bubble(i,1);
			Coconut coconut=new Coconut(i,1);
			list1.add(bubble);
			list2.add(coconut);
		}
	}
	private void addbubble(Bubble bubble) {
		list1.add(bubble);
	}
	private void addbubble(Coconut coconut) {
		list2.add(coconut);
	}
	public void addIngredient(Ingredient ingredient,int num) {
		boolean res1,res2;
		res1=ingredient instanceof Bubble;
		if(res1) {
			for(int i=num;i<num+100;++i)
			{
				Bubble bubble= new Bubble(i,1);
				addbubble(bubble);
			}
		}
		res2=ingredient instanceof Coconut;
		if(res2) {
			for(int i=num;i<num+100;++i)
			{
				Coconut coconut=new Coconut(i,1);
				addbubble(coconut);
			}
		}
	}
	public void sellMilkTea(String milkname,String ingredientname){
		if(ingredientname=="Bubble") {
			if(list1.size()!=0){
				list1.remove(list1.size()-1);
			}
		}
		if(ingredientname=="Coconut") {
			if(list2.size()!=0){
				list2.remove(list2.size()-1);
			}
		}
	}
}
