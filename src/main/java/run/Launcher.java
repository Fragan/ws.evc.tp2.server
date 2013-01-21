package run;

import java.rmi.RemoteException;

import services.EVCServices;
import servicesImpl.BroadcastUpdates;
import servicesImpl.EVCServicesImpl;

public class Launcher {

	private BroadcastUpdates broacast;
	@SuppressWarnings("unused")
	private EVCServices server;

	public Launcher() {
		try {
			server = new EVCServicesImpl("Pluton", "localhost", 1234, "jj", 1234);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		try {
			broacast = new BroadcastUpdates("239.0.0.1", 1234);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public BroadcastUpdates getBroacast() {
		return broacast;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Launcher l = new Launcher();
	}

}
