package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Img;
import com.xxt.entity.ImgQuery;

public interface ImgService {

	public Img getImgById(Integer id);
	public Pagination getImgListWithPage(ImgQuery imgQuery);
	public List<Img> getImgList();
	public void updateImg(Img img);
	public void saveImg(Img img);
	public void deleteImgById(Integer id);
	public Img getImgByProductId(Integer id);
}
