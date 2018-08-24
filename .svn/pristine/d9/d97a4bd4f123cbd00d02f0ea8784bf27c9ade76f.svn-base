package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.AddrMapper;
import com.xxt.entity.Addr;
import com.xxt.entity.AddrQuery;
import com.xxt.service.AddrService;

@Service
public class AddrServiceImpl implements AddrService {

	@Autowired
	AddrMapper addrMapper;

	@Override
	public Pagination getAddrListWithPage(AddrQuery addrQuery) {
		return new Pagination(addrQuery.getPageNo(), addrQuery.getPageSize(), addrMapper.getAddrCount(addrQuery), addrMapper.getAddrListWithPage(addrQuery));
	}

	@Override
	public Addr getAddrById(Integer id) {
		return addrMapper.getAddrById(id);
	}

	@Override
	public List<Addr> getAddrList() {
		return addrMapper.getAddrList();
	}

	@Override
	public void updateAddr(Addr addr) {
		addrMapper.updateAddr(addr);
	}

	@Override
	public void saveAddr(Addr addr) {
		addrMapper.saveAddr(addr);
	}

	@Override
	public void deleteAddrById(Integer id) {
		addrMapper.deleteAddrById(id);
	}
}
