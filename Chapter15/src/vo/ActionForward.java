package vo;

// What? ������ ������ �����ϴ� Ŭ����
public class ActionForward {
	private String path; //�ּ�
	private boolean redirect=true;// ���(�����̷�Ʈ ����)
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
