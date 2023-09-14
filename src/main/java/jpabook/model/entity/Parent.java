package jpabook.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Parent {

    @Id
    @GeneratedValue
    private Long id;


}
