public abstract class Person{
    private String name;
    private String dob;
    private String gender;
    private long phoneno;

    public Person(String name,String dob,String gender,long phoneno){
        this.name=name;
        this.dob=dob;
        this.gender=gender;
        this.phoneno=phoneno;
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

    public abstract void showInformation();

}