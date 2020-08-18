package br.com.itau.mastertech.acesso.access.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "access")
public class AccessEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    @JsonIgnore
    private Integer id;

    @Column
    private Integer clientId;

    @Column
    private Integer doorId;
}
