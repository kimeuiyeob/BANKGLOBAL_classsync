package service;

import java.io.IOException;

import com.jcraft.jsch.Session;

public class GetClassSource {

	public String sshBastionUatConnect(String className, String serverName) {

		SSHCommandExecutor ssh = new SSHCommandExecutor();
		Session session = null;

		String user = "bpimanager";
		String host = "47.88.223.58";
		int port = 2202;
		String passwd = "bpi#bs2uat";
		String result = "";

		try {
			session = ssh.connectSSH(session, user, host, port, passwd);
			if (serverName.equals("alice")) {
				result = getClassSource(ssh, session, className, "alice");
			} else if (serverName.equals("allan")) {
				result = getClassSource(ssh, session, className, "allan");
			} else if (serverName.equals("ace")) {
				result = getClassSource(ssh, session, className, "ace");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getClassSource(SSHCommandExecutor ssh, Session session, String className, String serverName) {

		String commandResult = "";
		String serverHost = "";
		String domain = "";

		if (serverName.equals("alice")) {
			serverHost = "ssh 10.253.0.05 ";
			domain = "onlinedev";
		} else if (serverName.equals("allan")) {
			serverHost = "ssh 10.253.0.13 ";
			domain = "devsdg";
		} else if (serverName.equals("ace")) {
			serverHost = "ssh 10.253.0.14 ";
			domain = "devafs";
		}

		String findClass = "find /home/bpimanager/apps/cbp_app/ -name \"" + className + ".class\"";
		String command = serverHost + findClass;

		try {
			commandResult = ssh.getSSHResponse(session, command);

			commandResult = commandResult.replace("/home/bpimanager/apps/cbp_app/",
					"svn export https://" + domain + ".banko.com.ph/svn/cbpx3/trunk/");

			commandResult = commandResult.replace("/classes/", "/src/");
			commandResult = commandResult.replace(".class", ".omm");
			commandResult = commandResult.replaceAll("\\R", "");
			commandResult += " ./checkClassOmm/";

			commandResult = serverHost + commandResult;
			commandResult = ssh.getSSHResponse(session, commandResult);
			commandResult = serverHost + "cat ./checkClassOmm/" + className + ".omm";

			commandResult = ssh.getSSHResponse(session, commandResult);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ssh.disConnectSSH(session);
		}

		return commandResult;
	}

}
