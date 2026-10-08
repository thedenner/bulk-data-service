package br.com.wenik.bulkdataservice.controller;

import br.com.wenik.bulkdataservice.service.FormatoImportacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//Monte apenas a infraestrutura Spring MVC necessária para testar FormatoImportacaoController.
@WebMvcTest(FormatoImportacaoController.class)
class FormatoImportacaoControllerWebTest {

    @Autowired
    private MockMvc mockMvc;
    //MockMvc permite executar requisições contra a infraestrutura
    //Spring MVC sem iniciar um servidor HTTP real

    @MockitoBean
    private FormatoImportacaoService service;

    @Test
    void deveRetornarFormatosSuportadosViaHttp() throws Exception {
        when(service.listarFormatosSuportados()).
                thenReturn(List.of("CSV"));

        mockMvc.perform(
                get("/api/importacoes/formatos"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").value("CSV"));

        //perform(get("api/importacoes/formatos")) - execute essa requisição
        //andExpect(status().isOk()) - Esperamos que o resultado seja 200
        //andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) - esperamos
        //que a resposta seja compatível com JSON
        //andExpect(jsonPath("$[0]").value("CSV")) - e que o primeiro ‘item’ do ARRAY dentro do JSON seja "CSV"
        //$ = raiz do JSON e [0] é o ‘item’ do ARRAY.

        verify(service).listarFormatosSuportados();
    }

}
