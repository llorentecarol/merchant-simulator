package xyz.mynt.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mynt.internal.model.TransactionLog;

@Repository
public interface TransactionLogJpaRepository extends JpaRepository<TransactionLog, String> {

}
