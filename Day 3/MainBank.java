public class MainBank{
    public static void main(String[] args) {
        long queryAccountNumber=Long.parseLong(args[0]);
        double queryAmount=Double.parseDouble(args[1]);
        long toAccountNumber=Long.parseLong(args[2]);
        //First Requirement
        /*Account a=getAccount(queryAccountNumber);
        if(a==null)
        {
            System.out.println("Error.No account related with this Account Number");
        }
        else
        {
            a.accountInformation();
            a.deposit(queryAmount);
            //a.withdraw(51000);
            a.accountInformation();
        }*/
        //Second Requirement
        Account a=getAccount(queryAccountNumber);
        if(a!=null){
            Account b=getAccount(toAccountNumber);
                if(b!=null){
                    System.out.println("Source Account Present Balance");
                    a.accountInformation();
                    System.out.println("Destination Account Present Balance");
                    b.accountInformation();
                    int r=a.transferMoney(queryAmount);
                    if(r==1){
                        b.deposit(queryAmount);
                        System.out.println("Deposit Account Present Balance after Deposit");
                        b.accountInformation();
                        System.out.println("Source Account Present Balance after Transferring");
                        a.accountInformation();
                    }
                    else{
                        System.out.println("Insufficient Funds available to transfer");
                    }
                }
                else{
                    System.out.println("Error.No account related to the account you want to transfer");
                }
            }
        else{
            System.out.println("Error.No account related with this Account Number");
        }

    }

    public static Account getAccount(long accountNo) {
        Account[] accounts = AccountsDB.getAccounts();

        Account account = null;

        for(Account a:accounts){
            if(accountNo==a.getAccountNumber()){
                account=a;
            }
        }

        // get the account from accounts using the accountNo

        return account;
    }

}