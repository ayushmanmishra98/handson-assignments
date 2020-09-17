public class Account{
    private long accountNumber;
    private double balance;

    //Account class constructor to initialize accountNumber,balance
    public Account(long accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    //Getter for accountNumber

    public long getAccountNumber(){
        return accountNumber;
    }


    //Setter method for balance
    public void setBalance(double balance){
        this.balance=balance;
    }

    //Getter for balance
    public double getBalance(){
        return balance;
    }

    //Method to deposit money
    public void deposit(double val){
        double presentBalance=getBalance();
        presentBalance+=val;
        setBalance(presentBalance);
    }

    //Method to withdraw money
    public void withdraw(double val){
        if(val>50000){
            System.out.println("Withdrawl not allowed above 50000");
            return;
        }
        double presentBalance=getBalance();
        if(presentBalance>=val){
            presentBalance-=val;
            setBalance(presentBalance);
            System.out.println("Withdraw Successful");
        }
        else{
            System.out.println("Insufficient Funds in the account");
        }
    }

    public int transferMoney(double val){
        double presentBalance=getBalance();
        if(presentBalance>=val){
            presentBalance-=val;
            setBalance(presentBalance);
            System.out.println("Initiating Transfer");
            return 1;
        }
        else{
            return 0;
        }
    }

    //Method to get all the account information

    public void accountInformation(){
        System.out.println("-------Bank Account Details---------------");
        System.out.println("Account Number: "+getAccountNumber());
        System.out.println("Balance: "+getBalance());
        System.out.println("---------------------------------------------");
    }    

}