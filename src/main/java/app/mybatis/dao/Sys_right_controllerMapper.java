package app.mybatis.dao;

import app.mybatis.entity.Sys_right_controller;
import app.mybatis.entity.Sys_right_controllerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sys_right_controllerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    long countByExample(Sys_right_controllerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int deleteByExample(Sys_right_controllerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int insert(Sys_right_controller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int insertSelective(Sys_right_controller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    List<Sys_right_controller> selectByExample(Sys_right_controllerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    Sys_right_controller selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Sys_right_controller record, @Param("example") Sys_right_controllerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Sys_right_controller record, @Param("example") Sys_right_controllerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Sys_right_controller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Sys_right_controller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyChanged(Sys_right_controller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int insertChanged(Sys_right_controller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    int insertSqlserverChanged(Sys_right_controller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right_controller
     *
     * @mbg.generated
     */
    List<Sys_right_controller> selectSqlserverByExample(Sys_right_controllerExample example);
}