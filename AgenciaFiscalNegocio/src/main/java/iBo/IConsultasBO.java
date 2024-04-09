/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iBo;

import excepciones.NegocioException;
import java.util.List;
import negocioDTO.PersonaDTO;

/**
 *
 * @author luiis
 */
public interface IConsultasBO {
    public List<PersonaDTO> consultarPersonasPorNombre(PersonaDTO persona)throws NegocioException;
}
