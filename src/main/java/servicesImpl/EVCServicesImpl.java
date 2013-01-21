package servicesImpl;

import j3d.abstraction.universe.ASharedUniverse;
import j3d.interfaces.universe.ICamera;
import j3d.interfaces.universe.IObject;
import j3d.interfaces.universe.ISharedUniverse;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import services.EVCServices;

public class EVCServicesImpl extends UnicastRemoteObject implements EVCServices {

	private static final long serialVersionUID = -2752486228990221680L;
	
	private ISharedUniverse sharedUniverse;

	public EVCServicesImpl (String sharedWorldName, String serverHostName, int serverRMIPort,
	          String nomGroupeUpdate, int portDiffusionUpdate) throws RemoteException {
	    super();  
		try {
	         // dans un shell, il faudrait avoir fait : remiregistry `serverRMIPort`,
	         // mais on peut avantageusement remplacer cette commande par un "createRegistry"
	         LocateRegistry.createRegistry (serverRMIPort) ;
	         Naming.rebind ("//" + serverHostName + ":" + serverRMIPort + "/" + sharedWorldName, this) ;
	         System.out.println ("Ready...") ;
	         sharedUniverse = new ASharedUniverse(sharedWorldName);
	      } catch (Exception e) {
	         System.out.println ("Problem youston") ;
	      }
	   }


	public ISharedUniverse getSharedUniverse() {
		return sharedUniverse;
	}

	@Override
	public void update(ICamera camera) throws RemoteException {
		sharedUniverse.getCamera(camera.getOwnerName()).setOrientation(camera.getOrientation());
		sharedUniverse.getCamera(camera.getOwnerName()).setPosition(camera.getPosition());
	}

	@Override
	public void update(IObject object) throws RemoteException {
		sharedUniverse.getObject(object.getName()).setOrientation(object.getOrientation());
		sharedUniverse.getCamera(object.getName()).setPosition(object.getPosition());
	}

}
