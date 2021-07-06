package com.task_finalVersion.struts.form;



import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.ServletRequest;


public class authForm  extends ActionForm {

   private String email;
   private String password;

   public String getEmail() {
        return email;
    }

   public void setEmail(String email) {
        this.email = email;
    }

   public String getPassword() {
        return password;
    }

   public void setPassword(String password) {
        this.password = password;
    }

   @Override
   public ActionErrors validate(ActionMapping mapping, ServletRequest request) {

        ActionErrors errors = new ActionErrors();
        if( getEmail() == null || ("".equals(getEmail())))
        {
            errors.add("common.username.err",
                    new ActionMessage("error.common.username.required"));
        }

        if( getPassword() == null || ("".equals(getPassword())))
        {
            errors.add("common.password.err",
                    new ActionMessage("error.common.password.required"));
        }

        return errors;

    }

   @Override
   public void reset(ActionMapping mapping, ServletRequest request) {

        email = "";
        password = "";
    }

}
