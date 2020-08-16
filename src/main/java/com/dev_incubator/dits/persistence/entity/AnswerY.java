package com.dev_incubator.dits.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="Answer")
@Setter
@Getter
public class AnswerY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private QuestionY questionY;

    @Override
    public String toString() {
        return "Answer [id = " + id +
                "; correct = " + correct +
                "; description =\'" + description + "\']";
    }
}
