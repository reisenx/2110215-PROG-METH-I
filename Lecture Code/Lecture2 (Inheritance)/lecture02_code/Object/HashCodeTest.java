package Object;

public class HashCodeTest {
	private int num;
	private String data;

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		// object must be Test at this point
		HashCodeTest test = (HashCodeTest) obj;
		return num == test.num
				&& (data == test.data || (data != null && data
						.equals(test.data)));
	}

	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + num;
		hash = 31 * hash + (null == data ? 0 : data.hashCode());
		return hash;
	}

	// other methods
}
