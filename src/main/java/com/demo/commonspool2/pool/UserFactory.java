package com.demo.commonspool2.pool;

import com.demo.commonspool2.entity.User;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.springframework.stereotype.Component;

@Component
public class UserFactory extends BasePooledObjectFactory<User> {

    @Override
    public User create() throws Exception {
        return new User();
    }

    @Override
    public PooledObject<User> wrap(User obj) {
        return new DefaultPooledObject<>(obj);
    }
}
