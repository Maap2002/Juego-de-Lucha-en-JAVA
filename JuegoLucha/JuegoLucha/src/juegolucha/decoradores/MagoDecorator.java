package juegolucha.decoradores;

import juegolucha.personajes.Personaje;
import juegolucha.terminal.Terminal;

/**
 * Decorator concreto de Mago.
 * Magia: multiplica el daño de ataque.
 * Fragilidad: empieza con menos HP.
 */
public class MagoDecorator extends PersonajeDecorator {
    private static final double MULTIPLICADOR_MAGICO = 1.5;
    private static final int HP_INICIAL_MAGO = 90;
    private static final int HP_BASE = 100;

    public MagoDecorator(Personaje personaje) {
        super(personaje);
        personajeDecorado.recibirDano(HP_BASE - HP_INICIAL_MAGO);
    }

    @Override
    public void atacar(Personaje oponente) {
        int danoBase = generarDanoBase();
        int danoMagico = (int) Math.round(danoBase * MULTIPLICADOR_MAGICO);
        oponente.recibirDano(danoMagico);
        Terminal.println(getNombre() + " lanza un hechizo contra " + oponente.getNombre()
                + " y causa " + danoMagico + " puntos de daño mágico.");
    }

    public double getMultiplicadorMagico() {
        return MULTIPLICADOR_MAGICO;
    }

    public int getHpInicialMago() {
        return HP_INICIAL_MAGO;
    }
}
