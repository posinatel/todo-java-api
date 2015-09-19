package br.edu.inatel.task.api;

import br.edu.inatel.task.model.Task;
import br.edu.inatel.task.model.TaskDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
