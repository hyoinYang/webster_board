package web1.web1.repository;

import org.springframework.stereotype.Repository;
import web1.web1.domain.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BoardRepository extends JpaRepository<GroupEntity, Long> {

}

