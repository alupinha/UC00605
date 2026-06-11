package pt.uc00605.escola.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Positive;
import pt.uc00605.escola.exception.ResourceNotFoundException;
import pt.uc00605.escola.model.Course;
import pt.uc00605.escola.repository.CourseRepository;

@Service
@Validated

public class CourseService {

   private final CourseRepository repository;
   
   public CourseService (CourseRepository repository){

       this.repository = repository; 
   } 

   /***FIND ALL */
   public List<Course> findAll(){
     return repository.findAll();
   }

   /**FIND ByID */
   public Course findById(@NonNull Long id) {
      Course course = repository.findById(id).orElseThrow(() ->
      new ResourceNotFoundException("Course Not Found with Id: " + id));
      return course;
   }

   /*Creaated Course */
   public Course createdCourse(@NonNull Course course) {
      return this.repository.save(course);
   }

   /*Delete Course*/
   public void deleteCourse(@NonNull @Positive Long id){
      this.repository.findById(id).map(data -> {
         this.repository.deleteById(id);
         return true;
      }).orElseThrow(() -> new ResourceNotFoundException("Course ja deletado ou inexistente" + id));

   }

   /**Update course */

   public Course updateCourse(@Positive @NonNull Long id, Course frontCourse) {
      /**1ª Buscar para maquina o que temos no banco */
      /**2ª Criar variavel que tem o course atualizado */
      return this.repository.findById(id).map(backCourse -> {
         backCourse.setName(frontCourse.getName());
         backCourse.setCategory(frontCourse.getCategory());
         /**Tenho que apagar a minha lista q está em memoria */
         backCourse.getLessons().clear();
         frontCourse.getLessons().forEach(data -> backCourse.getLessons().add(data));
         /**salvando no banco */
         this.repository.save(backCourse);
         return backCourse;
      }).orElseThrow(() -> new ResourceNotFoundException("Course not found ID: " + id));
   }

}

    