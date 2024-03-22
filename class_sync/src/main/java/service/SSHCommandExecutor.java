package service;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHCommandExecutor {

	/* SSH 접속하기 */
	public Session connectSSH(Session session, String username, String host, int port, String password)
			throws JSchException {
		if (session == null || !session.isConnected()) { // 이미 연결된 세션이 없는 경우에만 연결 시도
			session = new JSch().getSession(username, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
		}
		return session;
	}

	/* 결과값을 받기 */
	public String getSSHResponse(Session session, String command) throws IOException {
		StringBuffer response = new StringBuffer();
		ChannelExec channelExec = null;
		try {
			channelExec = (ChannelExec) session.openChannel("exec");
			channelExec.setCommand(command);

			InputStream inputStream = channelExec.getInputStream();
			channelExec.connect();

			byte[] buffer = new byte[3276];
			int decodedLength;

			while ((decodedLength = inputStream.read(buffer, 0, buffer.length)) > 0) {
				response.append(new String(buffer, 0, decodedLength));
			}
		} catch (JSchException e) {
			System.out.println(e.getMessage());
		} finally {
			this.disConnectchannelExec(channelExec);
		}
		return response.toString();
	}

	/* SSH 연결 해제 */
	public void disConnectSSH(Session session) {
		if (session != null && session.isConnected()) {
			session.disconnect();
		}
	}

	/* SSH 연결 해제 */
	public void disConnectchannelExec(ChannelExec channelExec) {
		if (channelExec != null && channelExec.isConnected()) {
			channelExec.disconnect();
		}
	}
}