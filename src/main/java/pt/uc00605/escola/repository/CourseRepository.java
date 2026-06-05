package pt.uc00605.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.uc00605.escola.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
