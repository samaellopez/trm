
package com.curso.conversion.repository;

import com.curso.conversion.model.TRMDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author omayen
 */
@ApplicationScoped
public class TRMRepository {
    
    public List<TRMDTO> getAllTRMs() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<TRMDTO> trms;

        try (InputStream is = getClass().getResourceAsStream("/trm.json")) {
            trms = objectMapper.readValue(is, new TypeReference<List<TRMDTO>>() {});
            return trms;
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }
    }

    public TRMDTO getLatestTRM() {
        List<TRMDTO> trms = getAllTRMs();
        if (!trms.isEmpty()) {
            return trms.get(0);
        }
        return null; 
    }
    
}
