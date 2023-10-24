
package com.curso.service;

import com.curso.conversion.TRM;
import com.curso.repository.TRMRepository;
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
        TRM latestTRM = trmRepository.getLatestTRM();
        return amountInUSD * Double.parseDouble(latestTRM.getValor());
    }
}
