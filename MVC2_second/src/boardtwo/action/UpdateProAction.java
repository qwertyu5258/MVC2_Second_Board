package boardtwo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.BoardDao;
import boardtwo.model.BoardDto;

public class UpdateProAction implements CommandAction {


	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		String pageNum = request.getParameter("pageNum");
		
		BoardDto article = new BoardDto();    //�����͸� ó���� ��
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPass(request.getParameter("pass"));
		article.setContent(request.getParameter("content"));
		
		BoardDao dbPro = BoardDao.getInstance();  // DB ����
		int check = dbPro.updateArticle(article);
		
		//�信 ����� �Ӽ�
		
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));
		
		return "/boardtwo/updatePro.jsp";
		
		
	}
	

}
