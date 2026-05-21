package juegolucha.fabricas;

import juegolucha.decoradores.GuerreroDecorator;
import juegolucha.personajes.Personaje;
import juegolucha.personajes.PersonajeBase;

// Fábrica concreta de Guerrero: personaje base + decorator de guerrero.
public class CreadorGuerrero extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new GuerreroDecorator(new PersonajeBase(nombre + " (Guerrero)"));
    }
}
