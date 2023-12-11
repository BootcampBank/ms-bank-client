package com.bc48.mscliente.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "client")
public class Client {
    @Id
    private String id;
    @NotNull
    private String documentType;
    @NotNull
    private String documentNumber;
    private String name;
    private String lastName;
    private String businessName;
    private String clientType;
    private String clientProfile;

}
