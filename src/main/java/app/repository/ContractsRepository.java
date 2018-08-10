package app.repository;

import app.model.Contracts;
import app.model.Identity.ContractsIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractsRepository extends JpaRepository<Contracts, ContractsIdentity> {
//    List<Contracts> findByContractsIdentity(ContractsIdentity contractsIdentity);

    List<Contracts> findByContractsIdentityAndDelFlag(ContractsIdentity contractsIdentity, Boolean delFlag);

    @Modifying
    @Query("SELECT u FROM Contracts u WHERE u.delFlag=false")
    List<Contracts> findAllContracts();
}
