package com.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pay.domain.Account;

public interface AccountMapper {

	public void commit();
	
	//public void setSession(SqlSession sess);
	
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    int insert(Account record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    int insertSelective(Account record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    Account selectByPrimaryKey(Integer id);
    
    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    Account selectByCusCode(String id);


    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    int updateByPrimaryKey(Account record);

    /**
     * 检索全表
     * 参数:1.传入id的最小值，取所有大于id的所有记录
     * 返回:所有记录对象
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    ArrayList<Account> selectAll(Integer id);
    
}