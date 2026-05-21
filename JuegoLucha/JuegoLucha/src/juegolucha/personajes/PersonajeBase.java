package juegolucha.personajes;

// Personaje base sin habilidades especiales. Las habilidades se agregan con Decorator.
public class PersonajeBase extends Personaje {
    public PersonajeBase(String nombre) {
        super(nombre);
    }
}
