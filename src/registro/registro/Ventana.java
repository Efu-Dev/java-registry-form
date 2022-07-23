package registro;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Clase de la ventana utilizada en el programa.
public class Ventana extends JFrame{

    public Ventana(JPanel contenido){ // Constructor de la clase.
        setSize(960, 420); // Tamaño predeterminado de la ventana.
        add(contenido); // Se le añade el panel pasado como parámetro.
        setLocationRelativeTo(null); // Se centra el frame.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se termina el programa al cerrar.
        setResizable(false); // No se le puede cambiar el tamaño.
    }

}
