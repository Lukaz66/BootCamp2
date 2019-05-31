package com.everis.models.dtoprojection;

import com.everis.models.Student;
import com.everis.models.StudentClass;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "StudentClassProjection", types = StudentClass.class)
public interface StudentClassProjection {

  List<Student> getStudent();

}
