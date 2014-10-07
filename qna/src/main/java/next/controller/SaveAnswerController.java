package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.model.Answer;
import core.mvc.Controller;

public class SaveAnswerController implements Controller {
	private AnswerDao answerDao = new AnswerDao();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String questionId = request.getParameter("questionId");
		Answer answer = getAnswerInstance(questionId, request);
		answerDao.insert(answer);
		
		return "/show.next";
	}

	private Answer getAnswerInstance(String questionIdStr, HttpServletRequest request) {
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		long questionId = Long.parseLong(questionIdStr);
		Answer answer = new Answer(writer, contents, questionId);
		
		return answer;
	}

}
