package com.company;

/**
 * Created by arun on 5/20/16.
 */
public class Users {

    private String userName;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String sex;

    /*
    Here there is a possibility of too many constructors. So we use Builder Pattern

    public Users(String userName, String emailAddress) {
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

    public Users(String firstName, String lastName, String phoneNumber, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public Users(String userName, String emailAddress, String firstName, String lastName, String phoneNumber, String sex) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public Users(){
        //and use getters and setters
    }
    */

    private Users(Builder builder){
        this.userName = builder.userName;
        this.emailAddress = builder.emailAddress;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.sex = builder.sex;
    }

    @Override
    public String toString() {
        return "User Name: "+ this.userName
                +", Name: "+this.firstName+" "+this.lastName
                +", Phone Number: "+ this.phoneNumber
                +", email: "+this.emailAddress+", Sex: "+this.sex;
    }

    public static class Builder{
        private String userName;
        private String emailAddress;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String sex;

        public Builder(String userName, String emailAddress){
            this.userName = userName;
            this.emailAddress = emailAddress;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder sex(String sex){
            this.sex = sex;
            return this;
        }
        public Users build(){
            return new Users(this);
        }

    }
}
