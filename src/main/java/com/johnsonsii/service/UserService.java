package com.johnsonsii.service;


import com.johnsonsii.dao.UserDao;
import com.johnsonsii.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 增改
     * @param user
     */
    public void save(User user) {
        userDao.save(user);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
    userDao.deleteById(id);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }


    public Page<User> findPage(Integer pageNum, Integer pageSize, String name) {
        PageRequest request= PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.DESC, "create_time"));
        return userDao.findByNameLike(name, request);
    }
}
