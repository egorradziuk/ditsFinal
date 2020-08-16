package com.dev_incubator.dits.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Topic")
@Setter
@Getter
public class TopicY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "topicY")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TestY> testsY;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
