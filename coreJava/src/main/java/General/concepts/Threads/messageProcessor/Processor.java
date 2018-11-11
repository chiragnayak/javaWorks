package General.concepts.Threads.messageProcessor;

public class Processor implements Runnable {

	int messageIndex = 0;

	public void processMessage(String message) {

		synchronized (Buffer.lock) {

			System.out.println("Processor : processing Message : " + messageIndex + " -> " + message
					+ ".. done... length is -> " + message.length());

			try {
				Thread.sleep(message.length() * 10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			messageIndex++;
			Buffer.currentBufferSize--;

		}

	}

	@Override
	public void run() {

		while (true) {

			if (Buffer.queue.size() != 0 && Buffer.currentBufferSize != 0) {

				String message = Buffer.queue.get(messageIndex);

				processMessage(message);

			} else {

				System.out.println("Processor : No messages in Buffer !");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
