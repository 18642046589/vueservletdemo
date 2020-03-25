package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.ICateDao;
import com.neuedu.exception.DbException;
import com.neuedu.pojo.Cate;
import com.neuedu.pojo.User;
import com.neuedu.utils.DButil;

public class CateDaoImpl implements ICateDao {

	@Override
	public List<Cate> findAll() throws DbException, SQLException {
		//调用jdbc程序进行存储
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs=null;
				List<Cate> list=new ArrayList();
				try {
					//加载驱动，定义连接参数，建立连接
					conn=DButil.getConnection();
					//预处理
					ps=conn.prepareStatement("select * from t_cate");
				
					rs=ps.executeQuery();
					//循环结果集，多条用while
					while(rs.next()){
						//循环到一条，就新实例化一个user
						Cate cate=new Cate();
						cate.setCateId(rs.getInt("cateId"));
						cate.setCateName(rs.getString("cateName"));
						//把cate放入集合
						list.add(cate);
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
				return list;
	}
	
}
