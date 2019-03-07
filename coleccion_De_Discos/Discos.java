/**
 * Crea la clase Discos:
 *  Atributos:
 *    -autor: Nombre del autor.
 *    -titulo: Titulo del disco.
 *    -genero: Genero del disco
 *    -duracion: Duracion en minutos del disco.
 * 
 *  Metodos:
 *    
 */
package coleccion_De_Discos;

/**
 * @author Jose Notario Millan
 */

public class Discos {
  private String codigo = "LIBRE";
  private String autor;
  private String titulo;
  private String genero;
  private long duracion; // duración total en minutos

  /**
   * Cosnstructor de la clase Discos.
   * 
   * @param codigo
   * @param autor
   * @param titulo
   * @param genero
   * @param duracion
   */
  public Discos(String codigo,String autor,String titulo,String genero, long duracion) {
    this.setCodigo(codigo);
    this.setAutor(autor);
    this.setTitulo(titulo);
    this.setGenero(genero);
    this.setDuracion(duracion);
  }
  
  /**
   * Método para obtener el código
   * @return codigo
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Método para modificar el codigo
   * @param codigo
   * @return codigo
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  
  /**
   * Método para obtener el autor
   * @return autor
   */
  public String getAutor() {
    return autor;
  }
  
  /**
   * Método para modificar el autor
   * @param autor
   * @return autor
   */
  public void setAutor(String autor) {
    this.autor = autor;
  }
  
  /**
   * Método para obtener el genero
   * @return genero
   */
  public String getGenero() {
    return genero;
  }
  
  /**
   * Método para modificar el genero
   * @param genero
   * @return genero
   */
  public void setGenero(String genero) {
    this.genero = genero;
  }
  
  /**
   * Método para obtener el título
   * @return titulo
   */
  public String getTitulo() {
    return titulo;
  }
  
  /**
   * Método para modificar el titulo
   * @param titulo
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
  /**
   * Método para obtener la duracion
   * @return duracion
   */
  public long getDuracion() {
    return duracion;
  }
  
  /**
   * Método para modificar la duracion
   * @param duracion
   * @return duracion
   */
  public void setDuracion(long duracion) {
    this.duracion = duracion;
  }
  
  /**
   * Método toString paa imprimir la información de un disco
   * @return cadena
   */
  public String toString() {
    String cadena = "\n------------------------------------------";
        cadena += "\nCódigo: " + this.codigo;  
        cadena += "\nAutor: " + this.autor;    
        cadena += "\nTítulo: " + this.titulo;
        cadena += "\nGénero: " + this.genero;
        cadena += "\nDuración: " + this.duracion;
        cadena += "\n------------------------------------------";

    return cadena;
  } 
}