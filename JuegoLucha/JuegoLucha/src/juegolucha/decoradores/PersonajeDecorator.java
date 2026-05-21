package juegolucha.decoradores;

import juegolucha.personajes.Personaje;

/**
 * Decorator base: envuelve un Personaje y delega su comportamiento.
 * Las subclases modifican solo lo que necesitan.
 */
public abstract class PersonajeDecorator extends Personaje {
    protected final Personaje personajeDecorado;

    public PersonajeDecorator(Personaje personaje) {
        super(personaje.getNombre());
        this.personajeDecorado = personaje;
    }

    @Override
    public void atacar(Personaje oponente) {
        personajeDecorado.atacar(oponente);
    }

    @Override
    public void recibirDano(int dano) {
        personajeDecorado.recibirDano(dano);
    }

    @Override
    public boolean estaVivo() {
        return personajeDecorado.estaVivo();
    }

    @Override
    public String getNombre() {
        return personajeDecorado.getNombre();
    }

    @Override
    public int getPuntosDeVida() {
        return personajeDecorado.getPuntosDeVida();
    }
}
