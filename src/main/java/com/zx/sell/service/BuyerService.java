package com.zx.sell.service;

import com.zx.sell.dto.OrderDTO;

public interface BuyerService {
    OrderDTO cancel(String openid, String orderId);

    OrderDTO details(String openid, String orderId);
}
