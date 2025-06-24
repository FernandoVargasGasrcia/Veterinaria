public class Gato extends Mascota{
    public Gato(String nombre, int edad) {
        super(nombre,edad);
        this.tipo="gato";
    }

    @Override
    public String emitirSonido() {
        return "Meow Meow";
    }
}
