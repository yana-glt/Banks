package exception_handlers;

public class AccountAlreadyBlockedException extends Exception {
	private static final long serialVersionUID = 1L;
	private String desc;

	public AccountAlreadyBlockedException(String desc, String mess) {
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
