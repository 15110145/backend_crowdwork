package app.services;


import app.model.Status;
import app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class StatusService implements Serializable {

    @Autowired
    StatusRepository statusRepository;

    public ArrayList<Status> findAllStatus(){
        ArrayList<Status> lstStatus = new ArrayList<>();
        lstStatus.addAll(statusRepository.findAllByDelFlag(Boolean.FALSE));
        return lstStatus;
    }

    public Optional<Status> findStatusById(Integer id){
        return statusRepository.findByIdAndDelFlag(id,Boolean.FALSE);
    }

    public Optional<Status> findStatusByNameAndKind(String name, String kind){
        return statusRepository.findByStatusNameAndKind(name,kind);
    }
    
    /*
    Admin
     */

    public ArrayList<Status> findAll() {
        ArrayList<Status> lstStatus = new ArrayList<>();
        lstStatus.addAll(statusRepository.findAll());
        return lstStatus;
    }

    public Optional<Status> getStatus(Integer statusId)
    {
        return statusRepository.findById(statusId);
    }

    public void addStatus(Status status) {
        status.setDelFlag(Boolean.FALSE);
        statusRepository.save(status);
    }

    public void editStatus(Status editedStatus) {
        Optional<Status> optionalStatus = getStatus(editedStatus.getId());
        if(optionalStatus.isPresent()) {
            Status status = optionalStatus.get();
            if (editedStatus.getDelFlag() != null){
                status.setDelFlag(editedStatus.getDelFlag());
            }
            if (editedStatus.getStatusName() != null){
                status.setStatusName(editedStatus.getStatusName());
            }
            if (editedStatus.getKind() != null){
                status.setKind(editedStatus.getKind());
            }
            statusRepository.save(status);
        }
        else
        {

        }
        //statusRepository.save(editedStatus);
    }

    public void deleteStatus(Integer statusId) {
        Optional<Status> optionalStatus = getStatus(statusId);
        if(optionalStatus.isPresent()) {
            Status status = optionalStatus.get();
            status.setDelFlag(Boolean.TRUE);
            statusRepository.save(status);
        }
        else
        {

        }
    }
}
