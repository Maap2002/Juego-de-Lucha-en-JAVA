// Clase concreta que hereda de Personaje
class Guerrero extends Personaje {
    public Guerrero(String nombre) {
        // Le añadimos el sufijo para identificar su clase
        super(nombre + " (Guerrero)");
    }
}