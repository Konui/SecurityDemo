package cn.kion.kionhub.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Author Kion
 * @Date 2020-08-23 16:26
 */
@Data
public class User {
    private Long id;
    private String name;
    private String userName;
    private String pwd;
    private String mail;
    private String headImg;
    private Date createTime;
    private Integer status;
}
