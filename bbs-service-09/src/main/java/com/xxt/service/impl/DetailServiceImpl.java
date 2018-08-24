package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.DetailMapper;
import com.xxt.entity.Detail;
import com.xxt.entity.DetailQuery;
import com.xxt.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	DetailMapper detailMapper;

	@Override
	public Pagination getDetailListWithPage(DetailQuery detailQuery) {
		return new Pagination(detailQuery.getPageNo(), detailQuery.getPageSize(), detailMapper.getDetailCount(detailQuery), detailMapper.getDetailListWithPage(detailQuery));
	}

	@Override
	public Detail getDetailById(Integer id) {
		return detailMapper.getDetailById(id);
	}

	@Override
	public List<Detail> getDetailList() {
		return detailMapper.getDetailList();
	}

	@Override
	public void updateDetail(Detail detail) {
		detailMapper.updateDetail(detail);
	}

	@Override
	public void saveDetail(Detail detail) {
		detailMapper.saveDetail(detail);
	}

	@Override
	public void deleteDetailById(Integer id) {
		detailMapper.deleteDetailById(id);
	}
}
