package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.OrderMapper;
import com.xxt.entity.Order;
import com.xxt.entity.OrderQuery;
import com.xxt.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;

	@Override
	public Pagination getOrderListWithPage(OrderQuery orderQuery) {
		return new Pagination(orderQuery.getPageNo(), orderQuery.getPageSize(), orderMapper.getOrderCount(orderQuery), orderMapper.getOrderListWithPage(orderQuery));
	}

	@Override
	public Order getOrderById(Integer id) {
		return orderMapper.getOrderById(id);
	}

	@Override
	public List<Order> getOrderList() {
		return orderMapper.getOrderList();
	}

	@Override
	public void updateOrder(Order order) {
		orderMapper.updateOrder(order);
	}

	@Override
	public void saveOrder(Order order) {
		orderMapper.saveOrder(order);
	}

	@Override
	public void deleteOrderById(Integer id) {
		orderMapper.deleteOrderById(id);
	}
}
