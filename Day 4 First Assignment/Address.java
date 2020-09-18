public class Address{
    private String state;
    private String city;
    private long pincode;

    public Address(String state,String city,long pincode){
        this.state=state;
        this.city=city;
        this.pincode=pincode;
    }

    public String getState(){
        return this.state;
    }

    public String getCity(){
        return this.city;
    }

    public long getPincode(){
        return this.pincode;
    }

}