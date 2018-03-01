package xyz.mynt.internal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mynt.internal.model.ProbingData;

@Repository
public interface ProbingDataRepository extends JpaRepository<ProbingData, String> {

}

