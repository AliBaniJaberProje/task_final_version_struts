package com.task_finalVersion.struts.action;

import com.task_finalVersion.data.database.DatabaseDriver;
import com.task_finalVersion.data.model.Task;
import com.task_finalVersion.struts.form.TasksForm;
import com.task_finalVersion.struts.form.authForm;
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

        TasksForm tasksForm = (TasksForm) form;
        HttpSession session = request.getSession();

        ResultSet resultSet= DatabaseDriver.db_executor("SELECT * FROM `Taks` WHERE id_employee='"+session.getAttribute("id")+"'",false);
        ArrayList<Task> taskArrayList=new ArrayList<>();

        while (resultSet.next()){
            taskArrayList.add(new Task(resultSet.getString("id"),resultSet.getString("task_name"),
                    resultSet.getString("manager"),resultSet.getString("status"),
                    resultSet.getString("hours"),resultSet.getString("description")
                    ));
        }
        request.setAttribute("tasks",taskArrayList);



        return mapping.findForward("tasks");




    }

}
