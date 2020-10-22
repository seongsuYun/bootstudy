package com.example.demo.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.SessionUtil;
import com.example.demo.member.vo.MemberVo;

@Service
public class GoodsService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private GoodsMapper mapper; 

	public List<Map<String, Object>> getGoodsList(Map<String, Object> param) throws Exception {
		param.put("email", SessionUtil.getUser().getEmail());
		return mapper.getGoodsList(param);
	}
	
	@Transactional
	public void addGoods(Map<String, Object> param) throws Exception {
		int goodsSeq = mapper.getGoodsSeq();
		int imgSeq = mapper.getGoodsFileSeq();
		
		param.put("goodsSeq", goodsSeq);
		param.put("imgSeq", imgSeq);
		
		mapper.addGoods(param);
		mapper.addGoodsFile(param);
	}
	
	public Map<String, Object> getGoodsDetail(Map<String, Object> param) throws Exception {
		int goodsSeq = Integer.valueOf((String)param.get("goodsSeq"));
		
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("goodsDetail", mapper.getGoodsDetail(goodsSeq));
		
		mapper.addGoodsReadCount(param);
		
		return returnValue; 
	}
	
	public List<Map<String, Object>> getGoodsCommentList(Map<String, Object> param) throws Exception {
		int goodsSeq = Integer.valueOf((String)param.get("goodsSeq"));
		return mapper.getGoodsComment(goodsSeq); 
	}
	
	public void addGoodsComment(Map<String, Object> param) throws Exception {
		int commentSeq = mapper.getGoodsCommentSeq();
		param.put("commentSeq", commentSeq);
		mapper.addGoodsComment(param);
	}
	
	public void updateGoodsComment(Map<String, Object> param) throws Exception {
		mapper.updateGoodsComment(param);
	}

	public void deleteGoodsComment(int param) throws Exception {
		mapper.deleteGoodsComment(param);
	}
}
