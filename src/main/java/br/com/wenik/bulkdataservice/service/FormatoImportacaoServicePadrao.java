package br.com.wenik.bulkdataservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatoImportacaoServicePadrao implements FormatoImportacaoService {

    @Override
    public List<String> listarFormatosSuportados(){
        return List.of("CSV");
    }
}
