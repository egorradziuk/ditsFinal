package com.dev_incubator.dits.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean correct;

    @JsonIgnore //AA
    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id", nullable = false, foreignKey = @ForeignKey(name = "answer_question_FK"))
    private Question question;
}
