public class Customer extends Person{
    private int id;
    private Account a;
    private Address addr;

    public Customer(String name,String dob,String gender,long phoneno,int id,Account a,Address addr){
        super(name,dob,gender,phoneno);
        this.id=id;
        this.a=a;
        this.addr=addr;
    }

    public void updateBalance(double val){
        double presentBalance=a.getBalance();
        presentBalance+=val;
        a.setBalance(presentBalance);
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
        System.out.println("Account Id : "+a.getId());
        System.out.println("Available Balance : "+a.getBalance());
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------Showing Address Details----------------");
        System.out.println("State : "+addr.getState());
        System.out.println("City : "+addr.getCity());
        System.out.println("Pincode : "+addr.getPincode());
        System.out.println("----------------------------------------------------------------");
    }

}