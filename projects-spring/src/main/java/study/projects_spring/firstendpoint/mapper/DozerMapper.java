package study.projects_spring.firstendpoint.mapper;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    // O Spring injeta automaticamente o Bean do Mapper que configuramos anteriormente.
    @Autowired
    private Mapper mapper;

    /**
     * Mapeia um objeto de origem para um objeto de destino de uma classe específica.
     *
     * Exemplo de uso no Service:
     * PersonDTO dto = DozerMapper.parseObject(personEntity, PersonDTO.class);
     *
     * @param origin      O objeto de origem a ser convertido.
     * @param destination A classe do objeto de destino.
     * @param <O>         Tipo do objeto de origem.
     * @param <D>         Tipo do objeto de destino.
     * @return Um novo objeto da classe de destino com os dados mapeados.
     */
    public <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    /**
     * Mapeia uma lista de objetos de origem para uma lista de objetos de destino.
     *
     * Exemplo de uso no Service:
     * List<PersonDTO> dtoList = DozerMapper.parseListObjects(personEntityList, PersonDTO.class);
     *
     * @param origin      A lista de objetos de origem a ser convertida.
     * @param destination A classe dos objetos de destino.
     * @param <O>         Tipo dos objetos de origem.
     * @param <D>         Tipo dos objetos de destino.
     * @return Uma nova lista de objetos da classe de destino com os dados mapeados.
     */
    public <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();
        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
