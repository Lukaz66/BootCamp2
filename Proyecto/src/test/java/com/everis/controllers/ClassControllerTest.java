package com.everis.controllers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.everis.models.Class;
import com.everis.models.Subject;
import com.everis.models.Teacher;
import com.everis.services.IClassService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(ClassController.class)
public class ClassControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  IClassService classController;

  private Class clas;

  @Test
  public void testFindAll() throws Exception {
    List<Class> classes = new ArrayList<>();
    given(classController.findAll()).willReturn(classes);

    this.mockMvc.perform(get("/api/v1.0/classes")).andExpect(status().isOk())
        .andExpect(content().json("[]"));
  }
  
  @Test
  public void testFindAllNotFound() throws Exception {
    List<Class> clas = new ArrayList<>();
    given(classController.findAll()).willReturn(clas);

    this.mockMvc.perform(get("/api/v1.0/clas"))
        .andExpect(status().isNotFound());
  }  

  @Test
  public void testFindById() throws Exception {
    Subject subject = new Subject(2, "Java", 0, null);
    Teacher teacher = new Teacher(2, "BCP Center", "F", "Mikusa", "Ichica",
        "Nakano", "Java Profecional", 0, null);
    clas = new Class();
    clas.setClassId(1);
    clas.setClassCode("CL-01");
    clas.setClassName("JavaFull");
    clas.setDateFrom("02/04/2019");
    clas.setDateTo("02/05/2019");
    clas.setSubject(subject);
    clas.setTeacher(teacher);

    given(classController.findById(1)).willReturn(clas);

    this.mockMvc.perform(get("/api/v1.0/classes/1")).andExpect(status().isOk())
        .andExpect(content().json(
            "{\"classId\":1,\"classCode\":\"CL-01\",\"className\":\"JavaFull\",\"dateFrom\":"
                + "\"02/04/2019\",\"dateTo\":\"02/05/2019\",\"subject\":{\"subjectId\":2,"
                + "\"subjectName\":\"Java\"},\"teacher\":{\"teacherId\":2,\"schoolName\":"
                + "\"BCP Center\",\"gender\":\"F\",\"firstName\":\"Mikusa\",\"middleName\":"
                + "\"Ichica\",\"lastName\":\"Nakano\",\"otherTeacherDetail\":\"Java Profecional\"}"
                + "}"));
  }
  
  @Test
  public void testFindByIdNotFound() throws Exception {
    given(classController.findById(10)).willReturn(clas);
    this.mockMvc.perform(get("/api/v1.0/classes/10"))
      .andExpect(status().isNotFound());
  }

  @Test
  public void testSave() throws Exception {
    Subject subject = new Subject(2, "Java", 0, null);
    Teacher teacher = new Teacher(2, "BCP Center", "F", "Mikusa", "Ichica",
        "Nakano", "Java Profecional", 0, null);
    clas = new Class();
    clas.setClassCode("CL-01");
    clas.setClassName("JavaFull");
    clas.setDateFrom("02/04/2019");
    clas.setDateTo("02/05/2019");
    clas.setSubject(subject);
    clas.setTeacher(teacher);

    classController.save(clas);

    this.mockMvc.perform(post("/api/v1.0/classes")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(clas)))
        .andExpect(status().isCreated());
  }
  
  @Test
  public void testSaveNotFound() throws Exception {
    clas = new Class();

    classController.save(clas);

    this.mockMvc.perform(post("/api/v1.0/classes"))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void testUpdate() throws Exception {
    Subject subject = new Subject(1, "JavaScript", 0, null);
    Teacher teacher = new Teacher(1, "Everis", "M", "Lukas", "Maycol", "Llanos",
        "Programador", 0, null);

    clas = new Class();
    clas.setClassCode("CL-01");
    clas.setClassName("JavaFull");
    clas.setDateFrom("02/04/2019");
    clas.setDateTo("02/05/2019");
    clas.setSubject(subject);
    clas.setTeacher(teacher);

    classController.update(clas);

    this.mockMvc.perform(put("/api/v1.0/classes")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(clas)))
        .andExpect(status().isNoContent());
  }

  @Test
  public void testUpdateNotFound() throws Exception {
    Subject subject = new Subject(1, "JavaScript", 0, null);
    Teacher teacher = new Teacher(1, "Everis", "M", "Lukas", "Maycol", "Llanos",
        "Programador", 0, null);
    
    clas = new Class();
    clas.setClassCode("CL-01");
    clas.setClassName("JavaFullprogramador");
    clas.setDateFrom("02/04/2019");
    clas.setDateTo("02/05/2019");
    clas.setSubject(subject);
    clas.setTeacher(teacher);

    classController.update(clas);

    this.mockMvc.perform(put("/api/v1.0/classes"))
        .andExpect(status().isBadRequest());
  }
  
  
  // @Test
  // public void testPatch() {
  // fail("Not yet implemented");
  // }

  @Test
  public void testDelete() {

    when(classController.findById(1)).thenReturn(new Class());

    classController.softDelete(1);

    verify(classController, times(1)).softDelete(1);

  }

  /**
   * Metodo para convertir los Json a String.
   * 
   * @param object
   *          se da un valor como objeto.
   * @return un Json String
   */
  public static String asJsonString(Object object) {
    try {
      return new ObjectMapper().writeValueAsString(object);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
