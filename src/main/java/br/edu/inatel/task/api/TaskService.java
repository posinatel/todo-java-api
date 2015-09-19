package br.edu.inatel.task.api;

import br.edu.inatel.task.model.Task;
import br.edu.inatel.task.model.TaskDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/tasks")
public class TaskService {

    TaskDAO taskDAO = new TaskDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        ArrayList<Task> tasks = taskDAO.list();
        return Response
                .ok()
                .entity(tasks)
                .build();
    }

    @GET
    @Path("{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskById(@PathParam("taskId") Long taskId) {
        ArrayList<Task> tasks = taskDAO.list();
        Task task = tasks.get(tasks.size() - 1);
        return Response
                .ok()
                .entity(task)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Task task) {
        taskDAO.create(task);
        return Response
                .status(201)
                .entity(task)
                .build();
    }
}
