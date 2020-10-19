package com.rui.zipcode;

public class ZipCode {
	  private int lower_bound;
	  private int upper_bound;

	  public ZipCode(int lower_bound, int upper_bound) {
	    this.lower_bound = lower_bound;
	    this.upper_bound = upper_bound;
	  }

	  public int getLower_bound() {
	    return lower_bound;
	  }

	  public void setLower_bound(int lower_bound) {
	    this.lower_bound = lower_bound;
	  }

	  public int getUpper_bound() {
	    return upper_bound;
	  }

	  public void setUpper_bound(int upper_bound) {
	    this.upper_bound = upper_bound;
	  }

	@Override
	public String toString() {
		return "[" + String.format("%05d", lower_bound) + ", " + String.format("%05d", upper_bound) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lower_bound;
		result = prime * result + upper_bound;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCode other = (ZipCode) obj;
		if (lower_bound != other.lower_bound)
			return false;
		if (upper_bound != other.upper_bound)
			return false;
		return true;
	}
	
	

	}