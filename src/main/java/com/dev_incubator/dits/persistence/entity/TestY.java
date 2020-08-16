package com.dev_incubator.dits.persistence.entity;

import com.dev_incubator.dits.persistence.entity.QuestionY;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Test")
@Setter
@Getter
public class TestY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicY topicY;

    @OneToMany(mappedBy = "testY")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<QuestionY> questionsY;

}
