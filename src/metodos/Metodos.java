
package metodos;

import datos.Alumno;
import datos.Conexion;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;


public class Metodos {
    
   
     
     public static ArrayList <Alumno> recogerAlumnos(){
       ArrayList <Alumno> alumnos= Conexion.mostrarAlumnos();
       return alumnos;
     }
    
    public static DefaultTableModel visualizar(ArrayList alumnos){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Dirección");
        model.addColumn("Telefono");
        
        Iterator it = alumnos.iterator();
        while (it.hasNext()) {
            Alumno al = (Alumno) it.next();
            String[] fila = new String[5];
            fila[0] = al.getDni();
            fila[1] = al.getNombre();
            fila[2] = al.getApellidos();
            fila[3] = al.getDireccion();
            fila[4] = al.getTelefono();
            model.addRow(fila);
        }
        return model;
    }
    
    public static void añadirAl(Alumno alumno){
        Conexion.guardarAlumno(alumno);
    }
    
    public static void eliminarAl(String dni){
        Conexion.borrarAlumno(dni);
    }
    
    public static void actualizarAL(Alumno alumno){
        Conexion.modificarAlumno(alumno);
    }
    
    public static ArrayList <Alumno> buscarAl(String busqueda){
        ArrayList resultado = Conexion.buscarAlumno(busqueda);
        return resultado;
    }
}
