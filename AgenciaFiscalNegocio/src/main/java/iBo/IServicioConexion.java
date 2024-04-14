package iBo;

/**
 * Interfaz que define un método para cerrar una conexión con un servicio externo.
 * 
 * <p>Esta interfaz proporciona un único método para cerrar una conexión con un servicio externo.</p>
 * 
 * <p>Es responsabilidad de las clases que implementan esta interfaz proporcionar la lógica necesaria para cerrar la conexión correctamente.</p>
 * 
 * <p>El método {@code cerrarConexion()} debe ser llamado cuando se desee finalizar la conexión con el servicio externo.</p>
 * 
 * @author luiis
 */
public interface IServicioConexion {
    /**
     * Cierra la conexión con el servicio externo.
     */
    public void cerrarConexion();
}
