package boardtwo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.model.BoardDao;
import boardtwo.model.BoardDto;

public class ContentAction implements CommandAction {


	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
			
		//�ش� �۹�ȣ
			int num = Integer.parseInt(request.getParameter("num"));
		
			
		//�ش� ������ ��ȣ
			String pageNum = request.getParameter("pageNum");
			BoardDao dbPro = BoardDao.getInstance();
			
		//�ش� �۹�ȣ�� ���� ���ڵ�
			BoardDto article = dbPro.getArticle(num);
			
		//�信�� ����� �Ӽ�
			request.setAttribute("num", new Integer(num));
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("article", article);
			
		return "/boardtwo/content.jsp";
	}
	
			

}
