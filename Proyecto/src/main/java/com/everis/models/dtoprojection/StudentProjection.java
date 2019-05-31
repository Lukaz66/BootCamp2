package com.everis.models.dtoprojection;

import com.everis.models.Class;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "StudentProjection", types = Class.class)
@JsonPropertyOrder({ "classId", "className", "classCode", "dateFrom", "dateTo" })
public interface StudentProjection {
  
  public int getClassId();
  
  public String getClassName();
  
  public String getClassCode();
  
  public String getDateFrom();
  
  public String getDateTo();
  
  public List<StudentClassProjection> getStudentClass();

}
