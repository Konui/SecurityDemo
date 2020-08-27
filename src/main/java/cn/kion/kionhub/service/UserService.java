package cn.kion.kionhub.service;

import cn.kion.kionhub.entity.User;

/**
 * 用户相关操作
 *
 * @Author Kion
 * @Date 2020-08-23 14:43
 */
public interface UserService {
    /**
     * 注册用户
     *
     * @Param   user
     * @Return  boolean
     *
     * @Date    2020-08-23 18:46
     */
    boolean register(User user);
    boolean login(User user);

    /**
     * 设置邮箱
     *
     * @Param   user
     * @Return  boolean
     *
     * @Date    2020-08-23 18:48
     */
    boolean setMail(User user);
    /**
     * 设置头像
     *
     * @Param   user
     * @Return  boolean
     *
     * @Date    2020-08-23 18:48
     */
    boolean setHeadImg(User user);
    /**
     * 设置密码
     *
     * @Param   user
     * @Return  boolean
     *
     * @Date    2020-08-23 18:48
     */
    boolean setPwd(User user);
    /**
     * 用户是否存在
     *
     * @Param   name
     * @Return  boolean
     *
     * @Date    2020-08-23 18:48
     */
    boolean userExist(String name);
    /**
     * 昵称是否存在
     *
     * @Param   username
     * @Return  boolean
     *
     * @Date    2020-08-23 18:48
     */
    boolean usernameExist(String username);
    /**
     * 邮箱是否使用
     *
     * @Param   mail
     * @Return  boolean
     *
     * @Date    2020-08-23 18:49
     */
    boolean mailExist(String mail);
    /**
     * 根据用户名查询用户
     *
     * @Param   user
     * @Return  cn.kion.kionhub.entity.User
     *
     * @Date    2020-08-25 16:43
     */
    User getUserByName(String name);

}
