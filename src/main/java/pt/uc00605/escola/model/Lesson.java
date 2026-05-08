package pt.uc00605.escola.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Lesson {

    private Long id;

    private String name;

    private String youtubeUrl;
    
}
