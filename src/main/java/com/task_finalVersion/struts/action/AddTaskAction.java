package com.task_finalVersion.struts.action;

import com.task_finalVersion.struts.form.TasksForm;
import com.task_finalVersion.struts.form.authForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddTaskAction extends Action {


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response) throws Exception {

        TasksForm tasksForm = (TasksForm) form;

      return mapping.findForward("ttt");

    }
}
