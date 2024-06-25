package com.dd.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TeamControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void createTeam() throws Exception {
    String myTeamName = "myTeam-".concat(Long.toString(System.currentTimeMillis()));
    mvc.perform(post("/teams")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"" + myTeamName + "\"}"))
      .andExpect(status().isCreated());
  }
}
