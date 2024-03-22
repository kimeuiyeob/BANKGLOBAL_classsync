package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnecter;
import dto.ClassOmmDto;

public class ClassOmmService {

	public List<ClassOmmDto> selectOmmInfo(String date) {

		JDBConnecter JDBCon = new JDBConnecter();

		Connection connection = JDBCon.getConnection();
		ResultSet resultSet = null;
		Statement stmt;

		List<ClassOmmDto> classOmmDtoList = new ArrayList<>();

		if (connection != null) {
			System.out.println("데이터베이스 연결 성공");

			try {
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery("select * from ian.ClassOmmInfo where time like " + "'%" + date + "%'");

				while (resultSet.next()) {

					String time = resultSet.getString("time");
					String serverName = resultSet.getString("serverName");
					String aliceClass = resultSet.getString("aliceClass");
					String aliceOmm = resultSet.getString("aliceOmm");
					String allanClass = resultSet.getString("allanClass");
					String allanOmm = resultSet.getString("allanOmm");
					String aceClass = resultSet.getString("aceClass");
					String aceOmm = resultSet.getString("aceOmm");
					String classPath = resultSet.getString("classPath");
					String className = resultSet.getString("class");

					ClassOmmDto classOmmDto = new ClassOmmDto();

					classOmmDto.setTime(time);
					classOmmDto.setServerName(serverName);
					classOmmDto.setAliceClass(aliceClass);
					classOmmDto.setAllanClass(allanClass);
					classOmmDto.setAceClass(aceClass);
					classOmmDto.setAliceOmm(aliceOmm);
					classOmmDto.setAllanOmm(allanOmm);
					classOmmDto.setAceOmm(aceOmm);
					classOmmDto.setClassPath(classPath);
					classOmmDto.setClassName(className);

					classOmmDtoList.add(classOmmDto);

				}

				connection.close();
				System.out.println("데이터베이스 연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("데이터베이스 연결 실패");
		}

		return classOmmDtoList;
	}

}
