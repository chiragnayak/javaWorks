package General.LaakMaan.LinkedLists;

public class RemoveDuplicates {
	
	public class myLinkedList {
		
		Node head = null;
		
		public void add(Node node){
			
			if(head==null){
				head = node;
				return;
			}
			
			Node temp = head;
			
			while(temp.next!=null){
				
				temp = temp.next;
			}
			
			temp.next = node;
		}
		
		public void delete(int value){
			
			if(head.value==value){
				head = head.next; //move head
			}else{
				
				Node temp = head;
				
				while(temp.next!=null){
					
					if(temp.next.value == value){
						temp.next = temp.next.next;
						return;
					}
					
					temp = temp.next;
				}
			}
		}
		
		public void removeDuplicatesI(){
			
			int position = 0;
			
			Node temp = head;
			
			while(temp!=null){
				
				int value = temp.value;
				int occurance = getPosition(value);
				System.out.println("value : "+value+" Position : "+position+" occurance : "+occurance);
				if(position!=occurance){
					delete(value);
				}else{
					position++;
				}		
				temp = temp.next;
			}
		}
		
		public void removeDuplicatesII(){
			
			//use hashtable
		}
		
		public void removeDuplicatesIII(){
			
			//use variable to store value
			//remove consicutive spaces that hold same value
		}
		
		public int getPosition(int value){
			
			Node temp = head;
			int position=0;
			
			if(temp.value==value){
				return 0;
			}
			
			while(temp.next!=null){
				
				position++;
				if(temp.next.value==value){
					return position;
				}else{
					temp = temp.next;
				}
			}
			
			return -1;
		}
		
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			
			Node temp = head;
			sb.append(temp.value+" -> ");
			while(temp.next!=null){
				
				sb.append(temp.next.value+" -> ");
				temp = temp.next;
			}
			
			return sb.append("null").toString();
			
			
		}
		
		
	}
	
	public class Node {
		
		Node next;
		int value;
		
		public Node(int val){
			this.value=val;
		}
	}
	
	public static void main(String[] args) {
		
		RemoveDuplicates rd = new RemoveDuplicates();
		
		myLinkedList LL = rd.new myLinkedList();
		LL.add(rd.new Node(1));
		LL.add(rd.new Node(2));
		LL.add(rd.new Node(3));
		LL.add(rd.new Node(4));
		LL.add(rd.new Node(5));
		LL.add(rd.new Node(1));
		LL.add(rd.new Node(1));
		LL.add(rd.new Node(6));
		LL.add(rd.new Node(2));
		LL.add(rd.new Node(7));
		LL.add(rd.new Node(1));

		
		System.out.println(LL.toString());
		
		LL.removeDuplicatesI();

		System.out.println(LL.toString());
	}

}
