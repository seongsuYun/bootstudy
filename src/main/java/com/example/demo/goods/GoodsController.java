package com.example.demo.goods;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.common.SessionUtil;
import com.example.demo.member.vo.MemberVo;

@Controller
@SessionAttributes("USER_SESSION")
public class GoodsController {

	@Autowired
	private GoodsService service;
	
	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public String list(Model model, @RequestParam Map<String, Object> param, HttpServletRequest request) throws Exception {
		model.addAttribute("list", service.getGoodsList(param));
		return "goods/list";
	}

	@RequestMapping(value = "/goods/detail", method = RequestMethod.GET)
	public String detail(Model model, HttpServletRequest request) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("goodsSeq", request.getParameter("goodsSeq"));
		param.put("email", SessionUtil.getUser().getEmail());
		
		model.addAllAttributes(service.getGoodsDetail(param));
		
		return "goods/detail";
	}
	
	@RequestMapping(value = "/goods/commentList", method = RequestMethod.GET)
	public String commentList(Model model, HttpServletRequest request) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("goodsSeq", request.getParameter("goodsSeq"));
		
		model.addAttribute("commentList", service.getGoodsCommentList(param));
		return "goods/commentList";
	}
	
	@RequestMapping(value = "/goods/write", method = RequestMethod.GET)
	public String write(Model model, Map<String, Object> param) throws Exception {
		return "goods/write";
	}
	
	@RequestMapping(value = "/goods/write", method = RequestMethod.POST)
	public String writeProc(Model model, @RequestParam("filename") MultipartFile mFile, MultipartHttpServletRequest request, @ModelAttribute("USER_SESSION") MemberVo memberVo) throws Exception {
		String imgName = mFile.getOriginalFilename();
		String uploadDir = request.getServletContext().getRealPath("upload/");
		
		
		mFile.transferTo(new File(uploadDir+imgName));
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", memberVo.getEmail());
		param.put("goodsName", request.getParameter("goodsName"));
		param.put("contents", request.getParameter("contents"));
		param.put("imgName", imgName);
		
		service.addGoods(param);
		return "redirect:/goods/list";
	}
	
	@RequestMapping(value = "/goods/addGoodsComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addGoodsComment(Model model, @RequestParam Map<String, Object> param, HttpServletRequest request) throws Exception {
		param.put("email", SessionUtil.getUser().getEmail());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultCode", Boolean.TRUE);
		resultMap.put("resultMessage", "저장완료");
		
		service.addGoodsComment(param);
		
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goods/deleteGoodsComment", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteGoodsComment(Model model, @RequestParam Map<String, Object> param, HttpServletRequest request) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultCode", Boolean.TRUE);
		resultMap.put("resultMessage", "삭제완료");
		
		int commentSeq = Integer.valueOf((String)param.get("commentSeq"));
		
		service.deleteGoodsComment(commentSeq);
		
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
}