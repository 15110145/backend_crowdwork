package app.services;

import app.model.ProfessionJob;
import app.repository.ProfessionJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfessionJobService {
    @Autowired
    ProfessionJobRepository professionJobRepository;

    /*
    User
     */

    public ArrayList<ProfessionJob> findAllProfessionJob() {
        ArrayList<ProfessionJob> lstProfessionJob = new ArrayList<>();
        lstProfessionJob.addAll(professionJobRepository.findAllByDelFlag(Boolean.FALSE));
        return lstProfessionJob;
    }

    public Optional<ProfessionJob> findProfessionJobById(Integer id) {
        return professionJobRepository.findByIdAndDelFlag(id,Boolean.FALSE);
    }

    public List<ProfessionJob> getAllChildProfessionJob(Integer id) {
        Optional<ProfessionJob> cat= professionJobRepository.findById(Integer.valueOf(id));
        List<ProfessionJob> list = new ArrayList<>();
        if(cat.isPresent()) {
            ProfessionJob category = cat.get();
            recursiveTree(category,list);
        }
        return list;
    }

    private void recursiveTree(ProfessionJob cat,List<ProfessionJob> list) {
        list.add(cat);
        if (cat.getProfessionJobChildList().size() > 0) {
            for (ProfessionJob c : cat.getProfessionJobChildList()) {
                recursiveTree(c,list);
            }
        }
    }

    /*
    Admin
     */

    public ArrayList<ProfessionJob> findAll() {
        ArrayList<ProfessionJob> lstProfessionJob = new ArrayList<>();
        lstProfessionJob.addAll(professionJobRepository.findAll());
        return lstProfessionJob;
    }

    public Optional<ProfessionJob> getProfessionJob(Integer professionJobId) {
        return professionJobRepository.findById(professionJobId);
    }

    public void addProfessionJob(ProfessionJob professionJob) {
        professionJob.setDelFlag(Boolean.FALSE);
        professionJobRepository.save(professionJob);
    }

    public void editProfessionJob(ProfessionJob editedProfessionJob) {
        Optional<ProfessionJob> optionalProfessionJob = getProfessionJob(editedProfessionJob.getId());
        if(optionalProfessionJob.isPresent()) {
            ProfessionJob professionJob = optionalProfessionJob.get();
            if (editedProfessionJob.getDelFlag() != null){
                professionJob.setDelFlag(editedProfessionJob.getDelFlag());
            }
            if (editedProfessionJob.getProfessionJob() != null){
                professionJob.setProfessionJob(editedProfessionJob.getProfessionJob());
            }
            if (editedProfessionJob.getProfessionJobName() != null){
                professionJob.setProfessionJobName(editedProfessionJob.getProfessionJobName());
            }
            professionJobRepository.save(professionJob);
        }
        else
        {

        }
        //professionJobRepository.save(editedProfessionJob);
    }

    public void deleteProfessionJob(Integer professionJobId) {
        Optional<ProfessionJob> optionalProfessionJob = getProfessionJob(professionJobId);
        if(optionalProfessionJob.isPresent()) {
            ProfessionJob professionJob = optionalProfessionJob.get();
            professionJob.setDelFlag(Boolean.TRUE);
            professionJobRepository.save(professionJob);
        }
        else
        {

        }
    }
}
