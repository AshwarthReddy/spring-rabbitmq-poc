package anr.rabitmq.configs;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import anr.rabitmq.dto.People;

@Component
public class RabbitMQListener {


  @RabbitListener(queues = "${rabbit.queue}")
  public void rabbitMQListener( Message message ) {
    String msg = new String( message.getBody() );
    People people = new Gson().fromJson( msg, People.class );

    System.out.println( "message received : " + people );


  }
}
