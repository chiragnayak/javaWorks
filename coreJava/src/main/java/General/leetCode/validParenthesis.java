package General.leetCode;

import java.util.ArrayList;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 * 
 *
 */
public class validParenthesis {
	
	public boolean isValid(String s) {
	        
	        char [] arr = s.toCharArray();
	        
	        ArrayList<Character> stack = new ArrayList<>();
	        
	        int p=0;
	        int q=0;
	        int r=0;
	        int pos = 0;
	        while(pos < arr.length){
	            
	            if(arr[pos]=='('){
	                stack.add('(');
	            }else if(arr[pos]=='{'){
	               stack.add('{');
	            }else if(arr[pos]=='['){
	               stack.add('[');
	            }else if (stack.size()!=0){
	                
	                if(arr[pos]==']'){
	                    if(stack.get(stack.size()-1)!='[') return false;
	                     else stack.remove(stack.size()-1);
	                }else if(arr[pos]==')'){
	                   if(stack.get(stack.size()-1)!='(') return false;
	                    else stack.remove(stack.size()-1);
	                }else if(arr[pos]=='}'){
	                   if(stack.get(stack.size()-1)!='{') return false;
	                    else stack.remove(stack.size()-1);
	                }
	            }else {
	                return false;
	            } 
	            
	            pos++;
	        }
	        
	        return stack.size()==0 ? true : false;
	        
	    }

}
