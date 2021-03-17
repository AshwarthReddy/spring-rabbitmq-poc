package anr.rabitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import anr.rabitmq.configs.RabbitMQProps;

@SpringBootApplication
@EnableConfigurationProperties(RabbitMQProps.class)
public class SpringRabitmqPocApplication {

  public static void main( String[] args ) {
    SpringApplication.run( SpringRabitmqPocApplication.class, args );
  }

}
