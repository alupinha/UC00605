package pt.uc00605.escola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import pt.uc00605.escola.enums.Category;
import pt.uc00605.escola.model.Course;
import pt.uc00605.escola.model.Lesson;
import pt.uc00605.escola.repository.CourseRepository;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

	@Bean
	@Profile("dev")
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
      
		return args -> {
			//courseRepository.deleteAll();
			for(int i=0; i < 10; i++) {
				//criando objeto Course
				Course course = new Course(null);
				course.setName("Java com Spring" + i); 
				course.setCategory(Category.BACKEND);
				//criando objeto Lesson
				Lesson lesson = new Lesson();
				lesson.setName("Introdução ao Spring Boot" + i);
				lesson.setYoutubeUrl("https://www.youtube.com/watch?v=oCEvr8OpY64");

				//add uma lesson do objeto Course
				course.getLessons().add(lesson);

				//criando um segundo objeto
				Lesson lesson2 = new Lesson();
				lesson2.setName("Introdução ao Spring Boot" + i);
				lesson2.setYoutubeUrl("https://www.youtube.com/watch?v=oCEvr8OpY64");

				//add uma lesson do objeto Course
				course.getLessons().add(lesson2);

				courseRepository.save(course);

			} // fim do for


		};

}


}
