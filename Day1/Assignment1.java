//Sum min and max value
class Assignment1{
	public static void main(String args[]){
	int[] a=new int[args.length];
	int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,sum=0; 
	for(int i=0;i<args.length;i++){
	a[i]=Integer.parseInt(args[i]);
}
for(int i=0;i<a.length;i++){
	if(a[i]>max){
	max=a[i];
}
}
for(int i=0;i<a.length;i++){
	if(a[i]<min){
	min=a[i];
}
}
for(int i=0;i<a.length;i++){
	sum+=a[i];
}
System.out.println("Maximum Value is : "+max);
System.out.println("Minimum Value is : "+min);
System.out.println("Sum is : "+sum);
}
}