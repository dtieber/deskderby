package com.dd.controller;

import com.dd.mapper.TeamMapper;
import com.dd.model.Team;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/teams")
public class TeamController {

  private final TeamMapper teamMapper;

  public TeamController(TeamMapper teamMapper) {
    this.teamMapper = teamMapper;
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Team createTeam(@RequestBody Team team) {
    try {
      Long id = teamMapper.insert(team.getName());
      team.setId(id);
      return team;
    } catch (DuplicateKeyException e) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Team already exists.");
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot create team.");
    }
  }

  private static Long guardId(String id) {
    try {
      return Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid id.");
    }
  }

  @GetMapping("/{id}")
  public Team readTeam(@PathVariable("id") String id) {
    Long parsedId = guardId(id);
    Team team = loadTeamFromDb(parsedId);
    if (team == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team does not exist.");
    }
    return team;
  }

  private Team loadTeamFromDb(Long parsedId) {
    try {
      return this.teamMapper.findById(parsedId);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot retrieve team.");
    }
  }
}
