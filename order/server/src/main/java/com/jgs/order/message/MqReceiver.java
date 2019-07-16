package com.imooc.order.message;

import com.esotericsoftware.minlog.Log;
import io.lettuce.core.dynamic.annotation.Key;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.stream.annotation.Bindings;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {
    //@RabbitListener(queues = "myQueue")
    //自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("myQueue"))


    /**
     * 数码供应商接受消息
     * @param message
     */
    @RabbitListener(bindings=@QueueBinding(
            exchange=@Exchange("myOrder"),
            key=("computer"),
            value=@Queue("computerOrder")
    ))
    public void processComputer(String message){
        Log.info("computer MqReceiver:{}",message);
    }

    /**
     * 水果供应商接受消息
     * @param message
     */
    @RabbitListener(bindings=@QueueBinding(
            exchange=@Exchange("myOrder"),
            key=("fruit"),
            value=@Queue("fruitOrder")
    ))
    public void processFruit(String message){
        Log.info("fruit MqReceiver:{}",message);
    }
}
