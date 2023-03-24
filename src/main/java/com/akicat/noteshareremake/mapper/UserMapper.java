package com.akicat.noteshareremake.mapper;

import com.akicat.noteshareremake.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User getCheckUser(@Param("username") String username,
                             @Param("password") String password);
    public int addUser(User user);

    public User getUserFromUserId(@Param("user_id")int id);

    public int updateUserInfo(User user);

    public int updateUserPass(User user);
}
