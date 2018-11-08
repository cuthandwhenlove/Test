package com.dao.impl;

import java.lang.reflect.ParameterizedType;

import com.commons.db.JdbcTemplate;
import com.dao.GenericDao;

/**
 * Dao基类
 * 
 * @author dougang
 * 
 * @param <T>
 */
@SuppressWarnings("all")
public class GenericDaoImpl<T> implements GenericDao<T> {

	private JdbcTemplate<T> jdbcTemplate;

	public GenericDaoImpl() {
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.jdbcTemplate = new JdbcTemplate<T>(clazz);
	}

	public JdbcTemplate<T> getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate<T> jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
