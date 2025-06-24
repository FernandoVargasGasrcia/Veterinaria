public abstract class Mascota {

    protected String nombre;
    protected int edad;
    protected String tipo;

    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = "";

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract String emitirSonido();
    public String toString(){
        String info="";
        info+="Nombre: "+nombre+"\n";
        info+="Edad: "+edad+"\n";
        info+="Tipo: "+tipo+"\n";
        info+="Sonido: "+emitirSonido()+"\n";
        return info;
    }
}
