<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no"/>
        <link href="/sell/bootstrap.css" rel="stylesheet">
        <title>卖家商品列表</title>
    </head>
<body>
    <div class="container">
        <div class="table-responsive text-center">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>联系人</th>
                    <th>手机号</th>
                    <th>收货地址</th>
                    <th>金额</th>
                    <th>订单状态</th>
                    <th>支付状态</th>
                    <th>创建时间</th>
                    <th>创建时间</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list orderDTOPage.content as orderDTO>
                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.buyerName}</td>
                    <td>${orderDTO.buyerPhone}</td>
                    <td>${orderDTO.buyerAddress}</td>
                    <td>${orderDTO.buyerAmount}</td>
                    <td>${orderDTO.orderStatus}</td>
                    <td>${orderDTO.payStatus}</td>
                    <td>${orderDTO.createTime}</td>
                    <td>详情</td>
                    <td>取消</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="text-right">
            <nav>
                <ul class="pagination">
                    <#if currentPage lte 1>
                        <li class="disabled">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    <#else>
                        <li>
                            <a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </#if>

                    <#if totalPages gte 8>
                        <#list 1..5 as page>
                            <#if currentPage == page>
                            <li class="disabled"><a href="#">${page}</a></li>
                            <#else>
                            <li><a href="/sell/seller/order/list?page=${page}&size=${size}">${page}</a></li>
                            </#if>
                        </#list>
                        <li class="disabled"><a href="#">...</a></li>
                        <#list (totalPages-2)..totalPages as page>
                            <#if currentPage == page>
                            <li class="disabled"><a href="#">${page}</a></li>
                            <#else>
                            <li><a href="/sell/seller/order/list?page=${page}&size=${size}">${page}</a></li>
                            </#if>
                        </#list>
                    <#else>
                        <#list 1..orderDTOPage.getTotalPages() as page>
                            <#if currentPage == page>
                            <li class="disabled"><a href="#">${page}</a></li>
                            <#else>
                            <li><a href="/sell/seller/order/list?page=${page}&size=${size}">${page}</a></li>
                            </#if>
                        </#list>
                    </#if>

                    <#if currentPage lt orderDTOPage.getTotalPages()>
                        <li>
                            <a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    <#else>
                         <li class="disabled">
                             <a href="#" aria-label="Next">
                                 <span aria-hidden="true">&raquo;</span>
                             </a>
                         </li>
                    </#if>

                </ul>
            </nav>
        </div>
    </div>
</body>
</html>

