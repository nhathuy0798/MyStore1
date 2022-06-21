package huy.mywebapp.beans;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private byte[] imageData;
    private String imageFileName;
    private String base64Image;
    private boolean bestSaler;
    private int type;
    private int amountTotal;
     

    public Product() {

    }

    public Product(Long id, String name, BigDecimal price, String imageFileName, byte[] imageData , boolean isBestSaler, int type ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageData = imageData;
        this.imageFileName = imageFileName;
        this.bestSaler = isBestSaler;
        this.type = type;
    }

    public String getBase64Image() {
        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isBestSaler() {
		return bestSaler;
	}

	public void setBestSaler(boolean bestSaler) {
		this.bestSaler = bestSaler;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(int amountTotal) {
		this.amountTotal = amountTotal;
	}
		
}