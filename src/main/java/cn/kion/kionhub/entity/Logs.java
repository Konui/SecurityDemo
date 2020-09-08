package cn.kion.kionhub.entity;

import lombok.Data;

/**
 * @Author Kion
 * @Date 2020-09-08 17:21
 */
@Data
public class Logs {
    Long id;
    String username;
    String requestUrl;
    String params;
    String operation;
}
