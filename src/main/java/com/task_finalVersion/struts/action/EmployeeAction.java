package com.task_finalVersion.struts.action;


import com.task_finalVersion.data.ORM.Manager;
import com.task_finalVersion.data.model.Employee;
import com.task_finalVersion.struts.form.EmployeesForm;
import com.task_finalVersion.struts.form.authForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class EmployeeAction extends Action {


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        if(request.getMethod().equals("POST")){
            EmployeesForm employeesForm = (EmployeesForm) form;
            Employee employee=new Employee(employeesForm.getFirstname(),employeesForm.getLastname(),"https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",employeesForm.getBirthday(),"",employeesForm.getRole(),"11223344",employeesForm.getEmail(),null);
            // need send sms
            Manager manager=new Manager((String) session.getAttribute("id"));

            manager.saveNewEmployee(employee);

            employeesForm.reset(mapping,request);
            return mapping.findForward("eee");
        }else if(request.getMethod().equals("GET")){
            Manager manager=new Manager((String) session.getAttribute("id"));
            HashMap<String, HashMap<String,String>> myTeam=manager.getAllEmployee();
            request.setAttribute("myTeam",myTeam);
            return mapping.findForward("employee");

        }
        return mapping.findForward("eee");



    }
}
