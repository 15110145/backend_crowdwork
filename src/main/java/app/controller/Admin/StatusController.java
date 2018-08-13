package app.controller.Admin;

import app.model.Status;
import app.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value="/admin/status")
public class StatusController {

    @Autowired
    StatusService  statusService;

    //show List
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<Status> getStatusList() {
        ArrayList<Status> list = statusService.findAll();
        return list;
    }

    //Find particular
    @RequestMapping(value = "/{statusId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<Status> getStatus(@PathVariable("statusId") String statusId) {
        return statusService.getStatus(Integer.valueOf(statusId));
    }

    //Add
    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Status addStatus(@RequestBody Status status) {

        System.out.println("(Service Side) Creating: " + status.getId());
        statusService.addStatus(status);
        return status;
    }

    //Edit
    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Status updateStatus(@RequestBody Status status) {

        System.out.println("(Service Side) Editing: " + status.getId());
        statusService.editStatus(status);
        return status;
    }

    //Delete
    @RequestMapping(value = "/{statusId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteStatus(@PathVariable("statusId") String statusId) {

        System.out.println("(Service Side) Deleting: " + statusId);

        statusService.deleteStatus(Integer.valueOf(statusId));
    }
}
