//Final amount after adding tax.First enter state then amount in the command line argument.
class Assignment2{
	public static void main(String args[]){
	String state=args[0];
	int amount=Integer.parseInt(args[1]);
	int tax=0;
	switch(state){
		case "Karnataka":
			tax=amount*8;
			tax/=100;
			amount+=tax;
			System.out.println("The final amount after tax is : "+amount);
			break;	
		case "Odisha":
			tax=amount*9;
			tax/=100;
			amount+=tax;
			System.out.println("The final amount after tax is : "+amount);
			break;
		case "Telengana":
			tax=amount*10;
			tax/=100;
			amount+=tax;
			System.out.println("The final amount after tax is : "+amount);
			break;
		case "Maharastra":
			tax=amount*11;
			tax/=100;
			amount+=tax;
			System.out.println("The final amount after tax is : "+amount);
			break;
		case "WestBengal":
			tax=amount*12;
			tax/=100;
			amount+=tax;
			System.out.println("The final amount after tax is : "+amount);
			break;
		case "Delhi":
			tax=amount*14;
			tax/=100;
			amount+=tax;
			System.out.println("The final amount after tax is : "+amount);
			break;
		default:
			System.out.println("No match for State");

}
}
}