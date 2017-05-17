import java.awt.EventQueue;

import controller.ControllerMainPage;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControllerMainPage frontController = new ControllerMainPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
