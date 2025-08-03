package com.theodore.provider;

import com.ikh.generated.models.CreateUserRequest;
import com.ikh.generated.models.UserCreatedResponse;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {

    public UserCreatedResponse greet(CreateUserRequest request){
        String str =  "User " + request.getName() +
                " " + request.getSurname() +
                " created with job: " + request.getJob();
        var response = new UserCreatedResponse();
        response.setGreeting(str);
        return response;
    }

}
