package General.concepts.Threads.messageProcessor;

/**
 * 
 * Q -> Buffer will be receiving message at random intervals. Processor need to ensure to to keep processing the message in
 * the buffer.
 * 
 * If buffer is empty, wait for messages to appear and process them at once they arrive.
 * If buffer has more than one message, keep processing the message one by one till there are no message in buffer.
 * 
 * Buffer has a predefined size. 
 * 
 * Advanced : message will come with one priority. If high priority message comes, process that first. 
 * 
 * @author cnayak
 *
 */
public class MessageProApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		Processor processor = new Processor();
		Buffer buffer = new Buffer("C:\\Users\\cnayak\\stocksMessage.txt");
		
		Thread tBuffer = new Thread(buffer);
		Thread tProcessor = new Thread(processor);
		
		tBuffer.start();
		tProcessor.start();
		
	}

}
