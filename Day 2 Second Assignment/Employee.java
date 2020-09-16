class Employee{
    int id;
    String name;
    double salary;
    Address addr;
    Employee(int id,String name,double salary,Address addr){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.addr=addr;
    }
    void display(){
        System.out.println("Id : "+id+" Name : "+name+" Salary : "+salary);
    }
    void displayAddress(){
        System.out.println("Id : "+id+" Name : "+name+" Salary : "+salary+" State : "+addr.state+", City : "+addr.city+", Pin Code : "+addr.pincode+".");
    }
}