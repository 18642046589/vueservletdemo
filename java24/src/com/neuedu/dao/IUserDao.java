package com.neuedu.dao;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.User;

public interface IUserDao {

	int save(User user) throws DbException, SQLException;

	User getUserByName(String username) throws DbException, SQLException;

	int updateUser(User user) throws DbException, SQLException;

	List<User> findAll() throws DbException, SQLException;

	int count()throws DbException, SQLException;

	List<User> findAll(int pageSize, int currentPage)throws DbException, SQLException;

	int delByIds(String[] ids)throws DbException, SQLException;

}
