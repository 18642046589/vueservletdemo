package com.neuedu.dao;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.Cate;

public interface ICateDao {

	List<Cate> findAll() throws DbException, SQLException ;

}
