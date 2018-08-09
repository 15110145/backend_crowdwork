package app.repository;

import app.model.Contracts;
import app.model.Identity.ContractsIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractsRepository extends JpaRepository<Contracts, ContractsIdentity> {
//    List<Contracts> findByContractsIdentity(ContractsIdentity contractsIdentity);
}
