package juegolucha.personajes;

import java.util.Random;

import juegolucha.terminal.Terminal;

public abstract class Personaje {
    private static final int HP_INICIAL = 100;
    private static final int DANO_MAXIMO = 30;
    private static final int DANO_MINIMO = 10;
    private static final Random RANDOM = new Random();

    protected final String nombre;
    protected int puntosDeVida;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = HP_INICIAL;
    }

    public void atacar(Personaje oponente) {
        int dano = generarDanoBase();
        oponente.recibirDano(dano);
        Terminal.println(nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        if (dano <= 0) {
            return;
        }

        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }

    protected int generarDanoBase() {
        return RANDOM.nextInt((DANO_MAXIMO - DANO_MINIMO) + 1) + DANO_MINIMO;
    }
}
