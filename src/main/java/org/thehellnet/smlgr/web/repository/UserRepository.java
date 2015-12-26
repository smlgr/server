package org.thehellnet.smlgr.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.User;

/**
 * Created by sardylan on 25/12/15.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
