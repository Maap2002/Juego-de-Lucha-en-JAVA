package juegolucha.fabricas;

import juegolucha.personajes.Normal;
import juegolucha.personajes.Personaje;

// Fábrica concreta de Normal: 100 HP y daño de 10 a 30.
public class CreadorNormal extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Normal(nombre + " (Normal)");
    }
}
