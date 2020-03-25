package com.neuedu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.dao.ICateDao;
import com.neuedu.dao.impl.CateDaoImpl;
import com.neuedu.exception.DbException;
import com.neuedu.pojo.Cate;
import com.neuedu.service.ICateService;

public class CateServiceImpl implements ICateService {
   ICateDao cateDao=new CateDaoImpl();
	@Override
	public List<Cate> findAll() throws DbException, SQLException {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

}
