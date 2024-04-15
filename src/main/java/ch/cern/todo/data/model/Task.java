package ch.cern.todo.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @ToString.Include
    private String name;

    @ToString.Include
    private String description;

    @NotNull(message = "Deadline is mandatory")
    @ToString.Include
    private Date deadline;

    @NotNull()
    @ToString.Include
    private Boolean isFinish;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonIgnore()
    private Category category;

    public Task(String name, String description,Date deadline,Boolean isFinish,Category category) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.isFinish = isFinish;
        this.category = category;
    }


}
