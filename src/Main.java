import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        //lista en la cual se gurdaran las mascotas
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>(10);

        //objeto con el cual le pasaremos datos al sistema
        Scanner sc = new Scanner(System.in);

        //variable que permite que la aplicacion se ejecute en bucle
        boolean continuar = true;
        while (continuar) {
            //muestra el menu de inico
            System.out.print("Menu Sistema Veterinaria\n1-Añadir mascota\n2-Listar mascotas\n3-Borrar mascota\n4-Salir\nSeleccione una opcion:");

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
                    try {
                        añadirMascota(sc,mascotas);
                    }catch (LimiteMascotasException e){
                        System.out.println("-----------------------------------------");
                        System.out.println(e.getMessage());
                        System.out.println("-----------------------------------------");
                    }catch (IllegalArgumentException e){
                        System.out.println("-----------------------------------------");
                        System.out.println(e.getMessage());
                        System.out.println("-----------------------------------------");
                    }
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
    public static void añadirMascota(Scanner sc,ArrayList<Mascota> mascotas) throws InputMismatchException,IllegalArgumentException,LimiteMascotasException {
        if(mascotas.size()==10){
            throw new LimiteMascotasException("ERR: No se pueden tener mas de 10 mascotas");
        }
        sc.nextLine();
        int edad=0;
        String nombre="";
        System.out.print("Ingrese el nombre de la mascota: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese la edad de la mascota: ");
        edad = sc.nextInt();
        if(edad<1){
            throw new IllegalArgumentException("ERR: La edad de la mascota no puede ser negativo");
        }
        System.out.println("Ingrese el tipo de mascota:\n1-Perro\n2-Gato");
        int tipo = sc.nextInt();
        switch(tipo){
            case 1:
                mascotas.add(new Perro(nombre,edad));
                break;
            case 2:
                mascotas.add(new Gato(nombre,edad));
                break;
            default:
                throw new IllegalArgumentException("ERR: Tipo de mascota invalido");
        }
    }

}
