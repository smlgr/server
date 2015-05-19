package org.thehellnet.smlgr.web.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thehellnet.smlgr.web.model.User;
import org.thehellnet.smlgr.web.model.dao.UserDAO;
import org.thehellnet.smlgr.web.model.service.AbstractServiceImpl;
import org.thehellnet.smlgr.web.model.service.UserService;

/**
 * Created by sardylan on 19/05/15.
 */
@Service("UserService")
public class UserServiceImpl extends AbstractServiceImpl<User, UserDAO> implements UserService {
    @Autowired
    @Override
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
}
