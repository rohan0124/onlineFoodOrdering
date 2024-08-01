package entity;

public class User {

    private static int count=0;
    private Integer id;
    private String name;
    private String gender;

    public Integer getId() {
        return id;
    }

    private String phoneNumber;
    private String pincode;

    public User(String name, String gender, String phoneNumber, String pincode) {
        this.id =++count;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
    }


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPincode() {
        return pincode;
    }
}
