package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Feature;
import com.xxt.entity.FeatureQuery;

public interface FeatureService {

	public Feature getFeatureById(Integer id);
	public Pagination getFeatureListWithPage(FeatureQuery featureQuery);
	public List<Feature> getFeatureList();
	public void updateFeature(Feature feature);
	public void saveFeature(Feature feature);
	public void deleteFeatureById(Integer id);
	public List<Integer> getFeatureIdsByProId(Integer id);
}
