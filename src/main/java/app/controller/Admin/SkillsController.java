package app.controller.Admin;

import app.model.Skills;
import app.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin/skill")
public class SkillsController {
    @Autowired
    SkillsService skillsService;

    @RequestMapping(value = "/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Skills> findskill(@PathVariable Integer id){
        return skillsService.findSkill(id);
    }

    @RequestMapping(value = "/list", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Skills> findallskills(){
        List<Skills> skills = new ArrayList<Skills>();
        skills.addAll(skillsService.findallskills());
        return skills;
    }

    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String saveSkill(@RequestBody Skills skills){
        skillsService.save(skills);
        return "Skill saved!";
    }

    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateSkill(@RequestBody Skills skills){
        if(skillsService.update(skills)){
            return "Skill Updated!";
        }
        return "Skill Not Found!";
    }

    @RequestMapping(value = "/{id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteSkill(@PathVariable Integer id){
        if(skillsService.delete(id)){
            return "Skill Deleted!";
        }
        return "Skill Not Found!";
    }
}
