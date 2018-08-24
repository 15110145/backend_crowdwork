package app.controller;


import app.model.Contracts;
import app.model.Jobs;
import app.services.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/contract")
public class ContractController {

    @Autowired
    ContractsService contractsService;

    //Add
    @RequestMapping(value = "/apply", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String applyJob(@RequestBody Jobs jobs) {
        contractsService.apply(jobs);
        return "Success";
    }

    //Add
    @RequestMapping(value = "/verified", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String applyJob1(@RequestBody Contracts contracts) {
        contractsService.contractVerified(contracts);
        return "Success";
    }
}
