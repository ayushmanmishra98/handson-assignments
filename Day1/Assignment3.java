//Pass one mark and check in which category.
class Assignment3{
	public static void main(String args[]){
	int a=Integer.parseInt(args[0]);
	if(a>70){
	System.out.println("First Class Distinction");
	}
	else if(a>60 && a<=70){
	System.out.println("First Class");
	}
	else if(a>50 && a<=60){
	System.out.println("Second Class");
	}
	else if(a>35 && a<=50){
	System.out.println("Pass");
	}
	else{
	System.out.println("Fail");
	}
}
}