package anr.rabitmq.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix= "rabbit")
public class RabbitMQProps {

  private String queue;
  private String exchange;
  private String routingKey;
  @Value( "${spring.rabbitmq.username}" )
  private String username;
  @Value( "${spring.rabbitmq.password}" )
  private String password;
  @Value( "${spring.rabbitmq.port}" )
  private int portNumber;
  @Value( "${spring.rabbitmq.host}" )
  private String host;
  public String getQueue() {
    return queue;
  }

  public void setQueue( String queue ) {
    this.queue = queue;
  }

  public String getExchange() {
    return exchange;
  }

  public void setExchange( String exchange ) {
    this.exchange = exchange;
  }

  public String getRoutingKey() {
    return routingKey;
  }

  public void setRoutingKey( String routingKey ) {
    this.routingKey = routingKey;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername( String username ) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword( String password ) {
    this.password = password;
  }

  public String getHost() {
    return host;
  }

  public void setHost( String host ) {
    this.host = host;
  }

  public int getPortNumber() {
    return portNumber;
  }

  public void setPortNumber( int portNumber ) {
    this.portNumber = portNumber;
  }
}
