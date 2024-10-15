package hotel;

public class Payments {
	
	private String userName ;
    private String paymentEmail ;
    private String country;
	private String city ;
    private String cardtype;
    private String cardNumber;
	private String cardExp;
    private String cardCVV;
	public Payments() {
		super();
		
	}
	public Payments(String userName, String paymentEmail, String country, String city, String cardtype,
			String cardNumber, String cardExp, String cardCVV) {
		super();
		this.userName = userName;
		this.paymentEmail = paymentEmail;
		this.country = country;
		this.city = city;
		this.cardtype = cardtype;
		this.cardNumber = cardNumber;
		this.cardExp = cardExp;
		this.cardCVV = cardCVV;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPaymentEmail() {
		return paymentEmail;
	}
	public void setPaymentEmail(String paymentEmail) {
		this.paymentEmail = paymentEmail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExp() {
		return cardExp;
	}
	public void setCardExp(String cardExp) {
		this.cardExp = cardExp;
	}
	public String getCardCVV() {
		return cardCVV;
	}
	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
    
    
    

}
