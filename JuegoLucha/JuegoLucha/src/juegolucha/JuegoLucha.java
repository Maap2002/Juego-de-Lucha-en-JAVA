package juegolucha;

import java.util.Scanner;

import juegolucha.fabricas.CreadorGuerrero;
import juegolucha.fabricas.CreadorMago;
import juegolucha.fabricas.CreadorNormal;
import juegolucha.fabricas.CreadorPersonaje;
import juegolucha.personajes.Personaje;
import juegolucha.terminal.Terminal;

public class JuegoLucha {
    private static final int PAUSA_PELEA_MS = 900;

    private final Personaje jugador1;
    private final Personaje jugador2;

    public JuegoLucha(Personaje j1, Personaje j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public void iniciarPelea() {
        mostrarTitulo("COMIENZA LA PELEA");
        Terminal.println("  " + jugador1.getNombre() + "  VS  " + jugador2.getNombre());
        mostrarEstadoInicial();
        pausar();

        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }

        if (jugador1.estaVivo()) {
            mostrarGanador(jugador1);
        } else {
            mostrarGanador(jugador2);
        }
    }

    private void turno(Personaje atacante, Personaje defensor) {
        Terminal.println("\n+--------------------------------------------------+");
        Terminal.printf("| %-48s |%n", acortar("TURNO: " + atacante.getNombre(), 48));
        Terminal.printf("| %-48s |%n", acortar("Objetivo: " + defensor.getNombre() + " | HP: " + defensor.getPuntosDeVida(), 48));
        Terminal.println("+--------------------------------------------------+");
        pausar();
        atacante.atacar(defensor);
        pausar();
        Terminal.println("> " + defensor.getNombre() + " queda con " + defensor.getPuntosDeVida() + " HP.");
        pausar();
    }

    private void mostrarEstadoInicial() {
        Terminal.println("\n+----------------------+-----+");
        Terminal.println("| Combatiente          | HP  |");
        Terminal.println("+----------------------+-----+");
        imprimirFilaEstado(jugador1);
        imprimirFilaEstado(jugador2);
        Terminal.println("+----------------------+-----+");
    }

    private void imprimirFilaEstado(Personaje personaje) {
        Terminal.printf("| %-20s | %3d |%n", acortar(personaje.getNombre(), 20), personaje.getPuntosDeVida());
    }

    private void mostrarGanador(Personaje ganador) {
        Terminal.println("\n+==================================================+");
        Terminal.println("| GANADOR                                          |");
        Terminal.println("+==================================================+");
        Terminal.println("  " + ganador.getNombre() + " ha ganado la pelea!");
        Terminal.println("+==================================================+");
    }

    private static void mostrarTitulo(String titulo) {
        Terminal.println("\n+==================================================+");
        Terminal.printf("| %-48s |%n", titulo);
        Terminal.println("+==================================================+");
    }

    private static String acortar(String texto, int maximo) {
        if (texto.length() <= maximo) {
            return texto;
        }

        return texto.substring(0, maximo - 3) + "...";
    }

    private static void pausar() {
        try {
            Thread.sleep(PAUSA_PELEA_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarTitulo("JUEGO DE LUCHA");
        Terminal.println("  Factory Method + Decorador");
        Terminal.println("  Combate por turnos en consola");

        Personaje p1 = crearJugador(scanner, 1);
        Personaje p2 = crearJugador(scanner, 2);

        new JuegoLucha(p1, p2).iniciarPelea();
        scanner.close();
    }

    private static Personaje crearJugador(Scanner scanner, int numeroJugador) {
        mostrarTitulo("CREAR JUGADOR " + numeroJugador);
        Terminal.print("> Nombre del Jugador " + numeroJugador + ": ");
        String nombre = scanner.nextLine().trim();

        while (nombre.isEmpty()) {
            Terminal.print("! El nombre no puede estar vacío. Nombre del Jugador " + numeroJugador + ": ");
            nombre = scanner.nextLine().trim();
        }

        CreadorPersonaje fabrica = elegirFabrica(scanner, numeroJugador);
        return fabrica.crearPersonaje(nombre);
    }

    private static CreadorPersonaje elegirFabrica(Scanner scanner, int numeroJugador) {
        while (true) {
            Terminal.println("\n+---------------- SELECCIONA CLASE ----------------+");
            Terminal.println("| 1. Normal   | 100 HP | Daño 10-30               |");
            Terminal.println("| 2. Guerrero | 100 HP | Daño +5, armadura -20%   |");
            Terminal.println("| 3. Mago     |  90 HP | Daño x1.5                |");
            Terminal.println("+--------------------------------------------------+");
            Terminal.print("> Clase del Jugador " + numeroJugador + ": ");

            String opcion = scanner.nextLine().trim();
            if (opcion.equals("1")) {
                return new CreadorNormal();
            }
            if (opcion.equals("2")) {
                return new CreadorGuerrero();
            }
            if (opcion.equals("3")) {
                return new CreadorMago();
            }

            Terminal.println("! Opción inválida. Escribe 1, 2 o 3.");
        }
    }
}
