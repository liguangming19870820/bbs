package com.xxt.dao;

import java.util.List;
import com.xxt.entity.Img;
import com.xxt.entity.ImgQuery;

public interface ImgMapper {

	public Img getImgById(Integer id);
	public List<Img> getImgListWithPage(ImgQuery imgQuery);
	public List<Img> getImgList();
	public Integer getImgCount(ImgQuery imgQuery);
	public void updateImg(Img img);
	public void saveImg(Img img);
	public void deleteImgById(Integer id);
	public Img getImgByProductId(Integer productId);
	public void deleteImgByProductId(Integer productId);
}
