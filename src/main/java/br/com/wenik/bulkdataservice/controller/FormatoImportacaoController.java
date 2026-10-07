package br.com.wenik.bulkdataservice.controller;

import br.com.wenik.bulkdataservice.service.FormatoImportacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/importacoes")
public class FormatoImportacaoController {

     private final FormatoImportacaoService service;

     //"Para criar o FormatoImportaçãoController, eu preciso obrigatoriamente de passar uma instância
     //de FormatoImportaçãoService para o seu construtor. Portanto, o Controller depende do Service".

     public FormatoImportacaoController(FormatoImportacaoService service){
         this.service = service;
     }

     @GetMapping("/formatos")
    public List<String> listarFormatos(){
         return service.listarFormatosSuportados();
     }

}
