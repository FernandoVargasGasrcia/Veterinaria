import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //lista en la cual se guardaran las mascotas
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>(10);

        //objeto con el cual le pasaremos datos al sistema
        Scanner sc = new Scanner(System.in);

        //variable que permite que la aplicacion se ejecute en bucle
        boolean continuar = true;
        while (continuar) {
            //muestra el menu de inico
            System.out.println("Menu Sistema Veterinaria\n1-Añadir mascota\n2-Listar mascotas\n3-Borrar mascota\n4-Salir\nSeleccione una opcion:");

            //variable en la cual se registrara la opcion elegida por el usuario
            int opcion=0;

            //evita que la aplicacion falle si se ingresan valores que no sean int
            try {
                opcion = sc.nextInt();
            }catch (InputMismatchException e) {
                sc.nextLine();
            }

            //ejecuta el caso correspondiente con la opcion seleccionada
            switch (opcion){
                case 1:
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("-----------------------------------------");
                    System.out.println("ERR: Opcion no valida, intente nuevamente");
                    System.out.println("-----------------------------------------");
            }
        }

    }

}
