package com.example.demo.Controller;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.po.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping(path="/findOrders/{userid}")
    @HystrixCommand(fallbackMethod ="findOrderfallback")  //熔断器
    public List<Order> findOrder(@PathVariable("userid")Integer userid){
        List<Order> orders=this.orderMapper.selectOrder(userid);
        return  orders;

    }
    //针对上面熔断发现的问题编写回调方法（参数和返回值一样）
    public List<Order> findOrderfallback(Integer userid ){
        List<Order> orders=new ArrayList<>();
        return  orders;
    }
}

