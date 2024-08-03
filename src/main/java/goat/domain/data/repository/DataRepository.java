package goat.domain.data.repository;

import goat.domain.data.domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface DataRepository extends JpaRepository<Data, Integer> {
    Boolean existsByName(String name);

    Optional<Data> findTopByNameOrderByIdDesc(String name);
}
