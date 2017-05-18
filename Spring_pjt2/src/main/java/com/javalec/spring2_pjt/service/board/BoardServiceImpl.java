package com.javalec.spring2_pjt.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.javalec.spring2_pjt.model.board.dao.BoardDAO;
import com.javalec.spring2_pjt.model.board.dto.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{
	

	@Inject
	BoardDAO boardDao;
	
	@Override
	public void create(BoardVo vo) throws Exception {
		String title = vo.getTitle();
		String writer = vo.getWriter();
		//태그 문자 처리(< => &lt; > =>&gt;)
		title = title.replace("<","&lt;");
		title = title.replace(">","&gt;");
		writer = writer.replace("<","&lt;");
		writer = writer.replace(">","&gt;");
		
		//공백 문자 처리 (공백=>&nbsp;)
		title = vo.getTitle().replaceAll("  ","&nbsp;&nbsp;");
		writer = vo.getWriter().replaceAll("  ","&nbsp&nbsp;;");
		//줄바꿈 처리 (\n =><br>)//textarea가 아닐때
/*		String content = vo.getContent().replaceAll("\n","<br>");
		vo.setContent(content);
		vo.setTitle(title);
		vo.setWriter(writer);*/
		boardDao.create(vo);
	}

	@Override
	public BoardVo read(int bno) throws Exception {
		return boardDao.read(bno);
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		boardDao.update(vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		
	}

	@Override
	public List<BoardVo> listAll(int start,int end,String search_option,String keyword) throws Exception {
		
		return boardDao.listAll(start,end,search_option, keyword);
	}

	@Override
	public void increaseViewcnt(int bno,HttpSession session) throws Exception {
		long update_time=0;
		//세션에 저장된 조회시간 검색
		if(session.getAttribute("update_time_"+bno) !=null){
			update_time=(long) session.getAttribute("update_time_"+bno);
		}
		//시스템 현재 시간
		long current_time = System.currentTimeMillis();
		//일정 시간이 경과 후 조회수 증가 처리
		if(current_time - update_time > 5*1000){
			boardDao.increaseViewcnt(bno);
			session.setAttribute("update_time_"+bno,current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return boardDao.countArticle(search_option, keyword);
	}

}
