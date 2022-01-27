package org.iesfm.high.school.repositories;

import org.iesfm.high.school.pojos.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, Integer> {
}
