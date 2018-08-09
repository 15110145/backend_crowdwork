package app.controller;

import app.model.Skills;
import app.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SkillsController {
    @Autowired
    SkillsService skillsService;

    @RequestMapping(value = "/findskill/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Skills> findskill(@PathVariable int id){
        return skillsService.findSkill(id);
    }

    @RequestMapping(value = "/findallskills", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Skills> findallskills(){
        List<Skills> skills = new ArrayList<Skills>();
        skills.addAll(skillsService.findallskills());
        return skills;
    }

    @RequestMapping(value = "/saveskill", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String saveSkill(@RequestBody Skills skills){
        skillsService.saveSkill(skills);
        return "Skill saved!";
    }

    @RequestMapping(value = "/updateskill", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateSkill(@RequestBody Skills skills){
        skillsService.updateSkill(skills);
        return "Skill Updated!";
    }

    @RequestMapping(value = "/deleteskill/{id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteSkill(@PathVariable int id){
        skillsService.deleteSkill(id);
        return "Skill Deleted!";
    }
}
