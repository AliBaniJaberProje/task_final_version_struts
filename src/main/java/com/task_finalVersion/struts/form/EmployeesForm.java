package com.task_finalVersion.struts.form;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;


public class EmployeesForm extends ActionForm {

  private  String firstname;
  private  String lastname;
  private String email;
  private String birthday;
  private String role;

  public String getFirstname() {
        return firstname;
    }

  public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

  public String getLastname() {
        return lastname;
    }

  public void setLastname(String lastname) {
        this.lastname = lastname;
    }

  public String getEmail() {
        return email;
    }

  public void setEmail(String email) {
        this.email = email;
    }

  public String getBirthday() {
        return birthday;
    }

  public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

  public String getRole() {
        return role;
    }

  public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void reset(ActionMapping mapping, ServletRequest request) {
        this.birthday="";
        this.email="";
        this.firstname="";
        this.lastname="";
        this.role="";
    }
}
