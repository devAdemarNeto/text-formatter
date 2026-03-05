package br.com.ademar.textformatter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Agente de Formatação N2 - API")
                        .version("1.0")
                        .description("API para automação de chamados do suporte N2 do TJPA. "
                                + "Permite gerar textos padronizados para escalonamento PJe, "
                                + "substituição de monitor, remoção do AD, devolução de equipamento "
                                + "e consultar o histórico de chamados gerados.")
                        .contact(new Contact()
                                .name("Suporte N2 - TJPA")
                                .email("suporte@tjpa.jus.br")));
    }
}
