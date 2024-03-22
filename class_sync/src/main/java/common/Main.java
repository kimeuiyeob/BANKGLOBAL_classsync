package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import service.SSHCommandExecutor;

public class Main {

	public static void main(String[] args) throws JSchException, IOException {

//		SSHCommandExecutor ssh = new SSHCommandExecutor();
//		Session session = null;
//		String className = "AprvSrchSvcGetApproval";
//		String findClass = "find /home/bpimanager/apps/cbp_app/ -name \"" + className + ".class\"";
//
//		String aliceResult = "";
//		String allanResult = "";
//		String aceResult = "";
//
//		String sshAliceHost = "ssh 10.253.0.05 ";
//		String sshAllanHost = "ssh 10.253.0.13 ";
//		String sshAceHost = "ssh 10.253.0.14 ";
//
//		try {
//			session = ssh.connectSSH(session, "bpimanager", "47.88.223.58", 2202, "bpi#bs2uat");
//
//			String aliceCommand = sshAliceHost + findClass;
//			aliceResult = ssh.getSSHResponse(session, aliceCommand);
//
//			aliceResult = aliceResult.replace("/home/bpimanager/apps/cbp_app/",
//					"svn export --force https://onlinedev.banko.com.ph/svn/cbpx3/trunk/");
//			aliceResult = aliceResult.replace("/classes/", "/src-gen/");
//			aliceResult = aliceResult.replace(".class", ".java");
//			aliceResult = aliceResult.replaceAll("\\R", "");
//			aliceResult += " ./checkClassOmm/";
//			
//			System.out.println(aliceResult);
//
//			String aliceCommand2 = sshAliceHost + aliceResult;
//			aliceResult = ssh.getSSHResponse(session, aliceCommand2);
//
//			String aliceCommand3 = sshAliceHost + "cat ./checkClassOmm/" + className + ".java";
//			aliceResult = ssh.getSSHResponse(session, aliceCommand3);
//
//			System.out.println("결과 : " + aliceResult);
//
//		} catch (JSchException | IOException e) {
//			e.printStackTrace();
//		} finally {
//			ssh.disConnectSSH(session);
//		}

		List<String> nameList = new ArrayList<>();
		nameList.add("alice");
		nameList.add("allan");
		nameList.add("ace");

		nameList.remove("allan");
		System.out.println(nameList.get(0));
		System.out.println(nameList.get(1));

	}
}