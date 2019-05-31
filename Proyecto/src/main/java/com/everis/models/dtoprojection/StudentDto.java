package com.everis.models.dtoprojection;

import com.everis.models.Student;
import com.everis.models.Subject;
import com.everis.models.Teacher;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StudentDto {

  private int classId;
  
  private Subject subject;
  
  private Teacher teacher;
  
  private String classCode;
  
  private String className;
  
  private String dateFrom;
  
  private String dateTo;
  
  private List<Student> listStudentsDto;
  
}
