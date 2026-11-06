package com.exemplo.produtosoap.endpoint;

import com.exemplo.produtosoap.service.ProdutoService;
import com.exemplo.produtosoap.ws.GetProdutoRequest;
import com.exemplo.produtosoap.ws.GetProdutoResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProdutoEndpoint {

    private static final String NAMESPACE = "http://exemplo.com/produtos";

    private final ProdutoService produtoService;

    public ProdutoEndpoint(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getProdutoRequest")
    @ResponsePayload
    public GetProdutoResponse buscarProduto(@RequestPayload GetProdutoRequest request) {

        ProdutoService.ProdutoDados produto =
                produtoService.buscarProduto(request.getCodigo());

        GetProdutoResponse response = new GetProdutoResponse();

        if (produto != null) {
            response.setNome(produto.nome());
            response.setDescricao(produto.descricao());
            response.setMarca(produto.marca());
            response.setQuantidadeEstoque(produto.quantidadeEstoque());
        } else {
            response.setNome("Produto não encontrado");
            response.setDescricao("Nenhum produto foi encontrado para o código informado.");
            response.setMarca("-");
            response.setQuantidadeEstoque(0);
        }

        return response;
    }
}
