package main.java.com.solvd.banks.products;

public enum Currency {
    EUR(978, "Euro"),
    USD(840, "US Dollar"),
    GBP(826, "Pound Sterling"),
    PLN(985, "Zloty"),
    DKK(208, "Danish Krone"),
    NOK(578, "Norwegian Krone"),
    SEK(752, "Swedish Krona"),
    CZK(203, "Czech Koruna"),
    HUF(348, "Forint"),
    GEL(981, "Lari"),
    TRY(949, "Turkish Lira"),
    CHF(756, "Swiss Franc"),
    JPY(392, "Yen"),
    CNY(156, "Yuan Renminbi");

    private final int id;
    private final String name;

	private Currency(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
