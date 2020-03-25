package com.neuedu.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.IGoodsDao;
import com.neuedu.exception.DbException;
import com.neuedu.pojo.Goods;
import com.neuedu.pojo.User;
import com.neuedu.utils.DButil;

public class GoodsDaoImpl implements IGoodsDao {

	@Override
	public int save(Goods goods) throws DbException, SQLException {
		//调用jdbc程序进行存储
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					//加载驱动，定义连接参数，建立连接
					conn=DButil.getConnection();
					//预处理
					ps=conn.prepareStatement("insert into t_goods values(null,?,?,?,?,?,?)");
					ps.setString(1, goods.getGoodsName());
					ps.setFloat(2, goods.getGoodsPrice());
					ps.setInt(3, goods.getGoodsNumber());
					ps.setString(4, goods.getFilename());
					ps.setInt(5,goods.getCateid());
					ps.setInt(6, goods.getVisits());
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
    //点击率
	@Override
	public List<Goods> findAll(int currentPage, int pageSize) throws DbException, SQLException {
		//调用jdbc程序进行存储
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs=null;
				List<Goods> list=new ArrayList();
				try {
					//加载驱动，定义连接参数，建立连接
					conn=DButil.getConnection();
					//预处理
					//ps=conn.prepareStatement("select * from t_goods where cateid=? ");
					ps=conn.prepareStatement("select * from t_goods where cateid<>3 order by visits limit ?,?");
					ps.setInt(1, pageSize*(currentPage-1));
					ps.setInt(2, pageSize);
					rs=ps.executeQuery();
					//循环结果集，多条用while
					while(rs.next()){
						//循环到一条，就新实例化一个user
						Goods obj=new Goods();
						obj.setId(rs.getInt("id"));
						obj.setCateid(rs.getInt("cateid"));
						obj.setFilename(rs.getString("filename"));
						obj.setGoodsName(rs.getString("goodsName"));
						obj.setGoodsNumber(rs.getInt("goodsNumber"));
						obj.setGoodsPrice(rs.getFloat("goodsPrice"));
						obj.setVisits(rs.getInt("visits"));
						//把user放入集合
						list.add(obj);
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
   //轮播图
	@Override
	public List<Goods> findByCate(int cateid) throws DbException, SQLException {
		//调用jdbc程序进行存储
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Goods> list=new ArrayList();
		try {
			//加载驱动，定义连接参数，建立连接
			conn=DButil.getConnection();
			//预处理
			ps=conn.prepareStatement("select * from t_goods where cateid=? ");
			ps.setInt(1, cateid);
			rs=ps.executeQuery();
			//循环结果集，多条用while
			while(rs.next()){
				//循环到一条，就新实例化一个user
				Goods obj=new Goods();
				obj.setId(rs.getInt("id"));
				obj.setCateid(rs.getInt("cateid"));
				obj.setFilename(rs.getString("filename"));
				obj.setGoodsName(rs.getString("goodsName"));
				obj.setGoodsNumber(rs.getInt("goodsNumber"));
				obj.setGoodsPrice(rs.getFloat("goodsPrice"));
				obj.setVisits(rs.getInt("visits"));
				//把user放入集合
				list.add(obj);
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
