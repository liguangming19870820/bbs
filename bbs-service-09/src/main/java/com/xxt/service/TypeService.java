package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Type;
import com.xxt.entity.TypeQuery;

public interface TypeService {

	public Type getTypeById(Integer id);
	public Pagination getTypeListWithPage(TypeQuery typeQuery);
	public List<Type> getTypeList();
	public void updateType(Type type);
	public void saveType(Type type);
	public void deleteTypeById(Integer id);
}
