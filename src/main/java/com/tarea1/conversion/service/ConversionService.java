
package com.tarea1.conversion.service;

import com.tarea1.conversion.model.TRMDTO;
import com.tarea1.conversion.repository.TRMRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 *
 * @author omayen
 */

@ApplicationScoped
public class ConversionService {
    
    @Inject
    TRMRepository trmRepository;

    public Double convertUSDToCOP(Double amountInUSD) {
        TRMDTO latestTRM = trmRepository.getLatestTRM();
        return amountInUSD * Double.parseDouble(latestTRM.getValor());
    }
}
