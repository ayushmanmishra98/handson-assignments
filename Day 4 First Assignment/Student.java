public class Student extends Person{
    private int rollno;
    private String grade;
    private Address a;

    public Student(String name,String dob,String gender,long phoneno,int rollno,String grade,Address a){
        super(name,dob,gender,phoneno);
        this.rollno=rollno;
        this.grade=grade;
        this.a=a;
    }

    public void updateGrade(String grade){
        this.grade=grade;
    }

    public String getGrade(){
        return this.grade;
    }

    @Override
    public void showInformation(){
        System.out.println("---------------------Showing Student Details----------------");
        System.out.println("Name : "+getName());
        System.out.println("DOB : "+getDOB());
        System.out.println("Gender : "+getGender());
        System.out.println("Phone Number : "+getPhoneno());
        System.out.println("Roll Number : "+this.rollno);
        System.out.println("Grade : "+this.grade);
        System.out.println("----------------------Showing Address Details----------------");
        System.out.println("State : "+a.getState());
        System.out.println("City : "+a.getCity());
        System.out.println("Pincode : "+a.getPincode());
        System.out.println("----------------------------------------------------------------");
    }
    
}