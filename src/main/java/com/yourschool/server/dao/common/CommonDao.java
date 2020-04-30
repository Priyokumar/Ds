package com.yourschool.server.dao.common;

import java.util.List;

import com.yourschool.server.vo.Filter;

public interface CommonDao {

	public Object findById(Long id, Class<?> clazz);

	public Object findOne(List<Filter> filters, Class<?> clazz);

	public Object findAll(Class<?> clazz);

	public Object find(List<Filter> filters, Class<?> clazz);

	public Object save(Object entity);

	public void delete(Object entity);

}
