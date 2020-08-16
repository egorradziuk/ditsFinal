package com.dev_incubator.dits.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role")
@Setter
@Getter
public class RoleY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "roleY")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserY> usersY;

    @Column(name = "role_name")
    private String roleName;

}
