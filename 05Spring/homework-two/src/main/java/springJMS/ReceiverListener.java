package springJMS;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component("jmsListener")
public class ReceiverListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        try {
            System.out.println("监听到消息："+objectMessage.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
