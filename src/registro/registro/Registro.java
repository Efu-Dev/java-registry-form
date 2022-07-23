package registro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// Clase del formulario de registro. Hereda de JPanel e implementa ActionListener.
public class Registro extends JPanel implements ActionListener{

    private JButton cerrar, guardar, limpiar;
    private JTextField nombre, apellido, email;
    private JPasswordField contrasena, repetirContrasena; 
    private JRadioButton masculino, femenino;
    private ButtonGroup sexo;
    private JComboBox<String> dia, mes, anno, dominio;
    private JCheckBox economia, tecnologia, juegos, deportes, musica, fotografia;
    private ArrayList<Estudiante> estudiantes;
    private JTable tabla;

    public Registro(){ // Constructor de la clase.
        setSize(950, 400);
        setLayout(null); // Para colocar en coordenadas libres los componentes.
        setBackground(Color.WHITE);

        estudiantes = new ArrayList<Estudiante>();

        // Titulo
        JPanel fondoTitulo = new JPanel();
        fondoTitulo.setBackground(Color.CYAN);
        fondoTitulo.setLocation(200, 0);
        fondoTitulo.setSize(100, 30);
        JLabel titulo = new JLabel("Formulario");
        fondoTitulo.add(titulo);

        // Etiquetas de nombre y apellido
        JLabel nombreLabel = new JLabel("Nombre:"), apellidoLabel = new JLabel("Apellido:");
        nombreLabel.setLocation(20, 50);
        nombreLabel.setSize(70, 10);
        apellidoLabel.setLocation(20, 78);
        apellidoLabel.setSize(70, 15);

        // Campos de texto de nombre y apellido
        nombre = new JTextField();
        nombre.setSize(100, 20);
        nombre.setLocation(100, 45);

        apellido = new JTextField();
        apellido.setSize(100, 20);
        apellido.setLocation(100, 77);

        // Etiquetas de sexo
        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setSize(100, 20);
        sexoLabel.setLocation(20, 100);

        // Radio Buttons de sexo
        sexo = new ButtonGroup();

        masculino = new JRadioButton("Masculino");
        femenino = new JRadioButton("Femenino");

        masculino.setBackground(Color.WHITE);
        masculino.setLocation(100, 100);
        masculino.setSize(100, 20);
        sexo.add(masculino);
        
        femenino.setBackground(Color.WHITE);
        femenino.setSize(100, 20);
        femenino.setLocation(200, 100);
        sexo.add(femenino);

        masculino.setSelected(true);

        // Componentes de fecha de nacimiento.
        JLabel fechaLabel = new JLabel("Fecha de Nacimiento:");
        fechaLabel.setSize(160, 20);
        fechaLabel.setLocation(20, 150);

        llenarDia();
        llenarMes();
        llenarAnno();

        dia.setSize(60, 20);
        dia.setLocation(170, 150);

        mes.setSize(95, 20);
        mes.setLocation(238, 150);

        anno.setSize(60, 20);
        anno.setLocation(340, 150);
    
        JLabel annoLabel = new JLabel("Año:"), mesLabel = new JLabel("Mes:"), diaLabel = new JLabel("Dia:");
        annoLabel.setSize(60, 20);
        annoLabel.setLocation(355, 130);

        mesLabel.setSize(80, 20);
        mesLabel.setLocation(255, 130);

        diaLabel.setSize(60, 20);
        diaLabel.setLocation(175, 130);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setSize(60, 20);
        emailLabel.setLocation(20, 183);

        email = new JTextField();
        email.setSize(100, 20);
        email.setLocation(80, 185);

        JLabel arroba = new JLabel("@");
        arroba.setSize(20, 20);
        arroba.setLocation(185, 183);

        llenarDominio();
        dominio.setSize(100, 20);
        dominio.setLocation(205, 185);

        // Contraseña y repetir
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setSize(100, 20);
        contrasenaLabel.setLocation(20, 215);
        
        contrasena = new JPasswordField();
        contrasena.setSize(100, 20);
        contrasena.setLocation(105, 215);

        JLabel repetirLabel = new JLabel("Repetir Contraseña:");
        repetirLabel.setLocation(20, 240);
        repetirLabel.setSize(150, 20);

        repetirContrasena = new JPasswordField();
        repetirContrasena.setLocation(150, 240);
        repetirContrasena.setSize(100, 20);

        // Intereses
        JLabel interesesLabel = new JLabel("Intereses:");
        interesesLabel.setSize(100, 20);
        interesesLabel.setLocation(20, 275);

        economia = new JCheckBox("Economía");
        economia.setBackground(Color.WHITE);
        economia.setSize(100, 20);
        economia.setLocation(20, 300);
        
        tecnologia = new JCheckBox("Tecnología");
        tecnologia.setBackground(Color.WHITE);
        tecnologia.setSize(100, 20);
        tecnologia.setLocation(120, 300);
        
        juegos = new JCheckBox("Juegos");
        juegos.setBackground(Color.WHITE);
        juegos.setSize(100, 20);
        juegos.setLocation(220, 300);
        
        deportes = new JCheckBox("Deportes");
        deportes.setBackground(Color.WHITE);
        deportes.setSize(100, 20);
        deportes.setLocation(20, 330);
        
        musica = new JCheckBox("Música");
        musica.setBackground(Color.WHITE);
        musica.setSize(100, 20);
        musica.setLocation(120, 330);
        
        fotografia = new JCheckBox("Fotografía");
        fotografia.setBackground(Color.WHITE);
        fotografia.setSize(100, 20);
        fotografia.setLocation(220, 330);

        // Botones
        cerrar = new JButton("Cerrar");
        cerrar.setSize(90, 30);
        cerrar.setLocation(330, 330);
        cerrar.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setSize(90, 30);
        limpiar.setLocation(330, 290);
        limpiar.addActionListener(this);
        
        guardar = new JButton("Guardar");
        guardar.setSize(90, 30);
        guardar.setLocation(330, 250);
        guardar.addActionListener(this);

        // Tabla

        JScrollPane scroll = new JScrollPane();
        scroll.setLocation(435, 10);
        scroll.setSize(500, 350);
		
        tabla = new javax.swing.JTable();
        tabla.setModel(new DefaultTableModel( // Clase anónima de Modelo de Tabla (DefaultTableModel)
            new Object[][] {}, // Inicialmente sin filas
            new String [] {
                "Nombre", "Apellido", "Fecha Nac.", "Sexo", "Email"
            } // Columnas de la tabla
        ){
            @Override
            public boolean isCellEditable(int row, int column) { // Se define ninguna celda como editable en la clase.
                return false;
            }
        });

        tabla.setSize(800, 350);
        tabla.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) { // Cuando se hace click con el mouse
                if(estudiantes.isEmpty())
                    return;
                
                limpiar();
                Estudiante est = estudiantes.get(tabla.getSelectedRow());
                nombre.setText(est.getNombre());
                apellido.setText(est.getApellido());

                if(est.getSexo() == "Masculino")
                    masculino.setSelected(true);
                else
                    femenino.setSelected(true);
                
                dia.setSelectedItem(est.getDia());
                mes.setSelectedItem(est.getMes());
                anno.setSelectedItem(est.getAnno());

                email.setText(est.getEmail().split("@")[0]);
                dominio.setSelectedItem(est.getEmail().split("@")[1]);

                contrasena.setText(est.getContrasena());
                repetirContrasena.setText(est.getContrasena());

                for(String interes : est.getIntereses())
                    if(interes.equals("Economía"))
                        economia.setSelected(true);
                    else if(interes.equals("Tecnología"))
                        tecnologia.setSelected(true);
                    else if(interes.equals("Juegos"))
                        juegos.setSelected(true);
                    else if(interes.equals("Deportes"))
                        deportes.setSelected(true);
                    else if(interes.equals("Fotografía"))
                        fotografia.setSelected(true);
                    else if(interes.equals("Música"))
                        musica.setSelected(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {} // No usado.

            @Override
            public void mouseReleased(MouseEvent e) {} // No usado.

            @Override
            public void mouseEntered(MouseEvent e) {} // No usado.

            @Override
            public void mouseExited(MouseEvent e) {} // No usado.

        });
        scroll.setViewportView(tabla); // Se coloca la tabla en el JScrollPane.
        add(scroll); // Se agrega el scroll al JPanel.
        
