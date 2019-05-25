class Printer {

	synchronized void printDocs(int numberOfCopies, String docName) {
		for (int i = 0; i <= numberOfCopies; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("£££ Printing " + docName + " " + i);
		}
	}
}

class MyThread extends Thread {
	Printer _p1;

	MyThread(Printer p1) {
		_p1 = p1;
	}

	@Override
	public void run() {
		_p1.printDocs(7, "maria's docs");

	}
}

class YourThread extends Thread {
	Printer _p2;

	YourThread(Printer p2) {
		_p2 = p2;
	}

	@Override
	public void run() {
		_p2.printDocs(3, "kleopatra's docs");

	}
}

public class Application {

	public static void main(String[] args) {

		System.out.println("Application Started");

		Printer printer = new Printer();
		printer.printDocs(4, "sarandis Memories");

		MyThread my = new MyThread(printer);
		
		YourThread your = new YourThread(printer);
		my.start();
//		try {
//			my.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		your.start();
		
		System.out.println("Application Finished");

	}
}
