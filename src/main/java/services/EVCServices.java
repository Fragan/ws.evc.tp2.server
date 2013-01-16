package services;

import j3d.interfaces.universe.ICamera;
import j3d.interfaces.universe.IObject;
import j3d.interfaces.universe.ISharedUniverse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EVCServices extends Remote {

	public void update(ICamera camera) throws RemoteException;
	
	public void update(IObject object) throws RemoteException;
	
	public ISharedUniverse getSharedUniverse();
}
