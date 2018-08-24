package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.FeatureMapper;
import com.xxt.entity.Feature;
import com.xxt.entity.FeatureQuery;
import com.xxt.service.FeatureService;

@Service
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	FeatureMapper featureMapper;

	@Override
	public Pagination getFeatureListWithPage(FeatureQuery featureQuery) {
		return new Pagination(featureQuery.getPageNo(), featureQuery.getPageSize(), featureMapper.getFeatureCount(featureQuery), featureMapper.getFeatureListWithPage(featureQuery));
	}

	@Override
	public Feature getFeatureById(Integer id) {
		return featureMapper.getFeatureById(id);
	}

	@Override
	public List<Feature> getFeatureList() {
		return featureMapper.getFeatureList();
	}

	@Override
	public void updateFeature(Feature feature) {
		featureMapper.updateFeature(feature);
	}

	@Override
	public void saveFeature(Feature feature) {
		featureMapper.saveFeature(feature);
	}

	@Override
	public void deleteFeatureById(Integer id) {
		featureMapper.deleteFeatureById(id);
	}

	@Override
	public List<Integer> getFeatureIdsByProId(Integer id) {
		return featureMapper.getFeatureIdsByProId(id);
	}
}
