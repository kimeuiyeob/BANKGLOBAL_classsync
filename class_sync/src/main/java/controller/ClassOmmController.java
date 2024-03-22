package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.ClassOmmDto;
import service.ClassOmmService;

public class ClassOmmController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String selectedDate = request.getParameter("date");

		ClassOmmService classOmmService = new ClassOmmService();
		List<ClassOmmDto> classData = classOmmService.selectOmmInfo(selectedDate);

		response.setContentType("application/json");

		Gson gson = new Gson();
		String jsonData = gson.toJson(classData);

		response.getWriter().write(jsonData);
	}

}
