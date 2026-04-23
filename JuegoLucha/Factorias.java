// Fábrica Abstracta
abstract class CreadorPersonaje {
    public abstract Personaje crearPersonaje(String nombre);
}

// Fábrica Concreta (Única)
class CreadorGuerrero extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Guerrero(nombre);
    }
}