package exception_handlers;

public class AccountBlockedException extends Exception {
	private static final long serialVersionUID = 1L;
	private String desc;

	public AccountBlockedException(String desc, String mess) {
		super(mess);
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
