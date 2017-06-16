package com.dao.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.dao.AccountMapper;
import com.db.ConnectionFactory;
import com.pay.domain.Account;
import com.pay.dto.AccountDto;

public class AccountDaoImpl implements AccountMapper {

	public static final String workspace = "com.dao.AccountMapper.";

	// @Resource
	// private SqlSession sqlSession;
	//

	@Resource
	private static SqlSession sqlSession = ConnectionFactory.getSession();;

	@Override
	public void commit() {
		sqlSession.commit();
		// sqlSession.close();
	}

	// @Override
	// public void setSession(SqlSession sess){
	// sqlSession = sess;
	// }

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub

		return sqlSession.delete(workspace + "deleteByPrimaryKey", id);
	}

	@Override
	public int insert(Account record) {
		// TODO Auto-generated method stub
		return sqlSession.insert(workspace + "insert", record);
	}

	@Override
	public int insertSelective(Account record) {
		// TODO Auto-generated method stub
		return sqlSession.insert(workspace + "insertSelective", record);
	}

	@Override
	public Account selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub

		return (Account) sqlSession.selectOne(workspace + "selectByPrimaryKey", id);

	}

	@Override
	public Account selectByCusCode(String id) {
		// TODO Auto-generated method stub

		return (Account) sqlSession.selectOne(workspace + "selectByCusCode", id);

	}

	@Override
	public int updateByPrimaryKeySelective(Account record) {
		// TODO Auto-generated method stub
		return sqlSession.update(workspace + "updateByPrimaryKeySelective", record);

	}

	@Override
	public int updateByPrimaryKey(Account record) {
		// TODO Auto-generated method stub
		return sqlSession.update(workspace + "updateByPrimaryKey", record);
	}

	@Override
	public ArrayList<Account> selectAll(Integer id) {
		// TODO Auto-generated method stub

		return (ArrayList<Account>) sqlSession.selectList(workspace + "selectAll", id);

	}

}
