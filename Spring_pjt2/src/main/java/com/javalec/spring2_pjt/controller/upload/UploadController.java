package com.javalec.spring2_pjt.controller.upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import oracle.net.aso.f;

@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name="uploadPath")
	String uploadPath;
	
	
	@RequestMapping(value="upload/uploadForm",method=RequestMethod.GET)
	public void uploadForm(){
		//upload/uploadForm.jsp 으로 포워딩
	}
	
	//업로드 버튼 = > 임시디렉토리 업로드
	// => 파일정보가 file에 저장
	// =>지정된 디렉토리에 저장 =>
	@RequestMapping(value="upload/uploadForm",method=RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file,ModelAndView mav) throws IOException{
		
		logger.info("파일 이름 : " + file.getOriginalFilename());
		String savedName = file.getOriginalFilename();
		logger.info("파일 크기 : " + file.getSize());
		logger.info("컨텐트 타입 : " + file.getContentType());
		
		savedName = uploadFile(savedName, file.getBytes());
		
				
		mav.setViewName("upload/uploadResult");
		mav.addObject("savedName",savedName);
		return mav;
	}
	
	//파일 이름이 중복되지 않도록 처리
	private String uploadFile(String originalName,byte[] fileData) throws IOException{
		//uuid 생성(Universal Unique IDentifier,범용 고유 식별자)
		UUID uid = UUID.randomUUID();
		String savedName=uid.toString()+"_"+originalName;
		
		File target = new File(uploadPath,savedName);
		
		//임시 디렉토리에 저장된 업로드된 파일을
		//지정된 디렉토리로 복사
		//FileCopyUtils.copy(바이트배열,타겟);
		FileCopyUtils.copy(fileData,target);
		return savedName;
	}
	
	@RequestMapping(value="upload/uploadAjax",method=RequestMethod.GET)
	public void uploadAjax(){
		
	}
	
	//produces="text/plan; charset=utf-8" : 파일의 한글처리
	@ResponseBody
	@RequestMapping(value="upload/uploadAjax",method=RequestMethod.POST,
	produces="text/plan; charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		logger.info("originalName :" + file.getOriginalFilename());
		logger.info("size :" + file.getSize());
		logger.info("contentType : " + file.getContentType());
		
		return new ResponseEntity<>(file.getOriginalFilename(),HttpStatus.OK);
	}
	
	
	
}
