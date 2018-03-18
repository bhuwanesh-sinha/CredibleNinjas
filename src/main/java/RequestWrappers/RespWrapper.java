package RequestWrappers;

public class RespWrapper {

	String message;
	int cn_id;

	public RespWrapper(String message, int cn_id) {
		this.message = message;
		this.cn_id = cn_id;
		
	}
	
	public int getCn_id() {
		return cn_id;
	}

	public void setCn_id(int cn_id) {
		this.cn_id = cn_id;
	}

	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
