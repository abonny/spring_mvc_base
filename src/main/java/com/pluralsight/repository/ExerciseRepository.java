package com.pluralsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Exercise;

/**
 * @author luke.pahler
 */
@Repository("exerciseRepository")
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
