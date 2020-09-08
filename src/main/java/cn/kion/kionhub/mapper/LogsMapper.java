package cn.kion.kionhub.mapper;

import cn.kion.kionhub.entity.Logs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Kion
 * @Date 2020-09-08 17:29
 */
@Mapper
public interface LogsMapper {
    /**
     * 查询全部日志
     *
     * @Return  java.util.List<cn.kion.kionhub.entity.Logs>
     *
     * @Date    2020-09-08 17:30
     */
    List<Logs> selectAll();
    /**
     * 新增记录
     *
     * @Param   username                用户名
     * @Param   requestUrl              请求地址
     * @Param   params                  请求参数
     * @Param   operationDescription    请求描述
     * @Return  boolean
     *
     * @Date    2020-09-08 17:36
     */
    boolean insertLog(@Param("username")String username,@Param("requestUrl")String requestUrl,@Param("params")String params,@Param("operation_description")String operationDescription);
}
