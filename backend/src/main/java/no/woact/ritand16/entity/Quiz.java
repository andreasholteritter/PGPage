package no.woact.ritand16.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Created 09/04/2018 by Ritter
//https://github.com/arcuri82/testing_security_development_enterprise_systems/blob/master/intro/exercises/quiz-game/part-08/src/main/java/org/tsdes/intro/exercises/quizgame/entity/Quiz.java

@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private SubCategory subCategory;

    @NotBlank
    @Size(max = 128)
    @Column(unique=true)
    private String question;

    @NotBlank
    @Size(max = 128)
    private String firstAnswer;

    @NotBlank
    @Size(max = 128)
    private String secondAnswer;

    @NotBlank
    @Size(max = 128)
    private String thirdAnswer;

    @NotBlank
    @Size(max = 128)
    private String fourthAnswer;

    @Range(min = 0, max = 3)
    private int indexOfCorrectAnswer;

    public Quiz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    public int getIndexOfCorrectAnswer() {
        return indexOfCorrectAnswer;
    }

    public void setIndexOfCorrectAnswer(int indexOfCorrectAnswer) {
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}