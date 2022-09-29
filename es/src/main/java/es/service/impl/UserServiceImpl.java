package es.service.impl;

import es.bean.User;
import es.dao.UserDao;
import es.dto.PageInfo;
import es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author chase
 * @date 2022/9/26 5:42 PM
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Long save(User user) {
        userDao.save(user);
        return user.getId();
    }

    @Override
    public Page<User> getPage(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNum(), pageInfo.getPageSize());
        return userDao.findAll(pageable);
    }

}
