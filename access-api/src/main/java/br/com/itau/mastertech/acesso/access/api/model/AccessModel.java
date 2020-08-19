package br.com.itau.mastertech.acesso.access.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccessModel {

    private Integer clientId;
    private Integer doorId;
    private Boolean hasAccess;
}
