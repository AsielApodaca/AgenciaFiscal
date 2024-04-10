/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iBo;

import negocioDTO.TramiteLicenciaDTO;
import excepciones.NegocioException;

public interface IBajaLicencia {
    TramiteLicenciaDTO obtenerLicencia(TramiteLicenciaDTO licencia) throws NegocioException;
    boolean darDeBajaLicencia(TramiteLicenciaDTO licencia) throws NegocioException;
}