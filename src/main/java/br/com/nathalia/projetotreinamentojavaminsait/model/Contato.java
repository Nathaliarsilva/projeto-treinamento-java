package br.com.nathalia.projetotreinamentojavaminsait.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1)
    private Integer tipo;

    @Column(nullable = false)
    private String contato;

    private Long pessoa_id;
}
