package com.task_finalVersion.struts.action;

import com.task_finalVersion.data.ORM.Manager;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class TeamAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        Manager manager=new Manager((String) session.getAttribute("id"));
        HashMap<String, HashMap<String,String>> myTeam=manager.getMyEmployee();
        myTeam.put((String) session.getAttribute("id"),manager.getMyInfo());
        request.setAttribute("myTeam",myTeam);


        return mapping.findForward("team");


    }
}
