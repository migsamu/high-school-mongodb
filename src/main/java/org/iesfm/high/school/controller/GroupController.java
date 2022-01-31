package org.iesfm.high.school.controller;

import org.iesfm.high.school.exceptions.GroupAlreadyExistException;
import org.iesfm.high.school.exceptions.GroupsNotFoundException;
import org.iesfm.high.school.pojos.Group;
import org.iesfm.high.school.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GroupController {

    private static final Logger log = LoggerFactory.getLogger(GroupController.class);

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/groups")
    public List<Group> list() {
        List<Group> groups = new ArrayList<>();
        try {
            groups = groupService.getGroups();
        } catch (GroupsNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay grupos en este momento");
        }
        return groups;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/groups")
    public void insert(@RequestBody Group group) {
        try {
            groupService.createGroup(group);
        } catch (GroupAlreadyExistException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "");
        }
    }

}
