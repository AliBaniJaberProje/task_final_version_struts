package com.task_finalVersion.struts.action;

import com.task_finalVersion.data.database.DatabaseDriver;
import com.task_finalVersion.data.model.Task;
import com.task_finalVersion.struts.form.TasksForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TasksAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(request.getMethod().equals("POST")){
            String info[]=request.getHeader("status").split(",");
           DatabaseDriver.db_executor("UPDATE Taks SET STATUS = '"+info[0]+"' WHERE id = '"+info[1]+"'", true);
        }
        TasksForm tasksForm = (TasksForm) form;
        HttpSession session = request.getSession();

        ResultSet resultSet= DatabaseDriver.db_executor("select Taks.*,Employees.* from Taks INNER JOIN Employees on Taks.manager=Employees.id where manager='"+session.getAttribute("id")+"'",false);
        ArrayList<Task> taskArrayList=new ArrayList<>();
        request.removeAttribute("tasks");
        while (resultSet.next()){
            taskArrayList.add(new Task(resultSet.getString("id"),resultSet.getString("task_name"),
                    resultSet.getString("first_name")+" "+resultSet.getString("last_name"),resultSet.getString("status"),
                    resultSet.getString("hours"),resultSet.getString("description")
                    ));
        }
        request.setAttribute("tasks",taskArrayList);



        return mapping.findForward("tasks");




    }


    public ActionForward ext(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return mapping.findForward("tt");
    }
}
