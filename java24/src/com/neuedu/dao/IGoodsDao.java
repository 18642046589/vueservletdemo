package com.neuedu.dao;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.Goods;

public interface IGoodsDao {

	int save(Goods goods)throws DbException, SQLException;

	List<Goods> findAll(int currentPage, int pageSize)throws DbException, SQLException;

	List<Goods> findByCate(int i)throws DbException, SQLException;


}