        // Agregar todos los componentes al JPanel.
        add(fondoTitulo);

        add(nombreLabel);
        add(apellidoLabel);
        add(sexoLabel);
        add(fechaLabel);
        add(nombre);
        add(apellido);

        add(masculino);
        add(femenino);

        add(annoLabel);
        add(anno);
        add(mesLabel);
        add(mes);
        add(diaLabel);
        add(dia);

        add(emailLabel);
        add(email);
        add(arroba);
        add(dominio);

        add(interesesLabel);
        add(economia);
        add(tecnologia);
        add(juegos);
        add(deportes);
        add(musica);
        add(fotografia);

        add(contrasenaLabel);
        add(contrasena);
        add(repetirLabel);
        add(repetirContrasena);

        add(cerrar);
        add(guardar);
        add(limpiar);
    }

    private void llenarDominio() { // Método para llenar el ComboBox de los dominios.
        this.dominio = new JComboBox<String>();
        String[] dominios = {"hotmail.com", "outlook.com", "gmail.com", "yahoo.com", "urbe.edu"};
        for (String dominio : dominios)
            this.dominio.addItem(dominio);
    }

    private void llenarAnno() { // Método para llenar el ComboBox de los años.
        anno = new JComboBox<String>();

        for (Integer i = 2022; i > 1880; i--)
            anno.addItem(i.toString());
    }

    private void llenarMes() { // Método para llenar el ComboBox de los meses.
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
        "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        this.mes = new JComboBox<>();

        for (String mes : meses)
            this.mes.addItem(mes);
    }

    private void llenarDia() {  // Método para llenar el ComboBox de los días.
        dia = new JComboBox<String>();
        
        for (Integer i = 1; i <= 31; i++)
            dia.addItem(i.toString());
    }

    public void mostrar(){  // Método para mostrar las actualizaciones de la tabla.
        String matriz[][] = new String[estudiantes.size()][5];
		for (int i = 0; i < estudiantes.size(); i++) {
			matriz[i][0] = estudiantes.get(i).getNombre();
			matriz[i][1] = estudiantes.get(i).getApellido();
			matriz[i][2] = estudiantes.get(i).getDia() +"/"+ estudiantes.get(i).getMes()+"/"+estudiantes.get(i).getAnno();
			matriz[i][3] = estudiantes.get(i).getSexo();
			matriz[i][4] = estudiantes.get(i).getEmail();			
		}

        tabla.setModel(new DefaultTableModel( // Se actualiza el modelo de tabla con la clase anónima.
			matriz,
            new String [] {"Nombre", "Apellido", "Fecha Nac.", "Sexo", "Email"}){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Eventos de presionar botón.
        Object pulso = e.getSource();

        if(pulso == limpiar)
            limpiar();
        if(pulso == guardar)
            guardar();
        else if(pulso == cerrar)
            cerrar();
    }

    private void cerrar() {
        System.exit(0); // Se cierra el programa.
    }

    private void guardar() {
        String nombre = this.nombre.getText();
        String apellido = this.apellido.getText();
        String sexo = masculino.isSelected() ? "Masculino" : femenino.isSelected() ? "Femenino" : "";
        String dia = this.dia.getSelectedItem().toString(), mes = this.mes.getSelectedItem().toString(), anno = this.anno.getSelectedItem().toString();
        String email = this.email.getText();

        if(nombre.equals(""))
            JOptionPane.showMessageDialog(null, "El recuadro de nombre esta vacío.");
        else if(!nombre.matches("[a-zA-ZáéíóúÁÉÍÚÓ-]*"))
            JOptionPane.showMessageDialog(null, "El nombre contiene caracteres inválidos.");
        else if (apellido.equals(""))
            JOptionPane.showMessageDialog(null, "El recuadro de apellido esta vacío.");
        else if(!apellido.matches("[a-zA-ZáéíóúÁÉÍÚÓ-]*"))
            JOptionPane.showMessageDialog(null, "El apellido contiene caracteres inválidos.");
        else if(sexo.equals(""))
            JOptionPane.showMessageDialog(null, "Debe elegir un sexo.");
        else if(!fechaValida())
            JOptionPane.showMessageDialog(null, "La fecha no es válida.");
        else if (email.equals(""))
            JOptionPane.showMessageDialog(null, "El recuadro de correo esta vacío.");
        else if(contrasena.getText().equals(""))
            JOptionPane.showMessageDialog(null, "El recuadro de contraseña esta vacío.");
        else if(!contrasena.getText().equals(repetirContrasena.getText()))
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        else if(!economia.isSelected() && !tecnologia.isSelected() && !juegos.isSelected() 
            && !deportes.isSelected() && !musica.isSelected() && !fotografia.isSelected())
                JOptionPane.showMessageDialog(null, "Debe elegir al menos un interés.");
        else{
            ArrayList<String> intereses = new ArrayList<String>();
            if(economia.isSelected())
                intereses.add("Economía");
            
            if(tecnologia.isSelected())
                intereses.add("Tecnología");
            
            if(juegos.isSelected())
                intereses.add("Juegos");
            
            if(deportes.isSelected())
                intereses.add("Deportes");

            if(musica.isSelected())
                intereses.add("Música");

            if(fotografia.isSelected())
                intereses.add("Fotografía");

            email += "@" + dominio.getSelectedItem().toString();
            Estudiante estu = new Estudiante(nombre, apellido, sexo, dia, mes, anno, email, contrasena.getText(), intereses);
            estudiantes.add(estu);
            limpiar();
        }
        mostrar();
    }

    private boolean fechaValida() {
        String mes = this.mes.getSelectedItem().toString();
        int dia = Integer.parseInt(this.dia.getSelectedItem().toString());

        if(mes.equals("Abril") || mes.equals("Junio") || mes.equals("Septiembre") || mes.equals("Noviembre"))
            if(dia == 31)    
                return false;

        if(mes.equals("Febrero"))
            if((dia > 29) || (dia == 29 && !annoBisiesto()))
                return false;
        
        return true;
    }

    private boolean annoBisiesto() {
        int anno = Integer.parseInt((String)this.anno.getSelectedItem());

        //Año no divisible entre 100 pero si entre 4, o divisible entre 400 es bisiesto.
        return (anno%100 != 0 && anno%4 == 0) || (anno%4 == 0); 
    }

    private void limpiar() {
        nombre.setText("");
        apellido.setText("");
        masculino.setSelected(false);
        anno.setSelectedItem("2022");
        mes.setSelectedItem("Enero");
        dia.setSelectedItem("1");
        email.setText("");
        contrasena.setText("");
        repetirContrasena.setText("");
        economia.setSelected(false);
        tecnologia.setSelected(false);
        juegos.setSelected(false);
        deportes.setSelected(false);
        musica.setSelected(false);
        fotografia.setSelected(false);
    }    
}