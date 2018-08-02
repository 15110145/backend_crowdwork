package app.services;


import app.model.Status;
import app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
public class StatusService implements Serializable {

    @Autowired
    StatusRepository statusRepository;

    public ArrayList<Status> findAll()
    {
        ArrayList<Status> lstJobCategory = new ArrayList<>();
        for (Status status: statusRepository.findAll())
        {
            lstJobCategory.add(status);
        }
        return lstJobCategory;
    }

    public Status getStatus(Integer statusId)
    {
        return statusRepository.findById(statusId).get();
    }

    public void addStatus(Status status,Integer currentUser)
    {
        Status statusAdd = new Status();
        statusAdd.setStatusName(status.getStatusName());
        statusAdd.setKind(status.getKind());
        statusAdd.setDelFlag(Boolean.FALSE);
        statusAdd.setCreateUser(currentUser);
        statusAdd.setCreateTime(new Date());
        statusRepository.save(status);
    }

    public void editJobCategory(Integer statusId, Status editedStatus, Integer currentUser)
    {
        Status newStatus = getStatus(statusId);
        newStatus.setStatusName(editedStatus.getStatusName());
        newStatus.setKind(editedStatus.getKind());
        newStatus.setUpdateUser(currentUser);
        newStatus.setUpdateTime(new Date());
        statusRepository.save(newStatus);
    }

    public void deleteStatus(Integer statusId)
    {
        Status deletedStatus = getStatus(statusId);
        deletedStatus.setDelFlag(Boolean.TRUE);
        statusRepository.save(deletedStatus);
    }
}
