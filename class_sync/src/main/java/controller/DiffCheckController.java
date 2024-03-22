package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GetClassSource;

public class DiffCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String className = request.getParameter("className");
		String serverName = request.getParameter("serverName");

		List<String> nameList = new ArrayList<>();
		nameList.add("alice");
		nameList.add("allan");
		nameList.add("ace");

		GetClassSource getClassSource = new GetClassSource();
		String standardResult = getClassSource.sshBastionUatConnect(className, serverName);
		nameList.remove(serverName);

		String result1 = getClassSource.sshBastionUatConnect(className, nameList.get(0));
		String result2 = getClassSource.sshBastionUatConnect(className, nameList.get(1));

		standardResult = standardResult.replaceAll("\n", "<br>");
		standardResult = standardResult.replaceAll("\\*", "");

		result1 = result1.replaceAll("\n", "<br>");
		result1 = result1.replaceAll("\\*", "");

		result2 = result2.replaceAll("\n", "<br>");
		result2 = result2.replaceAll("\\*", "");

		request.setAttribute("standardResult", standardResult);
		request.setAttribute("standardName", serverName);

		request.setAttribute("result1", result1);
		request.setAttribute("result1Name", nameList.get(0));

		request.setAttribute("result2", result2);
		request.setAttribute("result2Name", nameList.get(1));

		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/diffCheck.jsp");
		dispatcher.forward(request, response);

	}

}
