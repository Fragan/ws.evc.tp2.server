package servicesImpl;

import j3d.abstraction.universe.ACamera;
import j3d.abstraction.universe.AObject;
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

	protected EVCServicesImpl (String sharedWorldName, String serverHostName, int serverRMIPort,
	          String nomGroupeUpdate, int portDiffusionUpdate) throws RemoteException {
	    super();  
		try {
	         // dans un shell, il faudrait avoir fait : remiregistry `serverRMIPort`,
	         // mais on peut avantageusement remplacer cette commande par un "createRegistry"
	         LocateRegistry.createRegistry (serverRMIPort) ;
	         Naming.rebind ("//" + serverHostName + ":" + serverRMIPort + "/" + sharedWorldName, this) ;
	         System.out.println ("Ready...") ;
	         sharedUniverse = new ASharedUniverse();
	      } catch (Exception e) {
	         System.out.println ("Problem youston") ;
	      }
	   }


	public ISharedUniverse getSharedUniverse() {
		return sharedUniverse;
	}

	@Override
	public void update(ICamera camera) throws RemoteException {
		
	}

	@Override
	public void update(IObject object) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
