package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.TypeMapper;
import com.xxt.entity.Type;
import com.xxt.entity.TypeQuery;
import com.xxt.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeMapper typeMapper;

	@Override
	public Pagination getTypeListWithPage(TypeQuery typeQuery) {
		return new Pagination(typeQuery.getPageNo(), typeQuery.getPageSize(), typeMapper.getTypeCount(typeQuery), typeMapper.getTypeListWithPage(typeQuery));
	}

	@Override
	public Type getTypeById(Integer id) {
		return typeMapper.getTypeById(id);
	}

	@Override
	public List<Type> getTypeList() {
		return typeMapper.getTypeList();
	}

	@Override
	public void updateType(Type type) {
		typeMapper.updateType(type);
	}

	@Override
	public void saveType(Type type) {
		typeMapper.saveType(type);
	}

	@Override
	public void deleteTypeById(Integer id) {
		typeMapper.deleteTypeById(id);
	}
}
