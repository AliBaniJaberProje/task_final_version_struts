package com.task_finalVersion.struts.action;
import com.task_finalVersion.data.ORM.Manager;
import com.task_finalVersion.data.database.DatabaseDriver;
import com.task_finalVersion.data.model.Employee;
import com.task_finalVersion.struts.form.AddTaskForm;
import com.task_finalVersion.struts.form.EmployeesForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class AddTaskAction extends Action {


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("ASDFAASDFAFASDFASFADFASDDFASFASDFSAFASDFASDFASFASFAFAFFAFASFFSAF");
        AddTaskForm employeesForm = (AddTaskForm) form;
//        Manager manager=new Manager((String) request.getSession().getAttribute("id"));
//        HashMap<String, HashMap<String,String>> myTeam=manager.getAllEmployee();
//        request.setAttribute("myTeam",myTeam);

        DatabaseDriver.db_executor("" +
                "INSERT INTO `Taks` (`id`, `task_name`, `manager`, `status`, `hours`, `description`, `id_employee`) VALUES (NULL, '"+employeesForm.getTaskName()+"', '"+request.getSession().getAttribute("id")+"', 'In Progress', '"+employeesForm.getHour()+"', '"+employeesForm.getDescraption()+"', '"+employeesForm.getIdEmployee()+"');"+

                "",true);

        return mapping.findForward("AddTasksPage");

    }
}
