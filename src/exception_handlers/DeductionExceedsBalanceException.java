package exception_handlers;

public class DeductionExceedsBalanceException extends Exception {
	private static final long serialVersionUID = 1L;
	private String desc;

	public DeductionExceedsBalanceException(String desc, String mess) {
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
