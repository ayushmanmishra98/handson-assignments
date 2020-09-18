public class Account{
    private long id;
    private double balance;

    public Account(long id,double balance){
        this.id=id;
        this.balance=balance;
    }

    public long getId(){
        return this.id;
    }


    public void setBalance(double balance){
        this.balance=balance;
    }

    public double getBalance(){
        return this.balance;
    }

}