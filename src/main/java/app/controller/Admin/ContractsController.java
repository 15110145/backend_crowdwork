package app.controller.Admin;

import app.model.Contracts;
import app.services.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin/contract")
public class ContractsController {

    @Autowired
    ContractsService contractsService;

    @RequestMapping(value = "/list", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Contracts> findAllContracts(){
        return contractsService.findAllContracts();
    }

    @RequestMapping(value = "/{f_id}/{r_id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Contracts> findContract(@PathVariable Integer f_id, @PathVariable Integer r_id){//f_id: freelancer user id, r_id: recruiter user id

        return contractsService.findContract(f_id,r_id);
    }

    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String saveContract(@RequestBody Contracts contracts){
        contractsService.save(contracts);
        return "Contract Saved!";
    }

    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateContract(@RequestBody Contracts contracts){
        contractsService.update(contracts);
        return "Contract Updated!";
    }

    @RequestMapping(value = "/{f_id}/{r_id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteContract(@PathVariable Integer f_id, @PathVariable Integer r_id){
        contractsService.delete(f_id,r_id);
        return "Contract Deleted!";
    }

}
