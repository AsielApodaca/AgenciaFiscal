/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iBo;

import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;
import negocioDTO.VehiculoDTO;

/**
 *
 * @author luiis
 */
public interface IRegistrarPlacasBO {
    public boolean registrarPlacas(TramitePlacasDTO placas);
    public boolean renovarPlacas(TramitePlacasDTO placas);
    public TramitePlacasDTO obtenerPlacasPorSerieAuto(VehiculoDTO vehiculo);
    public TramitePlacasDTO obtenerPlacasPorMatricula(TramitePlacasDTO placasAnteriores);
    public TramiteLicenciaDTO obtenerLicenciaVigente(TramiteLicenciaDTO licencia);
    public boolean actualizarEstadoPlacasAnteriores(TramitePlacasDTO placasAnteriores);
}
