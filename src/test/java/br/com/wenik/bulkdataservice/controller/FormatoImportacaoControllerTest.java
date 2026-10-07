package br.com.wenik.bulkdataservice.controller;

import br.com.wenik.bulkdataservice.service.FormatoImportacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FormatoImportacaoControllerTest {

    //Estamos dizendo ao Mockito "Crie um objeto
    //falso que implemente FormatoImportacaoService"

    @Mock
    private FormatoImportacaoService service;

    private FormatoImportacaoController controller;

    //Execute este metodo antes de cada teste.

    @BeforeEach
    void setUp() {
        controller =
                new FormatoImportacaoController(service);
                //instancia uma nova chamada.
    }

    @Test
    void deveRetornarFormatosFornecidosPeloService(){

        List<String> formatosEsperados = List.of("CSV");

        //Quando o metodo listarFormatosSuportados()
        // desse mock for chamado, retorne formatosEsperados.
        when(service.listarFormatosSuportados())
                .thenReturn(formatosEsperados);

        List<String> resultado =
                controller.listarFormatos();


        assertEquals(
                formatosEsperados,
                resultado
        );

        //Confirme que o Controller realmente chamou listarFormatosSuportados().
        verify(service).listarFormatosSuportados();
    }
}
