package dto;

public class ClassOmmDto {

	private int id;
	private String time;
	private String serverName;
	private String aliceClass;
	private String allanClass;
	private String aceClass;
	private String aliceOmm;
	private String allanOmm;
	private String aceOmm;
	private String classPath;
	private String className;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getAliceClass() {
		return aliceClass;
	}

	public void setAliceClass(String aliceClass) {
		this.aliceClass = aliceClass;
	}

	public String getAllanClass() {
		return allanClass;
	}

	public void setAllanClass(String allanClass) {
		this.allanClass = allanClass;
	}

	public String getAceClass() {
		return aceClass;
	}

	public void setAceClass(String aceClass) {
		this.aceClass = aceClass;
	}

	public String getAliceOmm() {
		return aliceOmm;
	}

	public void setAliceOmm(String aliceOmm) {
		this.aliceOmm = aliceOmm;
	}

	public String getAllanOmm() {
		return allanOmm;
	}

	public void setAllanOmm(String allanOmm) {
		this.allanOmm = allanOmm;
	}

	public String getAceOmm() {
		return aceOmm;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setAceOmm(String aceOmm) {
		this.aceOmm = aceOmm;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	@Override
	public String toString() {
		return "ClassOmmDto [id=" + id + ", time=" + time + ", serverName=" + serverName + ", aliceClass=" + aliceClass
				+ ", allanClass=" + allanClass + ", aceClass=" + aceClass + ", aliceOmm=" + aliceOmm + ", allanOmm="
				+ allanOmm + ", aceOmm=" + aceOmm + ", classPath=" + classPath + ", className=" + className + "]";
	}

}
