public class Programmer extends Employee{
    private String role;

    public Programmer(String name,String dob,String gender,long phoneno,String role,int id,double salary,String position,Address addr){
        super(name,dob,gender,phoneno,id,salary,position,addr);
        this.role=role;
    }


    @Override
    public void showInformation(){
        System.out.println("---------------------Showing Programmer Details----------------");
        System.out.println("Name : "+getName());
        System.out.println("DOB : "+getDOB());
        System.out.println("Gender : "+getGender());
        System.out.println("Phone Number : "+getPhoneno());
        System.out.println("Role : "+this.role);
        System.out.println("Id : "+getId());
        System.out.println("Salary : "+getSalary());
        System.out.println("Position : "+getPosition());
        System.out.println("----------------------Showing Address Details----------------");
        addressDetails();
        System.out.println("----------------------------------------------------------------");
    }
    
}