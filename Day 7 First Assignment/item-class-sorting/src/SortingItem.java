import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortingItem {
	public static void main(String[] args) {
		List<Item> list=new ArrayList<Item>();
		list.add(new Item(1,"Copy",100,4));
		list.add(new Item(2,"Book",200,5));
		list.add(new Item(3,"Pen",10,3));
		list.add(new Item(4,"Pencil",5,4));
		list.add(new Item(5,"Marker",20,4));
		System.out.println("--------Original List Of Items Before Sorting--------------------");
		Iterator<Item> iterator=list.iterator();
		for(Item item:list) {
			System.out.println(item);
		}
		Outer outer=new Outer();
		Collections.sort(list,outer.new Inner1());
		System.out.println("--------Sorting in Ascending Order By Item Id--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
		Collections.sort(list,outer.new Inner2());
		System.out.println("--------Sorting in Descending Order By Item Id--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
		Collections.sort(list,outer.new Inner3());
		System.out.println("--------Sorting in Ascending Order By Name--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
		Collections.sort(list,outer.new Inner4());
		System.out.println("--------Sorting in Descending Order By Name--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
		Collections.sort(list,outer.new Inner5());
		System.out.println("--------Sorting in Ascending Order By Price--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
		Collections.sort(list,outer.new Inner6());
		System.out.println("--------Sorting in Descending Order By Price--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
		Collections.sort(list,outer.new Inner7());
		System.out.println("--------Sorting in Ascending Order By Rating--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
		Collections.sort(list,outer.new Inner8());
		System.out.println("--------Sorting in Descending Order By Rating--------------------");
		for(Item item:list) {
			System.out.println(item);
		}
	}
}
