package huy.mywebapp.beans;

public class ProductFilterCondition {
	private String name;
	private int type;
	private int min;
	private int max;
	private boolean bestSaler;

	
	public ProductFilterCondition(String name, int type, int min, int max, boolean bestSaler) {
		this.name = name;
		this.type = type;
		this.min = min;
		this.max = max;
		this.bestSaler = bestSaler;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public boolean isBestSaler() {
		return bestSaler;
	}

	public void setBestSaler(boolean bestSaler) {
		this.bestSaler = bestSaler;
	}
}
