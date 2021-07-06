package com.task_finalVersion.data.model;

public class Employee {
    public String firstName;
    public String lastName;
    public String imgURL;
    public String birthday;
    public String startJobDate;
    public String role;
    public String password;
    public String id;
    public String email;

    public Employee(String firstName, String lastName, String imgURL, String birthday, String startJobDate, String role, String password,String email ,  String id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.imgURL = imgURL;
        this.birthday = birthday;
        this.startJobDate = startJobDate;
        this.role = role;
        this.password = password;
        this.id = id;
        this.email=email;

    }

    public  Employee(){}


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStartJobDate() {
        return startJobDate;
    }

    public void setStartJobDate(String startJobDate) {
        this.startJobDate = startJobDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddQuery(){
        return "INSERT INTO `Employees` (`id`, `first_name`, `last_name`, `img_url`, `birthday`, `start_job_date`, `role`, `password`, `email`) VALUES (NULL, '"+this.firstName+"', '"+this.lastName+"', '"+this.imgURL+"', '"+this.birthday+"', '"+this.startJobDate+"', '"+this.role+"', '"+this.password+"', '"+this.email+"')";
    }
}
