import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operaciones extends Remote {
    float suma(float a, float b) throws RemoteException;
    float resta(float a, float b) throws RemoteException;
    float multiplicacion(float a, float b) throws RemoteException;
    float division(float a, float b) throws RemoteException;
}
