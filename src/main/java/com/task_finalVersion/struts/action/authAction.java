package com.task_finalVersion.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.task_finalVersion.data.ORM.Auth;
import com.task_finalVersion.data.ORM.Manager;
import com.task_finalVersion.struts.form.authForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.HashMap;


public class authAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        authForm authform = (authForm) form;
        HttpSession session = request.getSession();
        HashMap<String, String> loginResult= Auth.isAuthorized(authform.getEmail(),authform.getPassword());
        if(loginResult!=null){
            session.setAttribute("id",loginResult.get("id"));
            session.setAttribute("role",loginResult.get("role"));
            session.setAttribute("authorized",true);

            return mapping.findForward("success");
        }else if ( session.getAttribute("authorized")!=null){
            return mapping.findForward("success");
        }
        else{
            request.setAttribute("failed","password and email is invalid");
            return mapping.findForward("failed");
        }
    }

}
