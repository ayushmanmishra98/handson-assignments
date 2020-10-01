package com.org.model.beans;

public class Profile {
private int profileId;
private String name;
private String password;
private long phoneNo;
private String DOB;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getProfileId() {
	return profileId;
}
public void setProfileId(int profileId) {
	this.profileId = profileId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
@Override
public String toString() {
	return "Profile [profileId=" + profileId + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo
			+ ", DOB=" + DOB + "]";
}

}
