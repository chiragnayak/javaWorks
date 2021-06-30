package General.lambdaFunc;

class BlockLambda {
	interface LambdaFunction {
		String intKind(int a);
	}

	public static void main(String[] args) {
		
		//note that the signature MUST match with the declaration in Functional interface.
		LambdaFunction lambdaFunction = (int i) -> {
			
			/*NOTE : 
			 * If you use keyword inside a lambda function, it refers to the object in
			this the scope in which the lambda is defined.*/
			
			if ((i % 2) == 0)
				return "even";
			else
				return "odd";
		};
		System.out.println(lambdaFunction.intKind(10));
	}
}
