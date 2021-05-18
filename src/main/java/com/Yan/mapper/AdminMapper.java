package com.Yan.mapper;


import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *管理员mapper
 * @Description:
 */
@Repository
public interface AdminMapper {
    /**
     * 验证密码是否正确
     * @param username
     * @param password
     * @return
     */
    public Integer verifyPassword(String username,String password);
}
