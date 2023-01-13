package gestiondeautos;

//Importar Libreria de DB4o
import com.db4o.*;
import java.util.Scanner;

public class GestiondeAutos {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //1.Defirnir la ruta del archivo .db4o
        String ruta = "autos.db4o";
        //2.Definir la instancia de DB4o
        ObjectContainer db = Db4o.openFile(
                Db4o.newConfiguration(),
                ruta
        );
        //3. Colocar todo el codigo en el bloque try finally
        try {
            String opc = "";
            salida:
            do {
                //Menu de Opciones
                System.out.println("Selecciona una operacion CRUD");
                System.out.println("Insertar");
                System.out.println("Consultar");
                System.out.println("Eliminar");
                System.out.println("Modificar");
                System.out.println("Salir");
                opc = s.nextLine();
                switch (opc) {
                    case "Insertar":
                        Auto auto = new Auto();
                        System.out.print("Marca: ");
                        auto.setMarca(s.nextLine());
                        System.out.print("Modelo: ");
                        auto.setModelo(s.nextLine());
                        System.out.print("Anio: ");
                        auto.setAnio(s.nextLine());
                        //Verificar el Objeto
                        System.out.println(auto);
                        //Guardar el objeto en la DB
                        db.store(auto);
                        System.out.println("Auto Guardado con Exito");
                        break;
                    case "Consultar":
                        //Objeto de Refencia;
                        Auto autoB = new Auto(null, null, null);
                        //Obtener el Arraylist de REsultados
                        ObjectSet resultadosB = db.queryByExample(autoB);
                        //Iterar nuestros resultados
                        while (resultadosB.hasNext()) {
                            Auto a = (Auto) resultadosB.next();
                            System.out.println(a);
                        }
                        break;
                    case "Eliminar":
                        //1.Obtener el parametro de busqueda
                        String filtro;
                        System.out.print("Introduzca el modelo a eliminar: ");
                        filtro = s.nextLine();
                        //Crear el objeto de referencia
                        Auto autoElim = new Auto(null, filtro, null);
                        //REalizar la busqueda en la DB
                        ObjectSet resultadosElim = db.queryByExample(autoElim);
                        //Iterar los resultado para eliminar
                        while (resultadosElim.hasNext()) {
                            Auto a = (Auto) resultadosElim.next();
                            db.delete(a);
                            System.out.println("Auto Eliminado con Exito");
                        }
                        break;
                    case "Modificar":
                        //1.Obtener el parametro de busqueda
                        String filtroEdit;
                        System.out.print("Introduzca el modelo a editar: ");
                        filtroEdit = s.nextLine();
                        //Crear el objeto de referencia
                        Auto autoEdit = new Auto(null, filtroEdit, null);
                        //REalizar la busqueda en la DB
                        ObjectSet resultadosEdit = db.queryByExample(autoEdit);
                        //Iterar los resultado para eliminar
                        while (resultadosEdit.hasNext()) {
                            //Recuperar el objeto de la DB
                            Auto Edit = (Auto) resultadosEdit.next();
                            System.out.println("Auto encontrado: "+Edit);
                            
                            System.out.print("Nuevo Modelo: ");
                            Edit.setModelo(s.nextLine());
                            //Guardar los cambios en la base de datos
                            db.store(Edit);
                        }
                        break;
                    case "Salir":
                        break salida;
                    default:
                        System.err.println("Opcion invalida");
                }
                //Menu de Salida
                System.out.println("Deseas continuar?  1.Si    0.No");
                opc = s.nextLine();
            } while (!opc.equalsIgnoreCase("0"));
        } catch (Exception e) {
            System.err.println("El programa se cerro inesperadamente :(");
            db.close();
        } finally {
            //Cierre de nuestro Documento
            System.out.println("Gracias por usar el sistema :D");
            db.close();
        }
    }
}
