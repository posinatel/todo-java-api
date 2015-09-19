package br.edu.inatel.task.model;

import java.util.ArrayList;

public class TaskDAO {

    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskDAO() {
        tasks.add(new Task("Learn REST APIs"));
        tasks.add(new Task("Learn Gradle"));
        tasks.add(new Task("Learn Groovy"));
        tasks.add(new Task("Learn Grails"));
        tasks.add(new Task("Learn AngularJS"));
    }

    public ArrayList<Task> list() {
        return tasks;
    }

    public void create(Task task) {
        task.setId(22L);
        tasks.add(task);
    }

}
