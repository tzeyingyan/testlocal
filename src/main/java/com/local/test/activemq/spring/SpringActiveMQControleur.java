package com.local.test.activemq.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/produce")
public class SpringActiveMQControleur {
    private static final Logger logger = LoggerFactory.getLogger(SpringActiveMQControleur.class);
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue queue;

    @PostMapping("/message")
    public ObjetDTO envoiMessage(@RequestBody ObjetDTO objetDTO) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String studentAsJson = mapper.writeValueAsString(objetDTO);

            jmsTemplate.convertAndSend(queue, studentAsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objetDTO;
    }

}
