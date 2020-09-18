public class Manager extends Person{
    private int id;
    private double salary;
    private String position;
    private Address a;

    public Manager(String name,String dob,String gender,long phoneno,int id,double salary,String position,Address a){
        super(name,dob,gender,phoneno);
        this.id=id;
        this.salary=salary;
        this.position=position;
        this.a=a;
    }

    public void setSalaryManager(double sal){
        this.salary=sal;
    }

    public double getSalary(){
        return this.salary;
    }

    @Override
    public void showInformation(){
        System.out.println("---------------------Showing Manager Details----------------");
        System.out.println("Name : "+getName());
        System.out.println("DOB : "+getDOB());
        System.out.println("Gender : "+getGender());
        System.out.println("Phone Number : "+getPhoneno());
        System.out.println("Id : "+this.id);
        System.out.println("Salary : "+this.salary);
        System.out.println("Position : "+this.position);
        System.out.println("----------------------Showing Address Details----------------");
        System.out.println("State : "+a.getState());
        System.out.println("City : "+a.getCity());
        System.out.println("Pincode : "+a.getPincode());
        System.out.println("----------------------------------------------------------------");
    }

}