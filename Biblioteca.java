import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Biblioteca {
    public static void main(String[] args) {
        String ruta ="libros.db4o";
         Libros libro1 = null, libro2 = null, libro3 = null;
        ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(),ruta);

        try {
            Libros a = new Libros("El señor de los anillos","J.R.R Tolkien","1954");
            Libros b = new Libros("Cien años de soledad", "Gabriel García Márquez", "1967");
            Libros c = new Libros("El Hobbit", "J.R.R. Tolkien", "1937");
            Libros d = new Libros("1984", "George Orwell", "1949");
            Libros e = new Libros("Orgullo y Prejuicio", "Jane Austen", "1813");
            Libros f = new Libros("El Principito", "Antoine de Saint-Exupéry", "1943");
            Libros g = new Libros("El Alquimista", "Paulo Coelho", "1988");
            Libros h = new Libros("El Diario de Ana Frank", "Ana Frank", "1947");
            Libros i = new Libros("El Perfume", "Patrick Süskind", "1985");
            Libros j = new Libros("El Nombre de la Rosa", "Umberto Eco", "1980");


            db.store(a);
            db.store(b);
            db.store(c);
            db.store(d);
            db.store(e);
            db.store(f);
            db.store(g);
            db.store(h);
            db.store(i);
            db.store(j);

            System.out.println("----------------------");
            System.out.println("Creacion de libros");
            System.out.println("----------------------");
            System.out.println("Libro guardado: " + a);
            System.out.println("Libro guardado: " + b);
            System.out.println("Libro guardado: " + c);
            System.out.println("Libro guardado: " + d);
            System.out.println("Libro guardado: " + e);
            System.out.println("Libro guardado: " + f);
            System.out.println("Libro guardado: " + g);
            System.out.println("Libro guardado: " + h);
            System.out.println("Libro guardado: " + i);
           System.out.println("Libro guardado: " + j);

            db.close();

            db = Db4o.openFile(Db4o.newConfiguration(),ruta);

            System.out.println("----------------------");
            System.out.println("Libros en existencia");
            System.out.println("----------------------");
            ObjectSet libros = db.queryByExample(new Libros(null, null, null ));
            while (libros.hasNext()){
                System.out.println(libros.next());
            }

            System.out.println("----------------------");
            System.out.println("Consulta especifica");
            System.out.println("----------------------");

            libro1 = (Libros) db.queryByExample(new Libros("El señor de los anillos", null, null)).next();
            System.out.println(libro1);

            libro2 = (Libros) db.queryByExample(new Libros("El Hobbit", null, null)).next();
            System.out.println(libro2);

            libro3 = (Libros) db.queryByExample(new Libros("El Nombre de la Rosa", null, null)).next();
            System.out.println(libro3);

            System.out.println("------------------------");
            System.out.println("Actualizacion de libros");
            System.out.println("------------------------");
            libro1.setTitulo("El Señor de los Anillos: La Comunidad del Anillo");
            libro2.setTitulo("El Hobbit: Un Viaje Inesperado");
            libro3.setTitulo("El Silmarillion");
            db.store(libro1);
            db.store(libro2);
            db.store(libro3);

            System.out.println("Libro actualizado: " + libro1);
            System.out.println("Libro actualizado: " + libro2);
            System.out.println("Libro actualizado: " + libro3);

            System.out.println("------------------------");
            System.out.println("Eliminacion de libros de libros");
            System.out.println("------------------------");
            ObjectSet eliminar = db.queryByExample(new Libros(null, "J.R.R. Tolkien", null));
            while (eliminar.hasNext()){
                Libros libroEliminar = (Libros) eliminar.next();
                db.delete(libroEliminar);
                System.out.println("Libro eliminado: " + libroEliminar);
            }

            System.out.println("------------------------");
            System.out.println("Consulta general");
            System.out.println("------------------------");
            libros = db.queryByExample(new Libros(null, null, null));
            while (libros.hasNext()){
                System.out.println(libros.next());
            }

            db.close();

        }catch (Exception e){
            System.out.println("El sistema no responde :(" + e);
            db.close();
        }finally {
            db.close();
        }
    }
}
