import java.util.Comparator;

public class Outer {
	public class Inner1 implements Comparator<Item>{

		@Override
		public int compare(Item o1, Item o2) {
			return (o1.getItemId() - o2.getItemId());
		}
		
	}
	
	public class Inner2 implements Comparator<Item>{
		@Override
		public int compare(Item o1, Item o2) {
			return (o2.getItemId() - o1.getItemId());
		}
	}
	
	public class Inner3 implements Comparator<Item>{
		@Override
		public int compare(Item o1, Item o2) {
			return (o1.getName().compareTo(o2.getName()));
		}
	}
	
	public class Inner4 implements Comparator<Item>{
		@Override
		public int compare(Item o1, Item o2) {
			return (o2.getName().compareTo(o1.getName()));
		}
	}
	public class Inner5 implements Comparator<Item>{
		@Override
		public int compare(Item o1, Item o2) {
			if(o1.getPrice()<o2.getPrice())
				return -1;
			if(o1.getPrice()>o2.getPrice())
				return 1;
			return 0;
		}
	}
	
	public class Inner6 implements Comparator<Item>{
		@Override
		public int compare(Item o1, Item o2) {
			if(o2.getPrice()<o1.getPrice())
				return -1;
			if(o2.getPrice()>o1.getPrice())
				return 1;
			return 0;
		}
	}
	public class Inner7 implements Comparator<Item>{
		@Override
		public int compare(Item o1, Item o2) {
			if(o1.getRatings()<o2.getRatings())
				return -1;
			if(o1.getRatings()>o2.getRatings())
				return 1;
			return 0;
		}
	}
	
	public class Inner8 implements Comparator<Item>{
		@Override
		public int compare(Item o1, Item o2) {
			if(o2.getRatings()<o1.getRatings())
				return -1;
			if(o2.getRatings()>o1.getRatings())
				return 1;
			return 0;
		}
	}
	
}
