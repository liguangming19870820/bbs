package com.xxt.dao;

import java.util.List;
import com.xxt.entity.Type;
import com.xxt.entity.TypeQuery;

public interface TypeMapper {

	public Type getTypeById(Integer id);
	public List<Type> getTypeListWithPage(TypeQuery typeQuery);
	public List<Type> getTypeList();
	public Integer getTypeCount(TypeQuery typeQuery);
	public void updateType(Type type);
	public void saveType(Type type);
	public void deleteTypeById(Integer id);
}
