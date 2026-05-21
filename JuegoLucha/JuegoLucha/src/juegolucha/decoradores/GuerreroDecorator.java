package juegolucha.decoradores;

import juegolucha.personajes.Personaje;
import juegolucha.terminal.Terminal;

/**
 * Decorator concreto de Guerrero.
 * Espada: suma daño extra.
 * Armadura: reduce el daño recibido.
 */
public class GuerreroDecorator extends PersonajeDecorator {
    private static final int BONUS_ESPADA = 5;
    private static final double REDUCCION_ARMADURA = 0.20;

    public GuerreroDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void atacar(Personaje oponente) {
        int dano = generarDanoBase() + BONUS_ESPADA;
        oponente.recibirDano(dano);
        Terminal.println(getNombre() + " carga con espada contra " + oponente.getNombre()
                + " y causa " + dano + " puntos de daño.");
    }

    @Override
    public void recibirDano(int dano) {
        if (dano <= 0) {
            return;
        }

        int danoReducido = (int) Math.ceil(dano * (1 - REDUCCION_ARMADURA));
        Terminal.println(getNombre() + " bloquea con armadura: " + dano
                + " -> " + danoReducido + " de daño efectivo.");
        personajeDecorado.recibirDano(danoReducido);
    }

    public int getBonusEspada() {
        return BONUS_ESPADA;
    }

    public double getReduccionArmadura() {
        return REDUCCION_ARMADURA;
    }
}
