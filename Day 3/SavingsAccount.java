public class SavingsAccount extends Account { 
    String ifscCode;

    //Constructor to initialize SavingsAccount
    public SavingsAccount(long accountNumber, double balance, String ifscCode) {
        super(accountNumber, balance);
        this.ifscCode = ifscCode;
    }

    //Minimum balance for a SavingsAccount
    public void minimumBalance() {
        System.out.println("You must have minimum 5000Rs. balance");
    }

    @Override
    public void accountInformation(){
        System.out.println("-------Savings Account Details---------------");
        System.out.println("Account Number: "+getAccountNumber());
        System.out.println("Balance: "+getBalance());
        System.out.println("---------------------------------------------");
    } 

}    