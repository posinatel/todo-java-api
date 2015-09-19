package br.edu.inatel.task.model;

import jdk.nashorn.internal.objects.NativeArray;

import java.util.ArrayList;

/**
 * Created by Edgar on 19/09/2015.
 */
public class TaskDAO {

    private ArrayList<Task> tasks;
    private Long id = 0L;
    private static TaskDAO taskDAO = null;

    public static TaskDAO getInstance(){
        if (taskDAO == null)
            taskDAO = new TaskDAO();
        return taskDAO;
    }

    public TaskDAO() {

        tasks = new ArrayList<Task>();
        tasks.add(new Task("Learn REST API", id));
        id++;
        tasks.add(new Task("Learn Gradle", id));
        id++;
        tasks.add(new Task("Learn Groovy", id));
        id++;
        tasks.add(new Task("Learn Grails", id));
        id++;
        tasks.add(new Task("Learn AngularJS", id));
        id++;
    }

    public ArrayList<Task> list(){
        return tasks;
    }

    public Task getById(Long id){

        Task task = null;

        for (Task t : tasks){
            if (t.getId() == id)
                task = t;
        }

        return task;

    }

    public Task create(Task task){
        task.setId(id);
        tasks.add(task);
        id++;
        return task;
    }

    public Task update(Task task){
        int ind = tasks.indexOf(getById(task.getId()));
        tasks.remove(ind);
        tasks.add(ind, task);
        return task;
    }
}
