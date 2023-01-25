package its.statea.consumerforecasts.queue.kafka;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import its.statea.consumerforecasts.queue.message.ErrorMessage;
import its.statea.consumerforecasts.queue.message.MyMessage;

@Service
public class KafkaService {
    
    private static final String mainTopic = "forecastsTopic";
    private static final String errorTopic = "errorTopic";

    @Autowired
    private KafkaTemplate<String, MyMessage> kafkaTemplate;

    public void sendMessage(MyMessage message) throws InterruptedException, ExecutionException {

        // get() makes it synchronous
        this.kafkaTemplate.send(mainTopic, message).get();
    }

    public void sendError(Exception ex) {

        this.kafkaTemplate.send(errorTopic, new ErrorMessage("Critical Error " + ex.getMessage())); 
    }
}
