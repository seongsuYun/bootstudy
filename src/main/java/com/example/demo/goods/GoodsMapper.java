package com.example.demo.goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface GoodsMapper {

	public int getGoodsSeq() throws SQLException;
	
	public int addGoods(Map<String, Object> param) throws SQLException;
	
	public int getGoodsFileSeq() throws SQLException;
	
	public int addGoodsFile(Map<String, Object> param) throws SQLException;
	
	public List<Map<String, Object>> getGoodsList(Map<String, Object> param) throws SQLException;
	
	public Map<String, Object> getGoodsDetail(int param) throws SQLException;
	
	public int addGoodsReadCount(Map<String, Object> param) throws SQLException;
	
	public List<Map<String, Object>> getGoodsComment(int param) throws SQLException;
	
	public int getGoodsCommentSeq() throws SQLException;
	
	public int addGoodsComment(Map<String, Object> param) throws SQLException;
	
	public int updateGoodsComment(Map<String, Object> param) throws SQLException;
	
	public int deleteGoodsComment(int param) throws SQLException;
}
