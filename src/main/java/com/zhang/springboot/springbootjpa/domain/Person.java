package com.zhang.springboot.springbootjpa.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@ToString()
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer gender;
    @DomainEvents
    Collection<Object> domainEvents(){
        List<Object> events = new ArrayList<>();
        return events;
    }
}
