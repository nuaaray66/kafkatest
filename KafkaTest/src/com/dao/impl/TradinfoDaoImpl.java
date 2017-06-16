package com.dao.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.dao.TradinfoMapper;
import com.db.ConnectionFactory;
import com.pay.domain.Account;
import com.pay.domain.Tradinfo;

public class TradinfoDaoImpl implements TradinfoMapper {

	public static final String workspace = "com.dao.TradinfoMapper.";
	
//	@Resource
//	private SqlSession sqlSession;
	
	@Resource
	private static SqlSession sqlSession =ConnectionFactory.getSession();;


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
	public int insert(Tradinfo record) {
		// TODO Auto-generated method stub
		return sqlSession.insert( workspace + "insert", record);
	}

	@Override
	public int insertSelective(Tradinfo record) {
		// TODO Auto-generated method stub
		return sqlSession.insert( workspace + "insertSelective", record);
	}

	@Override
	public Tradinfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return (Tradinfo) sqlSession.selectOne(workspace + "selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(Tradinfo record) {
		// TODO Auto-generated method stub
		return sqlSession.update(workspace + "updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(Tradinfo record) {
		// TODO Auto-generated method stub
		return sqlSession.update(workspace + "updateByPrimaryKey", record);
	}

	@Override
	public ArrayList<Tradinfo> selectAll(Integer id) {
		// TODO Auto-generated method stub
		return (ArrayList<Tradinfo>) sqlSession.selectList(workspace + "selectAll",id);

		
	}

}
