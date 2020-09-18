public abstract class Person{
    private String name;
    private String dob;
    private String gender;
    private long phoneno;
    private Address addr;

    public Person(String name,String dob,String gender,long phoneno,Address addr){
        this.name=name;
        this.dob=dob;
        this.gender=gender;
        this.phoneno=phoneno;
        this.addr=addr;
    }

    public String getName(){
        return this.name;
    }

    public String getDOB(){
        return this.dob;
    }

    public String getGender(){
        return this.gender;
    }

    public long getPhoneno(){
        return this.phoneno;
    }

    public void addressDetails(){
        System.out.println("State : "+addr.getState());
        System.out.println("City : "+addr.getCity());
        System.out.println("Pincode : "+addr.getPincode());
    }

    public abstract void showInformation();

}