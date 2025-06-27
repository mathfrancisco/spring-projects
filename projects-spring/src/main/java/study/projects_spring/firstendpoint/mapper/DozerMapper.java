package study.projects_spring.firstendpoint.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

// Esta classe agora funciona como uma classe utilitária estática.
// Não precisa ser um Bean do Spring (@Service, @Component, etc.)
public class DozerMapper {

    // Criamos uma única instância estática do Mapper que será usada por todos os métodos.
    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    /**
     * Mapeia um objeto de origem para um objeto de destino de uma classe específica.
     * O método agora é estático.
     *
     * Exemplo de uso no Service:
     * PersonDto dto = DozerMapper.parseObject(personEntity, PersonDto.class);
     *
     * @param origin      O objeto de origem a ser convertido.
     * @param destination A classe do objeto de destino.
     * @param <O>         Tipo do objeto de origem.
     * @param <D>         Tipo do objeto de destino.
     * @return Um novo objeto da classe de destino com os dados mapeados.
     */
    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    /**
     * Mapeia uma lista de objetos de origem para uma lista de objetos de destino.
     * O método agora é estático.
     *
     * Exemplo de uso no Service:
     * List<PersonDto> dtoList = DozerMapper.parseListObjects(personEntityList, PersonDto.class);
     *
     * @param origin      A lista de objetos de origem a ser convertida.
     * @param destination A classe dos objetos de destino.
     * @param <O>         Tipo dos objetos de origem.
     * @param <D>         Tipo dos objetos de destino.
     * @return Uma nova lista de objetos da classe de destino com os dados mapeados.
     */
    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();
        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}