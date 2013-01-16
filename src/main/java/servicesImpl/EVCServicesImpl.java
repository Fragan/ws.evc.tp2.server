package servicesImpl;

import j3d.abstraction.universe.ACamera;
import j3d.abstraction.universe.AObject;
import j3d.abstraction.universe.ASharedUniverse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import services.EVCServices;

public class EVCServicesImpl extends UnicastRemoteObject implements EVCServices {

	private static final long serialVersionUID = -2752486228990221680L;
	
	private ASharedUniverse aSharesUniverse;

	protected EVCServicesImpl() throws RemoteException {
		super();
		aSharesUniverse = new ASharedUniverse();
	}

	public void update(ACamera camera) throws RemoteException {
		
	}

	public void update(AObject object) throws RemoteException {
		
	}

	public ASharedUniverse getASharedUniverse() {
		return aSharesUniverse;
	}

}
