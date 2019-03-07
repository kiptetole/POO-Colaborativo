/*
 *  Esta es la creacion de la clase ColeccionDiscos Pero ya hecha por mi
 *  
 *   @author: Jose Notario Millan
 */
package coleccion_De_Discos;
import java.util.ArrayList;
import java.util.Scanner;

public class ColeccionDiscos {
  
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    // Declaracion de las variables de la clase main.
    ArrayList<Discos> coleccion = new ArrayList<Discos>();
    int selector, selectorModifica;
    String codigo;
    String autor;
    String titulo;
    String genero;
    long duracion;
    boolean verificadorCodigo = true;
    String codigomodifica;
    int posiciondiscoamodificar = -1;
    String codigoborrar;
    int posiciondiscoaborrar = -1;
    
    do {
      // Selector del menu.
      Menu();
      selector = s.nextInt();
      
      switch (selector) {
      case 1:                     //Lista los discos existentes en la coleccion,si no hay ninguno muestra un mensage.
        
        try {
          coleccion.get(0);
        }catch(Exception e){
          System.out.println("La coleccion esta vacia.");
          break;
        }
        
        System.out.println("Listado de la coleccion de discos ya guardados:\n------------------------------");
        for(int i=0; i<coleccion.size(); i++) {
          System.out.println(coleccion.get(i));
        }
          break;
      case 2:                     //Añade un nuevo disco en la coleccion, sin repetir codigo.
        //Pedimos cada uno de los 
        System.out.println("Vamos a introducir un disco nuevo:");
        
        /*
         *  Esto es para que los codigos introducidos no se repitan.
         *  
         *  Y si se reiten volver a preguntar el codigo.
        */
        s.nextLine();
        do {
        // Introducimos el codigo del disco.
        System.out.println("Introduzca el Codigo:");
        codigo = s.nextLine();
        
        for (int i=0; i<coleccion.size(); i++) {
          if (codigo.equals(coleccion.get(i).getCodigo())) { // Si el codigo se repite este el bucle se repite.
            verificadorCodigo = false;
            break;
          }else                                             // Si no este sale del bucle
            verificadorCodigo = true;
        }
        
        if (!verificadorCodigo) 
          System.out.println("El codigo introducido se ha repetido.");
        
        }while(!verificadorCodigo);
        System.out.println("Introduzca el Autor:");
        autor = s.nextLine();
        System.out.println("Introduzca el Titulo:");
        titulo = s.nextLine();
        System.out.println("Introduzca el Genero:");
        genero = s.nextLine();
        System.out.println("Introduzca la Duracion: (En segundos)");
        duracion = s.nextLong();
        // Creacion del Objeto.
        coleccion.add(new Discos(codigo,autor,titulo,genero,duracion));
        break;      
      case 3:                     //Modifica un disco, identificandolo por su codigo y modificando el campo que se requiera.
          s.nextLine();
          
          try {
            coleccion.get(0);
          }catch(Exception e){
            System.out.println("No hay discos a modificar.");
            break;
          }
          
          do {
            System.out.println("Introduce el codigo del disco que quieras modificar:");
            codigomodifica = s.nextLine();
          
            for (int i=0; i<coleccion.size();i++) {                              // Ver donde esta el codigo en el arraylist
                if (codigomodifica.equals(coleccion.get(i).getCodigo()))  
                    posiciondiscoamodificar = i;
                  break;
              }
            
            if (posiciondiscoaborrar<0) {
              System.out.println("El codigo no esta en la coleccion.");
            }
          }while(posiciondiscoamodificar<0);
          //Si "posiciondiscoamodificar" es -1 el codigo no esta en el array. (Se vuelve a pedir el codigo)
          // Si esa variable tiene 0 o cualquier numero positivo este esta en el codigo y pregunta que compo cambiar.
          
          do {
          System.out.println("El codigo se encuentra en la coleccion");
          MenuModifica(); 
          selectorModifica = s.nextInt();
          s.nextLine();
            switch (selectorModifica) {
              case 1:
                System.out.println("Introduce el nuevo nombre del autor:");
                  autor = s.nextLine();
                  coleccion.get(posiciondiscoamodificar).setAutor(autor);
                  break;
                  case 2:
                    System.out.println("Introduce el nuevo nombre del titulo:");
                    titulo = s.nextLine();
                    coleccion.get(posiciondiscoamodificar).setTitulo(titulo);
                    break;
                  case 3:
                    System.out.println("Introduce el nuevo nombre del genero:");
                    genero = s.nextLine();
                    coleccion.get(posiciondiscoamodificar).setGenero(genero);
                    break;
                  case 4:
                    System.out.println("Introduce la nueva duracion del disco:");
                    duracion = s.nextInt();
                    coleccion.get(posiciondiscoamodificar).setDuracion(duracion);
                    break;
                  case 5:
                    System.out.println("Termina Modifica.");
                    break;
                  default:
                    System.out.println("No existe la opcion.");
                    break;
                }
              }while(selectorModifica!=5);         
        break;
      case 4:                     //Borra un disco de la colececion.
        s.nextLine();
        
        try {
          coleccion.get(0);
        }catch(Exception e){
          System.out.println("No hay discos a borrar.");
          break;
        }
        
        do {
          System.out.println("Introduce el codigo del disco que quieras borrar:");
          codigoborrar = s.nextLine();
        
          for (int i=0; i<coleccion.size();i++) {                              // Ver donde esta el codigo en el arraylist
              if (codigoborrar.equals(coleccion.get(i).getCodigo()))  
                  posiciondiscoaborrar = i;
                break;
            }
          
          if (posiciondiscoaborrar<0) {
            System.out.println("El codigo no esta en la coleccion.");
          }
        }while(posiciondiscoaborrar<0);
        //Si "posiciondiscoamodificar" es -1 el codigo no esta en el array. (Se vuelve a pedir el codigo)
        // Si esa variable tiene 0 o cualquier numero positivo este esta en el codigo y pregunta que compo cambiar.
        
        coleccion.remove(posiciondiscoaborrar);         // Esto es para borrar el elemento
        System.out.println("Elemento Borrado.");
          
        break;
      case 5:                     // Sale del menu.
        System.out.println("ADIOS ;)");
        break;
      default:                    // Muestra "Error al elegir la opcion" si se equivoca al elegir.
        System.out.println("Error al elegir la opcion");
        break;
      }
      
      // Esperamos 1 segundo para ver el resultado.
      try {
        Thread.sleep (1000);
        } catch (Exception e) {}
      
    }while(selector != 5);
    
  }
  
  
  
  /**
   * El Menu de la colección de discos.
   */
  public static void Menu(){
    System.out.println("Menu de la coleccion de discos:\n----------------------");
    System.out.println("1.- Listado");
    System.out.println("2.- Nuevo disco");
    System.out.println("3.- Modificar");
    System.out.println("4.- Borrar");
    System.out.println("5.- Salir");
  }
    /**
     * Menu que se usa en la opcion de modificar.
     */
  public static void MenuModifica(){
    System.out.println("Menu de modificacion de los discos:\n----------------------");
    System.out.println("1.- autor");
    System.out.println("2.- titulo");
    System.out.println("3.- genero");
    System.out.println("4.- duracion"); 
    System.out.println("5.- Termina Modificacion");
  }
  
}