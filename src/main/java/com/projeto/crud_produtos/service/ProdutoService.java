package com.projeto.crud_produtos.service;

import com.projeto.crud_produtos.dto.ProdutoDTO;
import com.projeto.crud_produtos.model.Categoria;
import com.projeto.crud_produtos.model.Produto;
import com.projeto.crud_produtos.repository.CategoriaRepository;
import com.projeto.crud_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoDTO criar(ProdutoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(categoria);

        Produto salvo = produtoRepository.save(produto);

        return toDTO(salvo);

        /*
        Long categoriaId = produto.getCategoria().getId();

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
         */
    }

    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setCategoriaId(produto.getCategoria().getId());
        return dto;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto atualizar(Long id, Produto produto) {
        Produto existente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());

        Long categoriaId = produto.getCategoria().getId();
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        existente.setCategoria(categoria);

        return produtoRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}