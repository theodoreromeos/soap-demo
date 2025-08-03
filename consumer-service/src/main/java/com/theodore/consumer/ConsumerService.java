package com.theodore.consumer;

import com.ikh.generated.client.CreateUserRequest;
import com.ikh.generated.client.UserCreatedResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ConsumerService {

    private final WebServiceTemplate webServiceTemplate;

    public ConsumerService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    private final List<String> names = List.of("Sam", "Sarah",
            "Anthony", "Daniel", "Chuck", "Jackie");

    private final List<String> surnames = List.of("Brown", "White",
            "Cruise", "Waldorf", "Bass");

    public String getGreetings() {
        int randomNameIndex = ThreadLocalRandom.current().nextInt(names.size());
        String randomName = names.get(randomNameIndex);

        int randomSurnameIndex = ThreadLocalRandom.current().nextInt(surnames.size());
        String randomSurname = surnames.get(randomSurnameIndex);

        CreateUserRequest request = new CreateUserRequest();
        request.setName(randomName);
        request.setSurname(randomSurname);
        request.setJob("Engineer");

        UserCreatedResponse response = (UserCreatedResponse) webServiceTemplate.marshalSendAndReceive(request);

        return response.getGreeting();
    }

}
