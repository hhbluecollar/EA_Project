package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findByName(String name);
    Course findByCode(String name);

}
