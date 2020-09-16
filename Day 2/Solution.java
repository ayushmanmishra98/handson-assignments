class Solution{
    public static void main(String args[]){
        
        SavingsAccount[] s=new SavingsAccount[5];
        
        s[0]=new SavingsAccount(1234567L,"Ramesh",50000.0,"Odisha","Bhubaneswar",751020L);
        s[1]=new SavingsAccount(7654321L,"Suresh","Odisha","Cuttack",751003L);
        s[2]=new SavingsAccount(456789L,"Harish",100000.0,"Maharastra","Andheri",551001L);
        s[3]=new SavingsAccount(987654L,"Anusmita",90000.0,"Bangalore","WhiteField",56003L);
        s[4]=new SavingsAccount(2458144L,"Shreyasi","Odisha","Puri",750000L);
        
        System.out.println("Welcome to HSBC Bank");
        System.out.println("------------------------------");
        
        s[1].deposit(40000.0);
        s[4].deposit(80000.0);
        s[1].withdraw(50000.0);
        s[0].withdraw(50000.0);
        s[0].deposit(80000.0);
        s[3].withdraw(50000.0);
        s[2].deposit(80000.0);
        s[4].withdraw(50000.0);

        for(int i=0;i<5;i++){
            System.out.println("Showing New Customer Details");
            s[i].display();
        }
    }
}