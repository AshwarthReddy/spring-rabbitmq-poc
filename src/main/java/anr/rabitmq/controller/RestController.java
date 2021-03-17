package anr.rabitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import anr.rabitmq.configs.RabbitMQProps;
import anr.rabitmq.dto.People;

@org.springframework.web.bind.annotation.RestController

public class RestController {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private RabbitMQProps rabbitMQProps;


  @PostMapping()
  public String testQueue( @RequestBody People people ) {

    rabbitTemplate.convertAndSend( rabbitMQProps.getExchange(), rabbitMQProps.getRoutingKey(), people );
    return "message sent successfully";
  }


}
