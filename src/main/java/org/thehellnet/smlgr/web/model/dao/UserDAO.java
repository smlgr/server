package org.thehellnet.smlgr.web.model.dao;

import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.User;

/**
 * Created by sardylan on 19/05/15.
 */
@Repository
public class UserDAO extends AbstractDAO<User> {
    public UserDAO() {
        setClazz(User.class);
    }
}
