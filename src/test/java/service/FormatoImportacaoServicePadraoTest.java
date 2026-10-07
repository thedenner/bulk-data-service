package service;

import br.com.wenik.bulkdataservice.service.FormatoImportacaoServicePadrao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class FormatoImportacaoServicePadraoTest {

    @Test
    void deveRetornarCvsComoFormatoSuportado(){

        FormatoImportacaoServicePadrao service =
        new FormatoImportacaoServicePadrao();

        List<String> resultado = service.listarFormatosSuportados();

        assertEquals(List.of("CSV"), resultado);
    }
}
