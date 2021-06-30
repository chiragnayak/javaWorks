package General.lambdaFunc;

interface SuffixFunction {
	void call();
}

class PigLatin {
	public static void main(String[] args) {
		
		String word = "hello"; //although there is no keyword "final" while declaring variable "word, 
							   // BUT, as we have used "word" in a lambda expression (RHS) below
							   // compiler will consider it as "Effectively Final"
		
		//position 1 : This will give compilation error, as compiler has interpreted it as "Effectively Final"//
		//word = word + "e";
		
		SuffixFunction suffixFunc = () -> System.out.println(word + "ay");
		
		//position 2: This will give compilation error, as compiler has interpreted it as "Effectively Final"//
		//word = word + "e";
		
		/*
		 * at both position 1 and 2, i.e. irrespective of variable "word" being modified before lambda expression or after
		 * compilation error will happen as compiler has alread considered it as a Effectively final variable.
		 * 
		 * */
		
		/*
		 * 
		 * Why is that local variables are considered effectively final when they are accessed in lambda
			expressions? 
			
		 	Ans : The reason is that such mutation is not thread safe.
		 	
		 * */
		
		suffixFunc.call();
	}
}