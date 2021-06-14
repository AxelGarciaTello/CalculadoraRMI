
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Servidor implements Operaciones{

    @Override
    public float suma(float a, float b) throws RemoteException {
        return a+b;
    }

    @Override
    public float resta(float a, float b) throws RemoteException {
        return a-b;
    }

    @Override
    public float multiplicacion(float a, float b) throws RemoteException {
        return a*b;
    }

    @Override
    public float division(float a, float b) throws RemoteException {
        if(b == 0)
            return 0;
        return a/b;
    }
    
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registro listo.");
            System.setProperty(
                    "java.rmi.server.codebase", "file:/tmp/Operaciones/"
            );
            Servidor obj = new Servidor();
            Operaciones op = (Operaciones) UnicastRemoteObject.exportObject(
                    obj,0
            );
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Operaciones", op);
        } catch (RemoteException | AlreadyBoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
