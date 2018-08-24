package com.xxt.dao;

import java.util.List;
import com.xxt.entity.Color;
import com.xxt.entity.ColorQuery;

public interface ColorMapper {

	public Color getColorById(Integer id);
	public List<Color> getColorListWithPage(ColorQuery colorQuery);
	public List<Color> getColorList();
	public Integer getColorCount(ColorQuery colorQuery);
	public void updateColor(Color color);
	public void saveColor(Color color);
	public void deleteColorById(Integer id);
	public List<Color> getColorByIds(Integer[] ids);
}
