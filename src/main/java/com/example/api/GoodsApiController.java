package com.example.api;

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

@RestController("/api/v1")
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
	@GetMapping(value = "/goods")
	public ResponseEntity<List<Map<String,Object>>> getGoods(@PathVariable String goodsSeq) throws Exception {
		return new ResponseEntity<List<Map<String,Object>>>(
				goodsApiMapper.getGoodsList()
				, HttpStatus.OK
		);
	}
	
	/**
	 * 상품조회 API
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
		// 삭제 서비스는 상태(세션)가 필요한 영역이므로 부적합
		// 필요시 PathVariable에 추가할수 있지만, 보안이 필요한.
		
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
}
