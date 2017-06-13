package com.javalec.spring2_pjt.controller.message;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javalec.spring2_pjt.model.message.dto.MessageVo;
import com.javalec.spring2_pjt.service.message.MessageService;

@RestController
@RequestMapping("/messages/*")
public class MessageController {
	
	@Inject
	MessageService messageService;

// ResponseEntity : Http Status Code(http 상태코드)
//							+데이터를 전달
//@RequestBody : 클라이언트에서 => 서버 (json 데이터가 입력될때)
//@ResponseBody : 서버 = > 클라이언트(json)	
	@RequestMapping(value="/" ,method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVo vo){
		ResponseEntity<String> entity = null;
		
		try{
			messageService.addMessage(vo);
//new ResponseEntity<자료형>(리턴값,htt status code)
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
