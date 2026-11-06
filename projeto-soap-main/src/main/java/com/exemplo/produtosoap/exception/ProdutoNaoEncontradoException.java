package com.exemplo.produtosoap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT, faultStringOrReason = "Produto não encontrado no banco de dados")
public class ProdutoNaoEncontradoException extends RuntimeException {
    
    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}