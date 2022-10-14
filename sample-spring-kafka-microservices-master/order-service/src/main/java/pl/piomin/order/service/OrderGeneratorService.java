package pl.piomin.order.service;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import pl.piomin.base.domain.Order;

@Service
public class OrderGeneratorService {

    private static Random RAND = new Random();
    private AtomicLong id = new AtomicLong();
    private KafkaTemplate<Long, Order> template;

    public OrderGeneratorService(Executor executor, KafkaTemplate<Long, Order> template) {
        this.template = template;
    }

    @Async
    public void generate() {
        for (int i = 0; i < 100; i++) {
            int x = RAND.nextInt(5) + 1;
            Order o = new Order(id.incrementAndGet(), RAND.nextLong() + 1, RAND.nextLong() + 1, "NEW");
            o.setPrice(100 * x);
            o.setProductCount(x);
            template.send("orders", o.getId(), o);
        }
    }
}
