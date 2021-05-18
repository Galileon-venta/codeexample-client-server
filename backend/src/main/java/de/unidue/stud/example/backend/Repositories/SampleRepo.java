package de.unidue.stud.example.backend.Repositories;

import de.unidue.stud.example.backend.Entities.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SampleRepo extends JpaRepository<Sample, Integer> {
    Sample findSampleById(Integer id);
    List<Sample> findAllByIdBetweenOrderByUsername(Integer start, Integer end);
}
