package exception;

public class SpringException extends RuntimeException{
	private String exceptionMsg;
	public SpringException(){}
	public SpringException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}