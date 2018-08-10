package app.services;

import app.model.Skills;
import app.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    public List<Skills> findSkill(Integer id){
        return skillsRepository.findSkillsById(id);
    }

    public List<Skills> findallskills(){
//        List<Skills> skills = new ArrayList<Skills>();
//        skills.addAll(skillsRepository.findAll());
        return skillsRepository.findAllSkills();
    }

    public void save(Skills skills){
        skills.setDelFlag(false);
        skillsRepository.save(skills);
    }

    public Boolean update(Skills skills){
        List<Skills> skill = findSkill(skills.getId());
        if(!skill.isEmpty()){
            Skills existingskill = skill.get(0);
            if (skills.getSkillName() != null){
                existingskill.setSkillName(skills.getSkillName());
            }
            if (skills.getDelFlag() != null){
                existingskill.setDelFlag(skills.getDelFlag());
            }
            skillsRepository.save(existingskill);
            return true;
        }
        return false;
    }

    public Boolean delete(Integer id){
        List<Skills> skill = findSkill(id);
        if(!skill.isEmpty()) {
            Skills existingskill = skill.get(0);
            existingskill.setDelFlag(true);
            skillsRepository.save(existingskill);
            return true;
        }
        return false;
    }
}
