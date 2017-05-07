package com.javalec.spring2_pjt.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.spring2_pjt.model.board.dto.BoardVo;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void create(BoardVo vo) throws Exception {
		sqlSession.insert("board.insert",vo);
	}

	@Override
	public BoardVo read(int bno) throws Exception {
		
		return sqlSession.selectOne("board.view",bno);
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		sqlSession.update("board.updateArticle",vo);
	}

	@Override
	public void delete(int bno) throws Exception {

	}

	@Override
	public List<BoardVo> listAll(String search_option,String keyword) throws Exception {
		Map<String,String> map = 
				new HashMap<String,String>();
		
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		return sqlSession.selectList("board.listAll",map);
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		sqlSession.update("board.increaseCount",bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map = 
				new HashMap<String,String>();
		
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		return sqlSession.selectOne("board.countArticle",map);
	}

}
