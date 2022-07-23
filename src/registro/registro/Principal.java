package registro;

/**
 * @author Diego Faria
 * @author Winderson Villarreal
 */

// Clase principal del programa.
public class Principal {

    public static void main(String[] args) { // Método main.
        Ventana ventana = new Ventana(new Registro()); // Se crea una nueva ventana con el panel de registro.
        ventana.setTitle("Registro de Estudiantes"); // Se le coloca este título.
        ventana.setVisible(true); // Se pone visible.
    }
    
}
