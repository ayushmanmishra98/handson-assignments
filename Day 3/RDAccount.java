public class RDAccount extends Account {

    //Constructor for RDAccount    
    public RDAccount(long accountNumber, double balance) {
        super(accountNumber, balance);  
    }

    public void interestRate() {
        System.out.println("4% interest in a year");
    }

    @Override
    public void accountInformation(){
        System.out.println("-------RD Account Details---------------");
        System.out.println("Account Number: "+getAccountNumber());
        System.out.println("Balance: "+getBalance());
        System.out.println("---------------------------------------------");
    } 
}    