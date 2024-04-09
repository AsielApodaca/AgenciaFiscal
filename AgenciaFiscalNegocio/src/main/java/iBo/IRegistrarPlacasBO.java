/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iBo;

import excepciones.NegocioException;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;
import negocioDTO.VehiculoDTO;

/**
 *
 * @author luiis
 */
public interface IRegistrarPlacasBO {
    public boolean registrarPlacas(TramitePlacasDTO placas) throws NegocioException;
    public boolean renovarPlacas(TramitePlacasDTO placas)throws NegocioException;
    public TramitePlacasDTO obtenerPlacasPorSerieAuto(VehiculoDTO vehiculo)throws NegocioException;
    public TramitePlacasDTO obtenerPlacasPorMatricula(TramitePlacasDTO placasAnteriores)throws NegocioException;
    public TramiteLicenciaDTO obtenerLicenciaVigente(TramiteLicenciaDTO licencia)throws NegocioException;
    public boolean actualizarEstadoPlacasAnteriores(TramitePlacasDTO placasAnteriores)throws NegocioException;
}
