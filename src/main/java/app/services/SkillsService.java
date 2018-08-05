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

    public Optional<Skills> findSkill(int id){
        return skillsRepository.findById(id);
    }

    public List<Skills> findallskills(){
        List<Skills> skills = new ArrayList<Skills>();
        skills.addAll(skillsRepository.findAll());
        return skills;
    }

    public void saveSkill(Skills skills){
        skills.setDelFlag(false);
        skillsRepository.save(skills);
    }

    public void updateSkill(Skills skills){
        Optional<Skills> skill = findSkill(skills.getId());
        if(skill.isPresent()){
            Skills existingskill = skill.get();
            if (skills.getSkillName() != null){
                existingskill.setSkillName(skills.getSkillName());
            }
            if (skills.getDelFlag() != null){
                existingskill.setDelFlag(skills.getDelFlag());
            }
            skillsRepository.save(existingskill);
        }
    }

    public void deleteSkill(int id){
        Optional<Skills> skill = findSkill(id);
        if(skill.isPresent()) {
            Skills existingskill = skill.get();
            existingskill.setDelFlag(true);
            skillsRepository.save(existingskill);
        }
    }
}
