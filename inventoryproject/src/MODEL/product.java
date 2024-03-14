package MODEL;

public class product {
	private int ID;
	private String name;
	private int sellquantity;
	private float price;
	private int quantity;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSellquantity() {
		return sellquantity;
	}
	public void setSellquantity(int sellquantity) {
		this.sellquantity = sellquantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
