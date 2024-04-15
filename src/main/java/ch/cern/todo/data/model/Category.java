package ch.cern.todo.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @ToString.Include
    private String name;

    @ToString.Include
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
