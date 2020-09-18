public abstract class Employee extends Person{
    private int id;
    private double salary;
    private String position;
    
    public Employee(String name,String dob,String gender,long phoneno,int id,double salary,String position,Address addr){
        super(name,dob,gender,phoneno,addr);
        this.id=id;
        this.salary=salary;
        this.position=position;
    }
    
    public void setSalary(double sal){
        this.salary=sal;
    }

    public double getSalary(){
        return this.salary;
    }

    public int getId(){
        return this.id;
    }

    public double getPosition(){
        return this.salary;
    }

}