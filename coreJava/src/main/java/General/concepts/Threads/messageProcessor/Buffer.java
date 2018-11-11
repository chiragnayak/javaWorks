package General.concepts.Threads.messageProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Buffer implements Runnable {

	String[] filePaths;

	public static int currentBufferSize = 0;

	final static int BUFFER_SIZE = 5;

	public static Object lock = new Object();

	public Buffer(String... filePaths) {

		this.filePaths = Arrays.asList(filePaths).toArray(new String[filePaths.length]);

	}

	public static ArrayList<String> queue = new ArrayList<>();

	public void addMessage(String messageToProcess) {

		synchronized (Buffer.lock) {

			if (currentBufferSize == BUFFER_SIZE) {

				System.err.println("Buffer is Full !! Waiting For buffer to have some space.");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			queue.add(messageToProcess);
			currentBufferSize++;

		}

		

	}

	@Override
	public void run() {

		for (String filePath : filePaths) {

			try {

				BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

				String nextLine = br.readLine();

				while (nextLine != null) {

					addMessage(nextLine);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("Buffer : Message Added in buffer : Buffer Size Remaining "
							+ (Buffer.BUFFER_SIZE - currentBufferSize));

					nextLine = br.readLine();
				}

				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Complete Queue Processed !!. No Files in Queue.");

	}

}
