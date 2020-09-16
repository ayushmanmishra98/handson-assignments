class SavingsAccount{
    long accountNo;
    String name;
    double balance;
    String ifsc;
    String state;
    String city;
    long pin;
    SavingsAccount(long accountNo,String name,String state,String city,long pin){
        this.accountNo=accountNo;
        this.name=name;
        this.ifsc="HSBC001";
        this.state=state;
        this.city=city;
        this.pin=pin;
    }
    SavingsAccount(long accountNo,String name,double balance,String state,String city,long pin){
        this.accountNo=accountNo;
        this.name=name;
        this.balance=balance;
        this.ifsc="HSBC001";
        this.state=state;
        this.city=city;
        this.pin=pin;
    }    
    public void deposit(double val){
        balance+=val;
    }
    public void withdraw(double val1){
        if(balance>=val1)
            balance-=val1;
        else
        {
			System.out.println("Sorry.Withdrawing not allowed for Account Holder : "+name);
            System.out.println("Insufficient funds in the Account.");   
            System.out.println("-----------------------------------------------------");
        }     
    }
    public void display(){
        System.out.println("Account Holder Number : "+accountNo);
        System.out.println("Account Holder Name : "+name);
        System.out.println("Account Holder IFSC Code : "+ifsc);
        System.out.println("Account Holder Balance : "+balance);
        System.out.println("Account Holder State : "+state);
        System.out.println("Account Holder City : "+city);
        System.out.println("Account Holder Pin : "+pin);
        System.out.println("------------------------------");
    }
}