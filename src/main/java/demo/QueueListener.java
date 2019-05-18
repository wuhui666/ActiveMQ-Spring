package demo;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author: wuhui
 * @time: 2019/5/18 14:30
 * @desc:
 */
@Component
public class QueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage)message).getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
