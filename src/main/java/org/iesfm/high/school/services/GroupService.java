package org.iesfm.high.school.services;

import org.iesfm.high.school.exceptions.GroupAlreadyExistException;
import org.iesfm.high.school.exceptions.GroupsNotFoundException;
import org.iesfm.high.school.pojos.Group;
import org.iesfm.high.school.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroups() throws GroupsNotFoundException {
        return groupRepository.findAll();
    }

    public void createGroup(Group group) throws GroupAlreadyExistException {
        if (!groupRepository.existsById(group.getId())) {
            throw new GroupAlreadyExistException(group.getId());
        } else {
            groupRepository.insert(group);
        }
    }


}
