package juegolucha.fabricas;

import juegolucha.personajes.Personaje;

// Fábrica Abstracta.
public abstract class CreadorPersonaje {
    public abstract Personaje crearPersonaje(String nombre);
}
