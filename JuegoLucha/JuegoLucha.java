import java.util.Scanner;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(Personaje j1, Personaje j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public void iniciarPelea() {
        System.out.println("¡La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");
        
        // El juego debe ser por turnos
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }

        // El primer personaje en quedarse sin puntos de vida pierde
        if (jugador1.estaVivo()) {
            System.out.println("\n¡" + jugador1.getNombre() + " ha ganado la pelea!");
        } else {
            System.out.println("\n¡" + jugador2.getNombre() + " ha ganado la pelea!");
        }
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("\nTurno de " + atacante.getNombre() + ". HP de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " HP.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Uso de la única fábrica (Factory Method) para ambos jugadores
        CreadorPersonaje fabricaGuerrero = new CreadorGuerrero();

        System.out.print("Introduce el nombre del Jugador 1: ");
        Personaje p1 = fabricaGuerrero.crearPersonaje(scanner.nextLine());

        System.out.print("Introduce el nombre del Jugador 2: ");
        Personaje p2 = fabricaGuerrero.crearPersonaje(scanner.nextLine());

        JuegoLucha juego = new JuegoLucha(p1, p2);
        juego.iniciarPelea(); // Se inicia la pelea por turnos
        
        scanner.close();
    }
}