package br.com.alura.screemtch.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}

public class ConverterDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
