package services;

import j3d.abstraction.universe.ACamera;
import j3d.abstraction.universe.AObject;
import j3d.abstraction.universe.ASharedUniverse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EVCServices extends Remote {

	public void update(ACamera camera) throws RemoteException;
	
	public void update(AObject object) throws RemoteException;
	
	public ASharedUniverse getASharedUniverse();
}
