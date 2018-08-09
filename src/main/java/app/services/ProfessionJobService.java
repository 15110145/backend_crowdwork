package app.services;

import app.model.ProfessionJob;
import app.repository.ProfessionJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class ProfessionJobService {
    @Autowired
    ProfessionJobRepository professionJobRepository;

    public ArrayList<ProfessionJob> findAll()
    {
        ArrayList<ProfessionJob> lstProfessionJob = new ArrayList<>();
        lstProfessionJob.addAll(professionJobRepository.findAll());
        return lstProfessionJob;
    }

    public Optional<ProfessionJob> getProfessionJob(Integer professionJobId)
    {
        return professionJobRepository.findById(professionJobId);
    }

    public void addProfessionJob(ProfessionJob professionJob)
    {
        professionJob.setDelFlag(Boolean.FALSE);
        professionJobRepository.save(professionJob);
    }

    public void editProfessionJob(ProfessionJob editedProfessionJob)
    {
        Optional<ProfessionJob> optionalProfessionJob = getProfessionJob(editedProfessionJob.getId());
        if(optionalProfessionJob.isPresent()) {
            ProfessionJob professionJob = optionalProfessionJob.get();
            if (editedProfessionJob.getDelFlag() != null){
                professionJob.setDelFlag(editedProfessionJob.getDelFlag());
            }
            if (editedProfessionJob.getparentId() != null){
                professionJob.setparentId(editedProfessionJob.getparentId());
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

    public void deleteProfessionJob(Integer professionJobId)
    {
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
