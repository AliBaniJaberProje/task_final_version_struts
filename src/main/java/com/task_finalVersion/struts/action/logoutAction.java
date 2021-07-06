package com.task_finalVersion.struts.action;

import com.task_finalVersion.data.ORM.Auth;
import com.task_finalVersion.struts.form.authForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class logoutAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

    //    authForm authform = (authForm) form;
        HttpSession session = request.getSession();
        session.removeAttribute("id");
        session.removeAttribute("role");
        session.removeAttribute("authorized");
      //  authform.reset(mapping,request);
        return mapping.findForward("logout");




    }

}
