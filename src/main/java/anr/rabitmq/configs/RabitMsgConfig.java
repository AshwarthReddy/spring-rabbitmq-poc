package anr.rabitmq.configs;


import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabitMsgConfig {

  @Autowired
  private RabbitMQProps rabbitMQProps;


  @Bean
  public Queue queue() {
    return new Queue( rabbitMQProps.getQueue() );
  }


  //  @Bean
  //  public TopicExchange topicExchange() {
  //    return new TopicExchange( rabbitMQProps.getExchange() );
  //  }


  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange( rabbitMQProps.getExchange() );
  }


  @Bean
  public Binding binding( Queue queue, DirectExchange directExchange ) {
    return BindingBuilder.bind( queue ).to( directExchange ).with( rabbitMQProps.getRoutingKey() );
  }

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
    cachingConnectionFactory.setUsername( rabbitMQProps.getUsername() );
    cachingConnectionFactory.setPassword( rabbitMQProps.getPassword() );
    cachingConnectionFactory.setHost( rabbitMQProps.getHost() );
    cachingConnectionFactory.setPort( rabbitMQProps.getPortNumber() );
    return cachingConnectionFactory;
  }

  @Bean
  public AmqpAdmin amqpAdmin( ConnectionFactory connectionFactory ) {
    return new RabbitAdmin( connectionFactory );
  }


  @Bean
  public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate( ConnectionFactory connectionFactory ) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate();
    rabbitTemplate.setConnectionFactory( connectionFactory );
    rabbitTemplate.setMessageConverter( messageConverter() );
    return rabbitTemplate;

  }


  //  @Bean
  //  public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
  //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
  //    container.setConnectionFactory(connectionFactory);
  //    container.setQueueNames(rabbitMQProps.getQueue());
  //    return container;
  //  }

  //  @Bean
  //  MessageListenerAdapter listenerAdapter(RabbitMqListener listener) {
  //    return new MessageListenerAdapter(listener, "listen");
  //  }


}
