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

import com.everis.models.Teacher;
import com.everis.services.ITeacherService;
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
@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ITeacherService teacherController;

  private Teacher teacher;

  @Test
  public void testFindAll() throws Exception {
    List<Teacher> tech = new ArrayList<>();
    given(teacherController.findAll()).willReturn(tech);

    this.mockMvc.perform(get("/api/v1.0/teachers")).andExpect(status().isOk())
        .andExpect(content().json("[]"));
  }

  @Test
  public void testFindAllNotFound() throws Exception {
    List<Teacher> teacher = new ArrayList<>();
    given(teacherController.findAll()).willReturn(teacher);

    this.mockMvc.perform(get("/api/v1.0/tech"))
        .andExpect(status().isNotFound());
  }  
  
  @Test
  public void testFindById() throws Exception {

    teacher = new Teacher();
    teacher.setTeacherId(1);
    teacher.setSchoolName("Everis");
    teacher.setGender("F");
    teacher.setFirstName("Ninos");
    teacher.setMiddleName("Ichica");
    teacher.setLastName("Nakano");
    teacher.setOtherTeacherDetail("PHP Profecional");

    given(teacherController.findById(1)).willReturn(teacher);

    this.mockMvc.perform(get("/api/v1.0/teachers/1")).andExpect(status().isOk())
        .andExpect(content()
            .json("{\"teacherId\":1,\"schoolName\":\"Everis\",\"gender\":\"F\","
                + "\"firstName\":\"Ninos\",\"middleName\":\"Ichica\",\"lastName\":\"Nakano\","
                + "\"otherTeacherDetail\":\"PHP Profecional\"}"));
  }
  
  @Test
  public void testFindByIdNotFound() throws Exception {
    given(teacherController.findById(10)).willReturn(teacher);
    this.mockMvc.perform(get("/api/v1.0/teachers/10"))
      .andExpect(status().isNotFound());
  }

  @Test
  public void testSave() throws Exception {

    teacher = new Teacher();
    teacher.setSchoolName("Everis");
    teacher.setGender("F");
    teacher.setFirstName("Ninos");
    teacher.setMiddleName("Ichica");
    teacher.setLastName("Nakano");
    teacher.setOtherTeacherDetail("PHP Profecional");

    teacherController.save(teacher);

    this.mockMvc
        .perform(
            post("/api/v1.0/teachers").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(teacher)))
        .andExpect(status().isCreated());
  }

  @Test
  public void testSaveNotFound() throws Exception {
    teacher = new Teacher();
    
    teacherController.save(teacher);

    this.mockMvc.perform(post("/api/v1.0/teachers"))
        .andExpect(status().isBadRequest());
  }  
  
  @Test
  public void testUpdate() throws Exception {

    teacher = new Teacher();
    teacher.setSchoolName("Everis");
    teacher.setGender("F");
    teacher.setFirstName("Ninos");
    teacher.setMiddleName("Ichica");
    teacher.setLastName("Nakano");
    teacher.setOtherTeacherDetail("PHP Profecional");

    teacherController.save(teacher);

    this.mockMvc
        .perform(
            put("/api/v1.0/teachers").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(teacher)))
        .andExpect(status().isNoContent());

  }
  
  @Test
  public void testUpdateNotFound() throws Exception {
    teacher = new Teacher();
    teacher.setSchoolName("Everis");
    teacher.setGender("F");
    teacher.setFirstName("Ninosasdasd");
    teacher.setMiddleName("Ichica");
    teacher.setLastName("Nakano");
    teacher.setOtherTeacherDetail("PHP Profecional");

    teacherController.update(teacher);

    this.mockMvc.perform(put("/api/v1.0/teachers"))
        .andExpect(status().isBadRequest());
  }
  
  // @Test
  // public void testPatch() throws Exception {
  //
  // teacher = new Teacher();
  // teacher.setSchoolName("Everis");
  //
  // teacherController.patch(teacher);
  //
  // this.mockMvc.perform(patch("/api/v1.0/teachers/1")
  // .contentType(MediaType.APPLICATION_JSON).content(asJsonString(teacher)))
  // .andExpect(status().isNoContent());
  //
  // }

  @Test
  public void testDelete() throws Exception {

    when(teacherController.findById(1)).thenReturn(new Teacher());

    teacherController.softDelete(1);

    verify(teacherController, times(1)).softDelete(1);

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
