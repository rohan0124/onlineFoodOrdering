package service;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static UserService instance =null;

    public static UserService getInstance(){
        if(instance==null){
            instance=new UserService();
        }
        return instance;
    }
    List<User> userList;
    User currentUser;
    private UserService() {
        this.userList= new ArrayList<>();
        this.currentUser=null;
    }

    public Integer getCurrentUserId() {
        return currentUser.getId();
    }

    User registerUser(String name, String gender, String phoneNumber, String pincode){
        User user= new User(name,gender,phoneNumber,pincode);
        userList.add(user);
        System.out.println("User registered successfully - "+user.getName());
        return user;
    }
    User login(String phoneNumber){
        for(User user:userList){
            if(user.getPhoneNumber().equals(phoneNumber)){
                this.currentUser = user;
                System.out.println("User logged in successfully "+user.getName());
                return currentUser;
            }
        }
        System.out.println("User not found");
        return null;
    }
}
