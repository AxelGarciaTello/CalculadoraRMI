
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente{
    public static void  main(String[] args){
        try{
            boolean salir = false;
            while(!salir){
                Registry registry = LocateRegistry.getRegistry("localhost",1099);
                Operaciones ob = (Operaciones) registry.lookup("Operaciones");
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in)
                );
                System.out.println(
                        "***Calculadora basica***\n"
                                + "Escriba su primer número:"
                );
                float n1 = Float.parseFloat(br.readLine());
                System.out.println("Escriba su segundo número: ");
                float n2 = Float.parseFloat(br.readLine());
                System.out.println(
                        "¿Qué le gustaria hacer?\n"
                                + "\t1. Suma\n"
                                + "\t2. Resta\n"
                                + "\t3. Multiplicación\n"
                                + "\t4. División\n"
                                + "\t5. salir"
                );
                int opc = Integer.parseInt(br.readLine());
                float respuesta = 0f;
                switch(opc){
                    case 1 -> respuesta = ob.suma(n1, n2);
                    case 2 -> respuesta = ob.resta(n1, n2);
                    case 3 -> respuesta = ob.multiplicacion(n1, n2);
                    case 4 -> respuesta = ob.division(n1, n2);
                    case 5 -> salir = true;
                    default -> System.out.println("Opción incorrecta");
                }
                System.out.println("Respuesta: "+respuesta);
            }
        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
