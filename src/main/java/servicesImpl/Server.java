package servicesImpl;

import j3d.abstraction.universe.ASharedUniverse;
import j3d.interfaces.universe.ISharedUniverse;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject {

	private static final long serialVersionUID = -2752486228990221680L;

	private ISharedUniverse sharedUniverse;

	public Server(String sharedWorldName, String serverHostName,
			int serverRMIPort, String nomGroupeUpdate, int portDiffusionUpdate)
			throws RemoteException {
		super();
		sharedUniverse = new ASharedUniverse(sharedWorldName);
		try {
			// dans un shell, il faudrait avoir fait : remiregistry
			// `serverRMIPort`,
			// mais on peut avantageusement remplacer cette commande par un
			// "createRegistry"
			LocateRegistry.createRegistry(serverRMIPort);
			Naming.rebind("//" + serverHostName + ":" + serverRMIPort + "/"
					+ sharedWorldName, sharedUniverse);
			System.out.println("Ready...");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Problem youston");
		}
	}

}
