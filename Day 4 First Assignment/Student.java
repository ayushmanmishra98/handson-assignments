public class Student extends Person{
    private int rollno;
    private String grade;

    public Student(String name,String dob,String gender,long phoneno,int rollno,String grade,Address addr){
        super(name,dob,gender,phoneno,addr);
        this.rollno=rollno;
        this.grade=grade;
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
        addressDetails();
        System.out.println("----------------------------------------------------------------");
    }
    
}