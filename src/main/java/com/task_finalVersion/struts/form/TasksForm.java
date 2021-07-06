package com.task_finalVersion.struts.form;

import com.task_finalVersion.data.model.Task;
import org.apache.struts.action.ActionForm;

import java.util.ArrayList;

public class TasksForm extends ActionForm {

    private ArrayList<Task> taskArrayList;

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }
}
