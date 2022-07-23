package registro;

import java.util.ArrayList;

// Clase que sirve de modelo para almacenar los datos de los estudiantes.
public class Estudiante {
    private String nombre, apellido, sexo, email, contrasena, anno, mes, dia;
    private ArrayList<String> intereses;
   
    // Constructor de la clase.
    public Estudiante(String nombre, String apellido, String sexo, String dia,String mes,String anno, String email, String contrasena, ArrayList<String> intereses){
        
        // Se asignan los atributos de la clase a los parámetros homónimos enviados al constructor.
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.anno = anno;
        this.dia = dia;
        this.mes = mes;
        this.email = email;
        this.contrasena = contrasena;
        this.intereses = intereses;
    }

    public void setNombre(String nombre){ // Setter del nombre
        this.nombre = nombre;
    }

    public void setAnno(String anno){ // Setter del año
        this.anno = anno;
    }

    public void setDia(String dia){ // Setter del día
        this.dia = dia;
    }

    public void setMes(String mes){ // Setter del mes
        this.mes = mes;
    }

    public void setApellido(String apellido){ // Setter del apellido
        this.apellido = apellido;
    }

    public void setSexo(String sexo){ // Setter del sexo
        this.sexo = sexo;
    }

    public void setEmail(String email){ // Setter del email
        this.email = email;
    }

    public void setContrasena(String contrasena){ // Setter de la contraseña
        this.contrasena = contrasena;
    }

    public void setIntereses(ArrayList<String> intereses){ // Setter de los intereses
        this.intereses = intereses;
    }

    public String getNombre(){ // Getter del nombre
        return nombre;
    }

    public String getSexo(){ // Getter del sexo
        return sexo;
    }

    public String getApellido(){ // Getter del apellido
        return apellido;
    }

    public String getEmail(){ // Getter del email
        return email;
    }

    public String getContrasena(){ // Getter de la contraseña
        return contrasena;
    }

    public ArrayList<String> getIntereses(){ // Getter de los intereses
        return intereses;
    }

    public String getAnno(){ // Getter del año
        return anno;
    }

    public String getDia(){ // Getter del día
        return dia;
    }

    public String getMes(){ // Getter del mes
        return mes;
    }
    
}
