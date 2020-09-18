public class Customer extends Person{
    private int id;
    private Account acc;

    public Customer(String name,String dob,String gender,long phoneno,int id,Account acc,Address addr){
        super(name,dob,gender,phoneno,addr);
        this.id=id;
        this.acc=acc;
    }

    public void updateBalance(double val){
        double presentBalance=acc.getBalance();
        presentBalance+=val;
        acc.setBalance(presentBalance);
    }
    
    @Override
    public void showInformation(){
        System.out.println("---------------------Showing Customer Details----------------");
        System.out.println("Name : "+getName());
        System.out.println("DOB : "+getDOB());
        System.out.println("Gender : "+getGender());
        System.out.println("Phone Number : "+getPhoneno());
        System.out.println("Customer Number : "+this.id);
        System.out.println("----------------------Showing Account Details----------------");
        System.out.println("Account Id : "+acc.getId());
        System.out.println("Available Balance : "+acc.getBalance());
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------Showing Address Details----------------");
        addressDetails();
        System.out.println("----------------------------------------------------------------");
    }

}