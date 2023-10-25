
package com.curso.conversion.service;

import com.curso.conversion.model.TRMDTO;
import com.curso.conversion.repository.TRMRepository;

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
