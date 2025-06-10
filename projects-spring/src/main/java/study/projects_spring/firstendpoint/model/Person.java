package study.projects_spring.firstendpoint.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Anotações do Lombok para gerar getters e setters automaticamente em tempo de compilação.
 * @Getter: Cria os métodos get (ex: getId(), getFirstName()).
 * @Setter: Cria os métodos set (ex: setId(), setFirstName()).
 */
@Getter
@Setter
public class Person implements Serializable {

    // Identificador de versão para a serialização. Ajuda a controlar versões da classe.
    @Serial
    private static final long serialVersionUID = 1L;

    // Atributos que representam os dados de uma pessoa.
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    // Construtor vazio. É necessário para que frameworks como o Jackson (que converte JSON para Objeto)
    // possam instanciar a classe.
    public Person(){}

    /**
     * Sobrescreve o método equals() para comparar dois objetos Person
     * pelo valor de seus atributos, e não pela referência de memória.
     * Essencial para verificar se duas instâncias representam a mesma pessoa.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getGender(), person.getGender());
    }

    /**
     * Sobrescreve o método hashCode() para gerar um código hash baseado nos atributos.
     * É uma boa prática sobrescrevê-lo sempre que o equals() é sobrescrito,
     * para garantir o funcionamento correto de coleções como HashMap e HashSet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
    }
}