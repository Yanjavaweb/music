package com.Yan.service;

/**
 * Created with IntelliJ IDEA.
 *管理员service
 * @Description:
 */
public interface AdminService {
    /**
     * 验证密码是否正确
     * @param username
     * @param password
     * @return
     */
    public boolean verifyPassword(String username,String password);
}
