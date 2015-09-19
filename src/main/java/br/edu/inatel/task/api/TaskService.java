package br.edu.inatel.task.api;

import br.edu.inatel.task.model.Task;
import br.edu.inatel.task.model.TaskDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/tasks")
public class TaskService {

//    TaskDAO taskDAO = new TaskDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        ArrayList<Task> tasks = TaskDAO.getInstance().list();
        return Response
                .ok()
                .entity(tasks)
                .build();
    }

    @GET
    @Path("{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskById(@PathParam("taskId") Long id) {
        Task task = TaskDAO.getInstance().getById(id);
        return Response
                .ok()
                .entity(task)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Task task){
        Task created = TaskDAO.getInstance().create(task);
        return Response
                .status(201)
                .entity(created)
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Task task){
        Task created = TaskDAO.getInstance().update(task);
        return Response
                .ok()
                .entity(created)
                .build();
    }
}
