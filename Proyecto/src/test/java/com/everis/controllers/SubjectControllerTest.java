package com.everis.controllers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.everis.models.Subject;
import com.everis.services.ISubjectService;
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
@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ISubjectService subjectController;

  private Subject subject;

  @Test
  public void testFindAll() throws Exception {
    List<Subject> subject = new ArrayList<>();
    given(subjectController.findAll()).willReturn(subject);

    this.mockMvc.perform(get("/api/v1.0/subjects")).andExpect(status().isOk())
        .andExpect(content().json("[]"));
  }

  @Test
  public void testFindById() throws Exception {
    subject = new Subject();
    subject.setSubjectId(1);
    subject.setSubjectName("PHP");

    given(subjectController.findById(1)).willReturn(subject);

    this.mockMvc.perform(get("/api/v1.0/subjects/1")).andExpect(status().isOk())
        .andExpect(content().json("{\"subjectId\":1,\"subjectName\":\"PHP\"}"));
  }

  @Test
  public void testSave() throws Exception {
    subject = new Subject();
    subject.setSubjectName("PHP");

    subjectController.save(subject);

    this.mockMvc
        .perform(
            post("/api/v1.0/subjects").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(subject)))
        .andExpect(status().isCreated());
  }

  @Test
  public void testUpdate() throws Exception {
    subject = new Subject();
    subject.setSubjectName("PHP");

    subjectController.save(subject);

    this.mockMvc
        .perform(
            put("/api/v1.0/subjects").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(subject)))
        .andExpect(status().isNoContent());
  }

  // @Test
  // public void testPatch() {
  // fail("Not yet implemented");
  // }

  @Test
  public void testDelete() {

    when(subjectController.findById(1)).thenReturn(new Subject());

    subjectController.softdelete(1);

    verify(subjectController, times(1)).softdelete(1);

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
