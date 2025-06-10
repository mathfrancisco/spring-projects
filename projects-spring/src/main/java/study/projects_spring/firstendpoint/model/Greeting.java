package study.projects_spring.firstendpoint.model;

/**
 * 'record' é um recurso do Java moderno para criar classes imutáveis de dados (DTOs).
 * O compilador gera automaticamente:
 * - Construtor com todos os parâmetros (id, content).
 * - Métodos 'get' (ex: id(), content()).
 * - Métodos equals(), hashCode() e toString().
 *
 * É perfeito para representar objetos simples como uma resposta JSON.
 */
public record Greeting(long id, String content) {
}