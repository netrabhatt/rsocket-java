package io.rsocket.core;

import io.rsocket.RSocketClient;
import java.util.List;
import org.reactivestreams.Publisher;

public class LoadbalancedRSocketConnector {
  LoadbalanceStrategy loadbalanceStrategy = new RoundRobinLoadbalanceStrategy();

  public static LoadbalancedRSocketConnector builder() {
    return new LoadbalancedRSocketConnector();
  }

  public LoadbalancedRSocketConnector withLoadbalanceStrategy(
      LoadbalanceStrategy loadbalanceStrategy) {
    this.loadbalanceStrategy = loadbalanceStrategy;

    return this;
  }

  public RSocketClient createClient(Publisher<List<LoadbalanceTarget>> rSocketSuppliersPublisher) {
    return new LoadBalancedRSocketClient(
        new RSocketPool(rSocketSuppliersPublisher, loadbalanceStrategy));
  }
}
