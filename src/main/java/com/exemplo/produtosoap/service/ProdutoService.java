package com.exemplo.produtosoap.service;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    public ProdutoDados buscarProduto(String codigo) {
        return switch (codigo) {
            case "1001" -> new ProdutoDados(
                    "Notebook",
                    "Notebook para estudos e programação",
                    "Lenovo",
                    15
            );
            case "1002" -> new ProdutoDados(
                    "Mouse",
                    "Mouse óptico USB",
                    "Logitech",
                    30
            );
            case "1003" -> new ProdutoDados(
                    "Teclado",
                    "Teclado mecânico USB",
                    "Redragon",
                    20
            );
            default -> null;
        };
    }

    public record ProdutoDados(
            String nome,
            String descricao,
            String marca,
            int quantidadeEstoque
    ) {
    }
}
