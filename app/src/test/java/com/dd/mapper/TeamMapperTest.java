package com.dd.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamMapperTest {

  @Autowired
  private TeamMapper teamMapper;


  @Test
  void givenTeamname_whenTeamInserted_thenIdIsReturned() {
    String myTeamName = "myTeam-".concat(Long.toString(System.currentTimeMillis()));

    Long id = teamMapper.insert(myTeamName);

    assertNotNull(id);
  }
}
