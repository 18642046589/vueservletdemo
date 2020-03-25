package com.neuedu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.dao.IUserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.exception.DbException;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
/**
 * 实现类里去调用 dao
 * @author t460p
 *
 */
public class UserServiceImpl implements IUserService {
	IUserDao userDao=new UserDaoImpl();
	@Override
	public int save(User user) throws DbException, SQLException {
		//省略验证的过程 
		//如果涉及存储的，就调用 dao进行存储
		int result=userDao.save(user);
		return result;
	}

	@Override
	public User getUserByName(String username) throws DbException, SQLException{
		User u=userDao.getUserByName(username);
		return u;
	}

	@Override
	public int updateUser(User user) throws DbException, SQLException {
		int result=userDao.updateUser(user);
		return result;
	}

	@Override
	public List<User> findAll() throws DbException, SQLException {
		return userDao.findAll();
	}

	@Override
	public int count() throws DbException, SQLException {
		return userDao.count();
	}

	@Override
	public List<User> findAll(int pageSize, int currentPage) throws DbException, SQLException {
		// TODO Auto-generated method stub
		 return userDao.findAll(pageSize,currentPage);
	}

	@Override
	public int delByIds(String[] ids) throws DbException, SQLException {
		// TODO Auto-generated method stub
		 return userDao.delByIds(ids);
	}

}
