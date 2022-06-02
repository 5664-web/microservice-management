package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.po.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert int tb_order")
    void saveOrder(Order order);
    @Select("select * from tb_order where userid =#{userid}")
    List<Order> selectOrder(Integer userid);
}
