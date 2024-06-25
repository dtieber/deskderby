package com.dd.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.dd.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamMapperTest {

  @Autowired
  private TeamMapper teamMapper;

  @Test
  void givenTeam_whenFoundById_thenTeamIsReturned() {
    String myTeamName = "myTeam-".concat(Long.toString(System.currentTimeMillis()));
    Long id = teamMapper.insert(myTeamName);

    Team team = teamMapper.findById(id);

    assertEquals(myTeamName, team.getName());
  }

  @Test
  void givenTeamname_whenTeamInserted_thenIdIsReturned() {
    String myTeamName = "myTeam-".concat(Long.toString(System.currentTimeMillis()));

    Long id = teamMapper.insert(myTeamName);

    assertNotNull(id);
  }
}
