package br.com.zupacademy.propostas.apiclients.cartoes;

import br.com.zupacademy.propostas.model.entities.Cartao;
import br.com.zupacademy.propostas.model.entities.Vencimento;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class VencimentoResponse {
    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;

    public VencimentoResponse(String id, Integer dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public Vencimento toModel(Cartao cartao) {
        return new Vencimento(id, dia, dataDeCriacao, cartao);
    }

    public String getId() {
        return id;
    }

    public Integer getDia() {
        return dia;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VencimentoResponse.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("dia=" + dia)
                .add("dataDeCriacao=" + dataDeCriacao)
                .toString();
    }
}
