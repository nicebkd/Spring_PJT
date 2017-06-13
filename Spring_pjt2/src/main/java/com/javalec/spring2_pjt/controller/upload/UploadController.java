package com.javalec.spring2_pjt.controller.upload;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
		
		File target = new File(uploadPath,savedName);
		
		//임시 디렉토리에 저장된 업로드된 파일을
		//지정된 디렉토리로 복사
		//FileCopyUtils.copy(바이트배열,타겟);
		FileCopyUtils.copy(file.getBytes(),target);
				
		mav.setViewName("upload/uploadResult");
		mav.addObject("savedName",savedName);
		return mav;
	}
	
	
}
