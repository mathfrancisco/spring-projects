package study.projects_spring.firstendpoint.model.dto.v2; // É uma boa prática colocar DTOs em um pacote separado

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO para a entidade Person.
 * Contém os mesmos campos da entidade para facilitar o mapeamento automático com o Dozer.
 * É usado para transferir dados entre as camadas do serviço e a API,
 * protegendo a entidade de ser exposta diretamente.
 */
@Getter
@Setter
public class PersonDtoV2 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Atributos que espelham a entidade Person
    private Long id;
    private String firstName;
    private String lastName;
    private Date  birthDay;
    private String address;
    private String gender;

    // Construtor vazio
    public PersonDtoV2() {}

    // É uma boa prática manter os métodos equals() e hashCode() no DTO também,
    // especialmente se você for usá-los em coleções ou para comparações em testes.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDtoV2 personDTO = (PersonDtoV2) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName, personDTO.firstName) && Objects.equals(lastName, personDTO.lastName)&& Objects.equals(birthDay, personDTO.birthDay) && Objects.equals(address, personDTO.address) && Objects.equals(gender, personDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName,birthDay, address, gender);
    }
}