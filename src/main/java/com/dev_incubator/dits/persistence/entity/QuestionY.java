package com.dev_incubator.dits.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question")
@Setter
@Getter
public class QuestionY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private TestY testY;

    @OneToMany(mappedBy = "questionY")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnswerY> answerY;

    @OneToMany(mappedBy = "questionY")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<StatisticY> statisticsY;

    //todo change to oneToMany
    /*@OneToOne(mappedBy = "questionY", fetch = FetchType.EAGER)
    private LiteratureY literatureY;*/
    @OneToMany(mappedBy = "questionY")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<LiteratureY> literatureY;

    @Override
    public String toString() {
        return "Question [id = " + id +
                ", description = " + description +
                ", test = " + testY +
                ", answer = " + answerY +
                ", statistic = " + statisticsY +
                ", literature = " + literatureY +
                "]";
    }

}
