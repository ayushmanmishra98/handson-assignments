public class PersonDemo{
    public static void main(String args[]){
        Manager manager1=new Manager("Ravish","20 January 1995","Male",4444455552L,1221,80000,"Level 5",new Address("Odisha","Bhubaneswar",751003L));
        
        Admin admin1=new Admin("Harish","10 October 1997","Male",2484255552L,1225,50000,"Level 7",new Address("Odisha","Cuttack",751020L));
        
        Programmer programmer1=new Programmer("Anusmita","11 December 1998","Female",1234567890L,"Java",1235,40000,"Level 8",new Address("Odisha","Puri",751004L));
        
        Student student1=new Student("Harish","05 February 2002","Male",9287654321L,10,"Fourth",new Address("Odisha","Bhadrak",751040L));
        
        Customer customer1=new Customer("Shreyasi","08 August 1998","Female",1248521282L,15,new Account(5555L,80000),new Address("Maharatra","Pune",56003L));
        
        System.out.println("Showing Manager Details");
        display(manager1);
        
        System.out.println("Showing Admin Details");
        display(admin1);
        
        System.out.println("Showing Programmer Details");
        display(programmer1);
        
        System.out.println("Showing Student Details");
        display(student1);
        
        System.out.println("Showing Customer Details");
        display(customer1);
        
        System.out.println("Updating Manager Salary");
        testUpdate(manager1);
        
        System.out.println("Updating Admin Salary");
        testUpdate(admin1);
        
        System.out.println("Updating Programmer Salary");
        testUpdate(programmer1);
        
        System.out.println("Updating Student Grade");
        testUpdate(student1);
        
        System.out.println("Updating Customer Balance");
        testUpdate(customer1);
        
        System.out.println("Showing Manager Details after update");
        display(manager1); 
        
        System.out.println("Showing Admin Details after update");
        display(admin1);
        
        System.out.println("Showing Programmer Details after update");
        display(programmer1);
        
        System.out.println("Showing Student Details after update");
        display(student1);
        
        System.out.println("Showing Customer Details after update");
        display(customer1);
    }

    public static void display(Person people){
        people.showInformation();
    }

    public static void testUpdate(Person people){
        //Updating Salary Of Manager
        if(people instanceof Manager){
            double extra=0;
            Manager man=(Manager)people;
            double presentSalary=man.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            man.setSalary(presentSalary);
        }

        //Updating Salary Of Admin    
        if(people instanceof Admin){
            double extra=0;
            Admin man=(Admin)people;
            double presentSalary=man.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            man.setSalary(presentSalary);
        }


        //Updating Salary Of Programmer
        if(people instanceof Programmer){
            double extra=0;
            Programmer man=(Programmer)people;
            double presentSalary=man.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            man.setSalary(presentSalary);
        }


        //Updating Student Grade
        if(people instanceof Student){
            Student man=(Student)people;
            man.updateGrade("Fifth");
        }


        //Updating Customer Balance
        if(people instanceof Customer){
            Customer man=(Customer)people;
            man.updateBalance(20000);
        }

    }

}