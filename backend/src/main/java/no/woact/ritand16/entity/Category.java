package no.woact.ritand16.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//Created 09/04/2018 by Ritter
//https://github.com/arcuri82/testing_security_development_enterprise_systems/blob/master/intro/exercises/quiz-game/part-08/src/main/java/org/tsdes/intro/exercises/quizgame/entity/Category.java

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max=128)
    @Column(unique=true)
    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;

    public Category() {
        subCategories = new ArrayList<>();
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
