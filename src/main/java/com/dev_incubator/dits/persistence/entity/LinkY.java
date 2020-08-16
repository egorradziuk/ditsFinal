package com.dev_incubator.dits.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Link")
@Setter
@Getter
public class LinkY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link")
    private String link;

    /*//todo manyToOne
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "literature_id")
    private LiteratureY literatureY;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "literature_id")
    private LiteratureY literatureY;

    @Override
    public String toString() {
        return "Link [id = " + id +
                ", link = " + link +
                "]";
    }

}
