package com.demo.commonspool2.pool;

import com.demo.commonspool2.entity.User;
import lombok.SneakyThrows;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * https://blog.csdn.net/yiifaa/article/details/73243598
 */
@Component
public class UserPoolWrapper {

    private final GenericObjectPool<User> pool;

    public UserPoolWrapper(@Autowired PooledObjectFactory<User> factory) {
        pool = new GenericObjectPool<>(factory);
    }

    @SneakyThrows
    public User borrow() {
        return pool.borrowObject();
    }

    public void returnObject(User user) {
        pool.returnObject(user);
    }
}
