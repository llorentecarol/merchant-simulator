package xyz.mynt.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mynt.internal.model.TraceLog;

@Repository
public interface TraceLogRepository extends JpaRepository<TraceLog, String> {

}
