package com.example.assignment.common.jpa;

import org.hibernate.annotations.GenericGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SuppressWarnings("deprecation")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@GenericGenerator(
        name = "id_generator",
        strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
)
public @interface CustomIdGenerator {
}
