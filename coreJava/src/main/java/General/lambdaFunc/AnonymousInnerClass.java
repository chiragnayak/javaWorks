package General.lambdaFunc;

//this is functional interface having only one (and only one) abstract method
interface Function {
	void call();
}

class AnonymousInnerClass {
	public static void main(String[] args) {
		
		//implementation of that abstract method is given, after using new operator and same is assigned to the 
		//reference type (of funtional interface)
		Function function = new Function() {
			public void call() {
				System.out.println("Hello world");
			}
		};
		
		// that implementation is called. 
		function.call();
	}
}