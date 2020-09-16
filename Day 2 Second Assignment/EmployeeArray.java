class EmployeeArray{
    public static void main(String args[]){
        Employee[] e1=new Employee[5];
        Address[] a1=new Address[5];
        
        a1[0]=new Address("Odisha","Bhubaneswar",751020L);
        a1[1]=new Address("Maharastra","Andheri",244212L);
        //a1[2]=new Address("Bangalore","WhiteField",56003L);
        //a1[3]=new Address("Odisha","Puri",751003L);
        a1[4]=new Address("Maharastra","Pune",225484L);
        
        e1[0]=new Employee(1,"Harish",40000.0,a1[0]);
        e1[1]=new Employee(2,"Suresh",80000.0,a1[1]);
        e1[2]=new Employee(3,"Ramesh",50000.0,a1[2]);
        e1[3]=new Employee(4,"Anusmita",51000.0,a1[3]);
        e1[4]=new Employee(5,"Shreyasi",70000.0,a1[4]);
        
        System.out.println("Showing Salary of employees who earn more than 50000");
        System.out.println("---------------------------------------------------------------------------------");
        for(Employee e:e1){
            if(e.salary>50000)
                e.display();
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Showing Employee details who have provided address");
        System.out.println("----------------------------------------------------------------------------------");
        for(Employee e:e1){
            if(e.addr!=null){
                e.displayAddress();
                System.out.println("------------------------------------------------------------------------------");
            }
        }

    }
}