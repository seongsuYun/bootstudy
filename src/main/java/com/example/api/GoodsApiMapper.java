package com.example.api;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsApiMapper {

	public List<Map<String, Object>> getGoodsList() throws SQLException;
}
