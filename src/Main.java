//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
// acciones realizadas
    static String[] pilaPrincipal = new String[100];
    static int topePrincipal = -1;

// acciones deshechas para rehacer
    static String[] pilaSecundaria = new String[100];
    static int topeSecundaria = -1;

// operaciones pila principal
    static void pushPrincipal(String texto) {
        if (topePrincipal < pilaPrincipal.length - 1) {
            pilaPrincipal[++topePrincipal] = texto;
        } else {
            System.out.println(" La pila principal está llena.");
        }
    }

    static String popPrincipal() {
        if (topePrincipal >= 0) {
            return pilaPrincipal[topePrincipal--];
        }
        System.out.println(" No hay texto para deshacer.");
        return null;
    }

    static String peekPrincipal() {
        if (topePrincipal >= 0) {
            return pilaPrincipal[topePrincipal];
        }
        return "No hay texto en la pila.";
    }

    static boolean isEmptyPrincipal() {
        return topePrincipal == -1;
    }

// operaciones pila secundaria
    static void pushSecundaria(String texto) {
        if (topeSecundaria < pilaSecundaria.length - 1) {
            pilaSecundaria[++topeSecundaria] = texto;
        }
    }

    static String popSecundaria() {
        if (topeSecundaria >= 0) {
            return pilaSecundaria[topeSecundaria--];
        }
        return null;
    }

// programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String texto;

        do {
            System.out.println("\n===== MENÚ EDITOR DE TEXTO =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer última acción");
            System.out.println("3. Rehacer acción");
            System.out.println("4. Mostrar texto actual (peek)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); //limpiar

            if (opcion == 1) {
                System.out.print("Ingrese el texto: ");
                texto = sc.nextLine();
                pushPrincipal(texto);
                System.out.println("Texto agregado.");
                // limpia la pila secundaria
                topeSecundaria = -1;

            } else if (opcion == 2) {
                texto = popPrincipal();
                if (texto != null) {
                    pushSecundaria(texto);
                    System.out.println(" Acción deshecha: " + texto);
                }

            } else if (opcion == 3) {
                texto = popSecundaria();
                if (texto != null) {
                    pushPrincipal(texto);
                    System.out.println(" Acción rehecha: " + texto);
                } else {
                    System.out.println(" No hay acciones para rehacer.");
                }

            } else if (opcion == 4) {
                System.out.println(" Texto actual: " + peekPrincipal());

            } else if (opcion == 5) {
                System.out.println("1 Saliendo del programa...");

            } else {
                System.out.println(" Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
