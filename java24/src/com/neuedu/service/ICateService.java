package com.neuedu.service;

import java.sql.SQLException;
import java.util.List;

import com.neuedu.exception.DbException;
import com.neuedu.pojo.Cate;

public interface ICateService {

	List<Cate> findAll()  throws DbException, SQLException;;

}
