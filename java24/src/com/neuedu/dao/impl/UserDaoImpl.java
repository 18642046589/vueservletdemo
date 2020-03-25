package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.neuedu.dao.IUserDao;
import com.neuedu.exception.DbException;
import com.neuedu.pojo.User;
import com.neuedu.utils.DButil;

public class UserDaoImpl implements IUserDao {

	@Override
	public int save(User user) throws DbException, SQLException {
		//调用jdbc程序进行存储
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载驱动，定义连接参数，建立连接
			conn=DButil.getConnection();
			//预处理
			ps=conn.prepareStatement("insert into t_user values(null,?,?,?,?,?,?)");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getBirthday());
			
			int num=ps.executeUpdate();
			return num;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//异常详情，给程序看的
			throw new DbException("驱动错误",999);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("数据库操作异常",999);
			
		}
		finally {
			DButil.closeDB(null, ps, conn);
		}
	}

	@Override
	public User getUserByName(String username) throws DbException, SQLException {
		//调用jdbc程序进行存储
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs=null;
				User user=null;
				try {
					//加载驱动，定义连接参数，建立连接
					conn=DButil.getConnection();
					//预处理
					ps=conn.prepareStatement("select * from t_user where username=?");
					ps.setString(1, username);
					rs=ps.executeQuery();
					if(rs.next()){
						//一定存在这个用户名的
						user=new User();
						user.setId(rs.getInt("id"));
						user.setUserName(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setRole(rs.getString("role"));
						user.setEmail(rs.getString("email"));
						user.setBirthday(rs.getString("birthday"));
						user.setPhone(rs.getString("phone"));
						
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//异常详情，给程序看的
					throw new DbException("驱动错误",999);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("数据库操作异常",999);
					
				}
				finally {
					DButil.closeDB(rs, ps, conn);
				}
				return user;
	}

	@Override
	public int updateUser(User user) throws DbException, SQLException {
		//调用jdbc程序进行存储
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					//加载驱动，定义连接参数，建立连接
					conn=DButil.getConnection();
					//预处理
					ps=conn.prepareStatement("update t_user set username=?,email=?,phone=?,birthday=? where id=?");
					ps.setString(1, user.getUserName());
					ps.setString(2, user.getEmail());
					ps.setString(3, user.getPhone());
					ps.setString(4, user.getBirthday());
					ps.setInt(5,user.getId());
					int num=ps.executeUpdate();
					return num;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//异常详情，给程序看的
					throw new DbException("驱动错误",999);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("数据库操作异常",999);
					
				}
				finally {
					DButil.closeDB(null, ps, conn);
				}
	}

	@Override
	public List<User> findAll() throws DbException, SQLException {
		//调用jdbc程序进行存储
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<User> userList=new ArrayList();
		try {
			//加载驱动，定义连接参数，建立连接
			conn=DButil.getConnection();
			//预处理
			ps=conn.prepareStatement("select * from t_user");
		
			rs=ps.executeQuery();
			//循环结果集，多条用while
			while(rs.next()){
				//循环到一条，就新实例化一个user
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
				user.setUserName(rs.getString("username"));
				//把user放入集合
				userList.add(user);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//异常详情，给程序看的
			throw new DbException("驱动错误",999);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("数据库操作异常",999);
			
		}
		finally {
			DButil.closeDB(rs, ps, conn);
		}
		return userList;
	}

	@Override
	public int count() throws DbException, SQLException {
		//调用jdbc程序进行存储
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		User user=null;
		int count=0;
		try {
			//加载驱动，定义连接参数，建立连接
			conn=DButil.getConnection();
			//预处理
			ps=conn.prepareStatement("select count(*) from t_user");
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//异常详情，给程序看的
			throw new DbException("驱动错误",999);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("数据库操作异常",999);
			
		}
		finally {
			DButil.closeDB(rs, ps, conn);
		}
		return count;
	}

	@Override
	public List<User> findAll(int pageSize, int currentPage) throws DbException, SQLException {
		//调用jdbc程序进行存储
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<User> userList=new ArrayList();
		try {
			//加载驱动，定义连接参数，建立连接
			conn=DButil.getConnection();
			//预处理
			ps=conn.prepareStatement("select * from t_user limit ?,?");
			ps.setInt(1, pageSize*(currentPage-1));
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			//循环结果集，多条用while
			while(rs.next()){
				//循环到一条，就新实例化一个user
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
				user.setUserName(rs.getString("username"));
				//把user放入集合
				userList.add(user);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//异常详情，给程序看的
			throw new DbException("驱动错误",999);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("数据库操作异常",999);
			
		}
		finally {
			DButil.closeDB(rs, ps, conn);
		}
		return userList;
	}

	@Override
	public int delByIds(String[] ids) throws DbException, SQLException {
		//调用jdbc程序进行存储
		//delete from t_user where id in ()
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					//加载驱动，定义连接参数，建立连接
					conn=DButil.getConnection();
					//预处理
					StringBuffer ss=new StringBuffer("delete from t_user where id in ")
							.append(Arrays.toString(ids).replace("[", "(").replace("]", ")"));
					System.out.println(ss.toString());
					ps=conn.prepareStatement(ss.toString());
				   int num= ps.executeUpdate();
					return num;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//异常详情，给程序看的
					throw new DbException("驱动错误",999);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("数据库操作异常",999);
					
				}
				finally {
					DButil.closeDB(null, ps, conn);
				}
	}

	
	public static void main(String[] args) {
		String[] ids={"33","34"};
		//[33, 34] --->(33, 34)
		System.out.println(Arrays.toString(ids).replace("[", "(").replace("]", ")"));
	}
}
