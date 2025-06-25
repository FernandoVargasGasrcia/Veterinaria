import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                        aniadirMascota(sc,mascotas);
                    }catch (LimiteMascotasException | IllegalArgumentException e){
                        System.out.println("-----------------------------------------");
                        System.out.println(e.getMessage());
                        System.out.println("-----------------------------------------");
                    }
                    break;
                case 2:
                    listarMascotas(mascotas);
                    break;
                case 3:
                    eliminarMascota(sc,mascotas);
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
    public static void listarMascotas(ArrayList<Mascota> mascotas) {
        if (mascotas.isEmpty()) {
            System.out.println("-----------------------------------------");
            System.out.println("Lista de mascotas vacía.");
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("Mascotas registradas:");
            for (int i = 0; i < mascotas.size(); i++) {
                Mascota mascota = mascotas.get(i);
                System.out.println(i + " - " + mascota); // toString() se usa aquí
                mascota.emitirSonido(); // Llama al sonido según si es Perro o Gato
            }
            System.out.println("-----------------------------------------");
        }
    }
    //metodo para añadir una mascora, pide el scanner para ingresar datos y la lista de mascotas
    public static void aniadirMascota(Scanner sc,ArrayList<Mascota> mascotas) throws InputMismatchException,IllegalArgumentException,LimiteMascotasException {
        //el sistema no permite añadir mas mascotas si ya hay 10 en la lista
        if(mascotas.size()==10){
            throw new LimiteMascotasException("ERR: No se pueden tener mas de 10 mascotas");
        }
        //si hay menos de 10, esto es lo que se ejecuta:

        //inicializacion de las variables para crear el objeto de mascota
        int edad=0;
        String nombre="";

        System.out.println("-----------------------------------------");
        //limpia el bufer para evitar errores al ingresar datos
        sc.nextLine();

        //se piden los datos y se añaden a la variable correspondiente
        System.out.print("Ingrese el nombre de la mascota: ");
        nombre = sc.nextLine();
        if(nombre.trim().isEmpty()){
            throw new IllegalArgumentException("ERR: El nombre de la mascota no puede ser vacio");
        }
        System.out.print("Ingrese la edad de la mascota: ");
        edad = sc.nextInt();
        //si la edad es menor a 1 (0 o negativo) se lanza la excepcion y se cancela la creacion de mascota
        if(edad<=0){
            throw new IllegalArgumentException("ERR: La edad de la mascota no puede ser negativo");
        }else if(edad>50){
            throw new IllegalArgumentException("ERR: La edad ingresada no puede ser mayor que 50 (¿¡En serio existe un perro o un gato TAN viejo!?");
        }
        //pide el tipo de mascota segun las instrucciones dadas:
        System.out.println("Ingrese el tipo de mascota:\n1-Perro\n2-Gato");
        System.out.print("Seleccione una opcion:");
        int tipo = sc.nextInt();

        //crea y añade a la lista el tipo de mascota correspondiente a la opcion seleccionada
        switch(tipo){
            case 1:
                mascotas.add(new Perro(nombre,edad));
                System.out.println("----------------------------------------");
                System.out.println("El perro "+nombre+" ha sido agregado con exito");
                System.out.println("----------------------------------------");
                break;
            case 2:
                mascotas.add(new Gato(nombre,edad));
                System.out.println("----------------------------------------");
                System.out.println("El gato "+nombre+" ha sido agregado con exito");
                System.out.println("----------------------------------------");
                break;
            default:
                throw new IllegalArgumentException("ERR: Tipo de mascota invalido");
        }
    }
    //metodo para eliminar mascota
    public static void eliminarMascota(Scanner sc, ArrayList<Mascota> mascotas) {
        if (mascotas.isEmpty()) {
            System.out.println("-----------------------------------------");
            System.out.println("Lista de mascotas vacia.");
            System.out.println("----------------------------------------");
        } else {
            listarMascotas(mascotas);
            int indice = -1;
            sc.nextLine();
            System.out.println("Ingrese la mascota que desea eliminar: ");
            indice = sc.nextInt();
            try {
                mascotas.remove(indice);
                System.out.println("----------------------------------------");
                System.out.println("La mascota ha sido eliminada con exito");
                System.out.println("----------------------------------------");
            }catch (IndexOutOfBoundsException e){
                System.out.println("----------------------------------------");
                System.out.println("ERR: No existe una mascota registrada con ese indice");
                System.out.println("----------------------------------------");
            }
        }
    }
}


