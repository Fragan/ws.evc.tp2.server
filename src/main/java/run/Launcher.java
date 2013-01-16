package run;

import java.rmi.RemoteException;

import servicesImpl.BroadcastUpdates;

public class Launcher {

	private BroadcastUpdates broacast;
	public Launcher() {
		
		try {
			broacast = new BroadcastUpdates("239.0.0.1", 13002);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(0);			
		}
	}
	public BroadcastUpdates getBroacast() {
		return broacast;
	}
	
	
}
