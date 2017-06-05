package com.javalec.spring2_pjt.contoller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javalec.spring2_pjt.model.board.dto.BoardVo;


//@Controller //대게 뷰리턴
@RestController //대게 데이터 리턴
@RequestMapping("/sample/*")
public class SampleController {

	@RequestMapping("/hello")
	public String syHello(){
		return "Hellow World";
	}
	
	@RequestMapping("/sendVo")
	
	//@ResponseBody 객체를 json으로 변환 Controller 에서도 이걸쓰면 사용가능.
	public @ResponseBody BoardVo sendVo(){
		BoardVo vo = new BoardVo();
		vo.setBno(1);
		vo.setWriter("kim");
		vo.setContent("내용...");
		
		return vo;
	}
	
	@RequestMapping("/snedList")
	public List<BoardVo> sendList(){
		List<BoardVo> list = new ArrayList<>();
		for(int i=1; i<10; i++){
			BoardVo vo = new BoardVo();
			vo.setBno(i);
			vo.setWriter("글쓴이"+i);
			vo.setContent("내용"+i);
			list.add(vo);
		}
		return list;
	}
	
	//ResponseEntity : 데이터 + 에러메시지 전송
	@RequestMapping("sendMap")
	public ResponseEntity<Map<Integer,BoardVo>> sendMap(){
		Map<Integer,BoardVo> map = new HashMap<Integer,BoardVo>();
//		Map<Integer,BoardVo> map = null;
		
		
		for(int i=1; i<=5; i++){
			BoardVo vo = new BoardVo();
			vo.setBno(i);
			vo.setWriter("글쓴이"+i);
			vo.setContent("내용"+i);
			map.put(i,vo);
		}
//		return map;
		return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}

