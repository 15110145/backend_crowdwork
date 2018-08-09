package app.services;

import app.model.Contracts;
import app.model.Identity.ContractsIdentity;
import app.repository.ContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContractsService {

    @Autowired
    ContractsRepository contractsRepository;

    public List<Contracts> findAllContracts(){
        List<Contracts> contracts = new ArrayList<Contracts>();
        contracts.addAll(contractsRepository.findAll());
        return contracts;
    }

    public Optional<Contracts> findContract(Integer f_id, Integer r_id){
        ContractsIdentity contractsIdentity = new ContractsIdentity(f_id,r_id);
        return contractsRepository.findById(contractsIdentity);
//        return contractsRepository.findByContractsIdentity(id);
    }


    public void save(Contracts contracts){
        contractsRepository.save(contracts);
    }

    public void update(Contracts contracts){
        Optional<Contracts> contract = findContract(contracts.getContractsIdentity().getUsersFreelancerId(), contracts.getContractsIdentity().getUsersRecruiterId());
        if(contract.isPresent()){
            Contracts existingContract = contract.get();
            if(contracts.getJobs() != null){
                existingContract.setJobs(contracts.getJobs());
            }
            if(contracts.getStatus() != null){
                existingContract.setStatus(contracts.getStatus());
            }
            if(contracts.getDelFlag() != null){
                existingContract.setDelFlag(contracts.getDelFlag());
            }
            contractsRepository.save(existingContract);
        }
    }

    public void delete(Integer f_id, Integer r_id){
        Optional<Contracts> contract = findContract(f_id, r_id);
        if(contract.isPresent()) {
            Contracts existingContract = contract.get();
            existingContract.setDelFlag(true);
            contractsRepository.save(existingContract);
        }
    }
}
