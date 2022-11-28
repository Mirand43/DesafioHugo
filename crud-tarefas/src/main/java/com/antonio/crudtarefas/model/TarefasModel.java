package com.antonio.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class TarefasModel {

    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 120, nullable = false)
    private String tarefa;

    @Column(length = 500, nullable = false)
    private String descrition;
    
}