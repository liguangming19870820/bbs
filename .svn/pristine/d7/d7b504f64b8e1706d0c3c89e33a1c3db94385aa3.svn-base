package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.ColorMapper;
import com.xxt.entity.Color;
import com.xxt.entity.ColorQuery;
import com.xxt.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	ColorMapper colorMapper;

	@Override
	public Pagination getColorListWithPage(ColorQuery colorQuery) {
		return new Pagination(colorQuery.getPageNo(), colorQuery.getPageSize(), colorMapper.getColorCount(colorQuery), colorMapper.getColorListWithPage(colorQuery));
	}

	@Override
	public Color getColorById(Integer id) {
		return colorMapper.getColorById(id);
	}

	@Override
	public List<Color> getColorList() {
		return colorMapper.getColorList();
	}

	@Override
	public void updateColor(Color color) {
		colorMapper.updateColor(color);
	}

	@Override
	public void saveColor(Color color) {
		colorMapper.saveColor(color);
	}

	@Override
	public void deleteColorById(Integer id) {
		colorMapper.deleteColorById(id);
	}

	@Override
	public List<Color> getColorByIds(Integer[] ids) {
		return colorMapper.getColorByIds(ids);
	}
}
