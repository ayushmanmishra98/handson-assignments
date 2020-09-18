public class PersonDemo{
    public static void main(String args[]){
        Manager m=new Manager("Ravish","20 January 1995","Male",4444455552L,1221,80000,"Level 5",new Address("Odisha","Bhubaneswar",751003L));
        
        Admin a=new Admin("Harish","10 October 1997","Male",2484255552L,1225,50000,"Level 7",new Address("Odisha","Cuttack",751020L));
        
        Programmer p=new Programmer("Anusmita","11 December 1998","Female",1234567890L,1235,40000,"Level 8",new Address("Odisha","Puri",751004L));
        
        Student s=new Student("Harish","05 February 2002","Male",9287654321L,10,"Fourth",new Address("Odisha","Bhadrak",751040L));
        
        Customer c=new Customer("Shreyasi","08 August 1998","Female",1248521282L,15,new Account(5555L,80000),new Address("Maharatra","Pune",56003L));
        
        System.out.println("Showing Manager Details");
        Display(m);
        
        System.out.println("Showing Admin Details");
        Display(a);
        
        System.out.println("Showing Programmer Details");
        Display(p);
        
        System.out.println("Showing Student Details");
        Display(s);
        
        System.out.println("Showing Customer Details");
        Display(c);
        
        System.out.println("Updating Manager Salary");
        testUpdate(m);
        
        System.out.println("Updating Admin Salary");
        testUpdate(a);
        
        System.out.println("Updating Programmer Salary");
        testUpdate(p);
        
        System.out.println("Updating Student Grade");
        testUpdate(s);
        
        System.out.println("Updating Customer Balance");
        testUpdate(c);
        
        System.out.println("Showing Manager Details after update");
        Display(m);
        
        System.out.println("Showing Admin Details after update");
        Display(a);
        
        System.out.println("Showing Programmer Details after update");
        Display(p);
        
        System.out.println("Showing Student Details after update");
        Display(s);
        
        System.out.println("Showing Customer Details after update");
        Display(c);
    }

    public static void Display(Person p){
        p.showInformation();
    }

    public static void testUpdate(Person p){
        //Updating Salary Of Manager
        if(p instanceof Manager){
            double extra=0;
            Manager man=(Manager)p;
            double presentSalary=man.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            man.setSalaryManager(presentSalary);
        }

        //Updating Salary Of Admin    
        if(p instanceof Admin){
            double extra=0;
            Admin man=(Admin)p;
            double presentSalary=man.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            man.setSalaryAdmin(presentSalary);
        }


        //Updating Salary Of Programmer
        if(p instanceof Programmer){
            double extra=0;
            Programmer man=(Programmer)p;
            double presentSalary=man.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            man.setSalaryProgrammer(presentSalary);
        }


        //Updating Student Grade
        if(p instanceof Student){
            Student man=(Student)p;
            man.updateGrade("Fifth");
        }


        //Updating Customer Balance
        if(p instanceof Customer){
            Customer man=(Customer)p;
            man.updateBalance(20000);
        }

    }

}