package General.lambdaFunc;

/*This is functional interface*/
interface LambdaFunction {
	void call();
}

class FirstLambda {
	public static void main(String[] args) {
		
		// LambdaParameters -> LambdaBody
		// LHS : This is to match the method signature of abstract method in Functional interface. Signature MUST match.
		//		  In other words, it defines method parameters and must match with the func interface abstarct method.
		// RSH : It is lambda Expression / block, which defines what to do. This is nothing but the implementation of that 
		//		  abstract method that is defined in functional interface.
		
		
		/*a lambda function is assigned to a variable of the functional interface type LambdaFunction.*/
		LambdaFunction lambdaFunction = () -> System.out.println("Hello world");
		
		/* that implementation is invoked via a reference of Functional interface*/
		lambdaFunction.call();
	}
}
