public class Admin extends Employee{

    public Admin(String name,String dob,String gender,long phoneno,int id,double salary,String position,Address addr){
        super(name,dob,gender,phoneno,id,salary,position,addr);
    }


    @Override
    public void showInformation(){
        System.out.println("---------------------Showing Admin Details----------------");
        System.out.println("Name : "+getName());
        System.out.println("DOB : "+getDOB());
        System.out.println("Gender : "+getGender());
        System.out.println("Phone Number : "+getPhoneno());
        System.out.println("Id : "+getId());
        System.out.println("Salary : "+getSalary());
        System.out.println("Position : "+getPosition());
        System.out.println("----------------------Showing Address Details----------------");
        addressDetails();
        System.out.println("----------------------------------------------------------------");
    }

}