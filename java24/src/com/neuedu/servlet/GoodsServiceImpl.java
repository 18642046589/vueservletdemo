package com.neuedu.servlet;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.dao.IGoodsDao;
import com.neuedu.exception.DbException;
import com.neuedu.pojo.Goods;
import com.neuedu.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {
IGoodsDao goodsDao=new GoodsDaoImpl();

@Override
public int save(Goods goods) throws DbException, SQLException {
	// TODO Auto-generated method stub
	return goodsDao.save(goods);
}

@Override
public List<Goods> findByCate(int i) throws DbException, SQLException {
	// TODO Auto-generated method stub
	return goodsDao.findByCate(i);
}

@Override
public List<Goods> findAll(int currentPage, int pageSize) throws DbException, SQLException {
	// TODO Auto-generated method stub
	return goodsDao.findAll(currentPage,pageSize);
}

}
