public class Perro extends Mascota {
    public Perro(String nombre, int edad) {
        super(nombre,edad);
        this.tipo="perro";
    }

    @Override
    public String emitirSonido() {
        return "Guau Guau";
    }

}
