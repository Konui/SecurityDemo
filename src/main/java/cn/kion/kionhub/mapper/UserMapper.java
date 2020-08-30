package cn.kion.kionhub.mapper;

import cn.kion.kionhub.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-08-23 16:25
 */
@Mapper
public interface UserMapper {
    /**
     * 根据id查询单个用户
     *
     * @Param   id  用户id
     * @Return  cn.kion.kionhub.entity.User
     *
     * @Date    2020-08-23 16:30
     */
    User selectUserById(@Param("id") Long id);
    /**
     * 根据昵称查询单个用户
     *
     * @Param   userName    用户昵称
     * @Return  cn.kion.kionhub.entity.User
     *
     * @Date    2020-08-23 16:30
     */
    User selectUserByUserName(@Param("userName") String userName);
    /**
     * 根据用户登录名查询单个用户
     *
     * @Param   name    用户登录名
     * @Return  cn.kion.kionhub.entity.User
     *
     * @Date    2020-08-23 16:31
     */
    User selectUserByName(@Param("name") String name);
    /**
     * 根据关键词模糊查询用户昵称
     *
     * @Param   keyword     关键词
     * @Return  java.util.List<cn.kion.kionhub.entity.User>
     *
     * @Date    2020-08-23 16:38
     */
    List<User> searchUser(@Param("keyword") String keyword);
    /**
     * 根据邮箱重置密码
     *
     * @Param   mail    邮箱
     * @Param   pwd     密码
     * @Return  boolean
     *
     * @Date    2020-08-23 16:39
     */
    boolean resetPwd(@Param("mail") String mail,@Param("password") String pwd);
    /**
     * 注册用户
     *
     * @Param   name    用户登录名
     * @Param   pwd     用户密码
     * @Return  boolean
     *
     * @Date    2020-08-23 16:35
     */
    boolean register(@Param("name") String name,@Param("username") String username,@Param("password") String pwd);
    /**
     * 用户名是否存在
     *
     * @Param   name    用户名
     * @Return  boolean
     *
     * @Date    2020-08-23 16:42
     */
    boolean isExistByName(@Param("name") String name);
    /**
     * 用户昵称是否存在
     *
     * @Param   userName    用户昵称
     * @Return  boolean
     *
     * @Date    2020-08-23 16:43
     */
    boolean isExistByUserName(@Param("userName") String userName);
    /**
     * 邮箱是否存在
     *
     * @Param   mail    邮箱
     * @Return  boolean
     *
     * @Date    2020-08-23 16:43
     */
    boolean isExistByMail(@Param("mail") String mail);
    /**
     * 设置用户昵称
     *
     * @Param   id          用户id
     * @Param   UserName    用户昵称
     * @Return  boolean
     *
     * @Date    2020-08-23 16:50
     */
    boolean setUserName(@Param("id") Long id ,@Param("username") String userName);
    /**
     * 设置头像
     *
     * @Param   id          用户id
     * @Param   headImg     头像地址
     * @Return  boolean
     *
     * @Date    2020-08-23 16:47
     */
    boolean setHeadImg(@Param("id") Long id, @Param("headImg") String headImg);
    /**
     * 设置用户邮箱
     *
     * @Param   id      用户id
     * @Param   Mail    用户邮箱
     * @Return  boolean
     *
     * @Date    2020-08-23 16:49
     */
    boolean setMail(@Param("id") Long id,@Param("mail") String mail);
    /**
     * 获取全部用户
     *
     * @Param
     * @Return  java.util.List<cn.kion.kionhub.entity.User>
     *
     * @Date    2020-08-23 16:37
     */
    List<User> getAllUser();
    /**
     * 注册用户角色，默认普通用户角色
     *
     * @Param   uid
     * @Param   rid
     * @Return  boolean
     *
     * @Date    2020-08-28 11:45
     */
    boolean registerUserRole(@Param("name")String name);




}
