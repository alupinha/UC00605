package pt.uc00605.escola.model;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import org.hibernate.annotations.SQLDelete;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE course SET status = 1 WHERE id = ?")
public class Course {
    

    private Long id;

    private String name;

    private Category category;

    private Status status = Status.ACTIVE;

    private List<Lesson> lessons = new ArrayList<>();

}
