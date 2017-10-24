package boardtwo.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.BoardDao;
import boardtwo.model.BoardDto;

public class ListAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		String pageNum = request.getParameter("pageNum");  //페이지 번호
		if(pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 5;							  //페이지당 글개수
		int currentPage = Integer.parseInt(pageNum);  //페이지의 시작 글 번호
		
		int startRow = (currentPage - 1 ) * pageSize +1;
		int endRow = currentPage * pageSize;         //한페이지 마지막글 번호
		int count = 0;
		int number = 0;
		List<BoardDto> articleList = null;
		BoardDao dbPro = BoardDao.getInstance();	 //DB 연결
		count = dbPro.getArticleCount();             //전체글 개수
		if(count>0) {                                //현재페이지 글목록
			articleList = dbPro.getArticles(startRow, endRow);
		}else {
			articleList = Collections.emptyList();
		}
		number = count -(currentPage-1) * pageSize;  //글 목록에 표시할 글 번호 
		
		request.setAttribute("currentPage",new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow",new Integer(endRow));
		request.setAttribute("count",new Integer(count));
		request.setAttribute("pageSize",new Integer(pageSize));
		request.setAttribute("number",new Integer(number));
		request.setAttribute("articleList",articleList);
		
		return "/boardtwo/list.jsp";
		
	}
	

}

