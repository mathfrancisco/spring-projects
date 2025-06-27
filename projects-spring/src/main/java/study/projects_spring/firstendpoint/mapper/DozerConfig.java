package study.projects_spring.firstendpoint.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração para o Dozer.
 * A anotação @Configuration indica ao Spring que esta classe contém
 * definições de beans que devem ser gerenciados pelo contêiner do Spring.
 */
@Configuration
public class DozerConfig {

    /**
     * Cria e configura um Bean do tipo Mapper (Dozer).
     * Este Bean será um singleton, ou seja, uma única instância será compartilhada
     * por toda a aplicação. O Spring gerenciará seu ciclo de vida.
     *
     * @return Uma instância configurada do Mapper do Dozer.
     */
    @Bean
    public Mapper dozerMapper() {
        // DozerBeanMapperBuilder.buildDefault() cria um mapeador com as configurações padrão,
        // que já é capaz de mapear campos com o mesmo nome automaticamente.
        return DozerBeanMapperBuilder.buildDefault();
    }
}