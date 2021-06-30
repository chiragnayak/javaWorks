package General.concepts.generics;

public class Element  <T> {
	
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "-- "+value.toString()+" -- ";
	}
	
}
