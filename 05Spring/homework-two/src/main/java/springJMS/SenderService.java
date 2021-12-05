package springJMS;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import pojo.Student;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class SenderService {
    @Autowired
    JmsTemplate jmsTemplate;
    //这里使用final修饰参数，为了防止在传输的传输过程中被修改
    public void send(final Student student){
        jmsTemplate.send("test.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(JSON.toJSONString(student));
            }
        });
    }
}
