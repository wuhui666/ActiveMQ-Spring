import demo.QueueListener;
import junit.framework.TestResult;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpNE;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

/**
 * @author: wuhui
 * @time: 2019/5/18 14:38
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestMQ {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    ActiveMQQueue destination;
    @Autowired
    ActiveMQTopic destination_topic;
   /* @Autowired
    QueueListener listener;*/
    @Test
    public void testQueue(){

        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hello activeMQ2");
            }
        });
        System.out.println("send done");
    }
    @Test
    public void testTopic(){
        jmsTemplate.send(destination_topic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hello activeMQ topic!");
            }
        });
        System.out.println("send done");
    }

    @Test
    public void test() throws IOException {
        System.in.read();
    }


}
