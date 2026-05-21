package juegolucha.fabricas;

import juegolucha.decoradores.MagoDecorator;
import juegolucha.personajes.Personaje;
import juegolucha.personajes.PersonajeBase;

// Fábrica concreta de Mago: personaje base + decorator de mago.
public class CreadorMago extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new MagoDecorator(new PersonajeBase(nombre + " (Mago)"));
    }
}
