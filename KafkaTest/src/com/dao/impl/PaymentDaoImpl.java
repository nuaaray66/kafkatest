package com.dao.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.dao.PaymentMapper;
import com.db.ConnectionFactory;
import com.pay.domain.Payment;
import com.pay.domain.Tradinfo;

public class PaymentDaoImpl implements PaymentMapper {
	
	public static final String workspace = "com.dao.PaymentMapper.";
	
//	@Resource
//	private SqlSession sqlSession;
//	
	@Resource
	private static SqlSession sqlSession= ConnectionFactory.getSession();
	
	

	@Override
	public void commit(){
		sqlSession.commit();
//		sqlSession.close();
	}
	
	
//	@Override
//	public void setSession(SqlSession sess){
//		sqlSession = sess;
//	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sqlSession.delete( workspace + "deleteByPrimaryKey", id);
	}

	@Override
	public int insert(Payment record) {
		// TODO Auto-generated method stub
		return sqlSession.insert( workspace + "insert", record);
	}

	@Override
	public int insertSelective(Payment record) {
		// TODO Auto-generated method stub
		return sqlSession.insert( workspace + "insertSelective", record);
	}

	@Override
	public Payment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return (Payment) sqlSession.selectOne(workspace + "selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(Payment record) {
		// TODO Auto-generated method stub
		return sqlSession.update(workspace + "updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(Payment record) {
		// TODO Auto-generated method stub
		return sqlSession.update(workspace + "updateByPrimaryKey", record);
	}

	@Override
	public ArrayList<Payment> selectAll(Integer id) {
		// TODO Auto-generated method stub
		return (ArrayList<Payment>) sqlSession.selectList(workspace + "selectAll",id);

	}

}
