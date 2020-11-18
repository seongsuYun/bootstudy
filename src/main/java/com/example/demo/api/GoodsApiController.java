package com.example.demo.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.goods.GoodsService;

@RestController
public class GoodsApiController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GoodsService service;
	
	@Autowired 
	private GoodsApiMapper goodsApiMapper;
	
	/**
	 * 특정사용자의 전체상품목록 API
	 * @param goodsSeq
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/goods")
	public ResponseEntity<List<Map<String,Object>>> getGoods() throws Exception {
		return new ResponseEntity<List<Map<String,Object>>>(
				//goodsApiMapper.getGoodsList()
				this.getDummyGoods()
				, HttpStatus.OK
		);
	}
	
	/**
	 * 상품상세정보 API
	 * @param goodsSeq
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/goods/{goodsSeq}")
	public ResponseEntity<Map<String,Object>> getGoodsDetail(@PathVariable String goodsSeq) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("goodsSeq", goodsSeq);
		
		return new ResponseEntity<Map<String,Object>>(
				service.getGoodsDetail(param)
				, HttpStatus.OK
		);
	}

	/**
	 * 상품삭제 API
	 * @param goodsSeq
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(value = "/goods/{goodsSeq}")
	public ResponseEntity<String> deleteGoods(@PathVariable String goodsSeq) throws Exception {
		// 삭제API는 ForeignKey 관계로 인하여 적합하지 않음.
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	/**
	 * REST 통신 공통에러 처리
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> processException(Exception e) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("message", e.getMessage());
		
		log.error(e.getMessage());
		
		return new ResponseEntity<Map<String,Object>>(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private List<Map<String, Object>> getDummyGoods() {
		List<Map<String, Object>> dummyList = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> goods1 = new HashMap<String, Object>();
		goods1.put("goodsSeq", "1111");
		goods1.put("email", "icast4u@nate.com");
		goods1.put("goodsName", "나이키운동화");
		goods1.put("contents", "나이키운동화에 대한 설명");
		dummyList.add(goods1);
		
		Map<String, Object> goods2 = new HashMap<String, Object>();
		goods2.put("goodsSeq", "222");
		goods2.put("email", "seongsu@nate.com");
		goods2.put("goodsName", "아디다스운동화");
		goods2.put("contents", "아디다스운동화에 대한 설명");
		dummyList.add(goods2);
		
		return dummyList;
	}
}
