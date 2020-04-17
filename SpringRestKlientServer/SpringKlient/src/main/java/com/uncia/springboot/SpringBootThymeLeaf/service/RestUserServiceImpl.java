package com.uncia.springboot.SpringBootThymeLeaf.service;

import com.uncia.springboot.SpringBootThymeLeaf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;


@Service
public class RestUserServiceImpl implements RestUserService {

    private RestTemplate restTemplate;

    private String RestUrl;
    private String allUsersRestUrl;
    private String userRestUrl;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public RestUserServiceImpl(RestTemplate theRestTemplate,
                               @Value("${crm.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        RestUrl = theUrl;
        allUsersRestUrl = theUrl + "/users";
        userRestUrl = theUrl + "/user";

        logger.info("Loaded property:  crm.rest.url=" + RestUrl);
    }

    @Override
    public List<User> allUsers() {

        logger.info("in getUsers(): Calling REST API " + allUsersRestUrl);
        // make REST call
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(allUsersRestUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<User>>() {
                        });
        // get the list of users from response
        List<User> users = responseEntity.getBody();
        logger.info("in getUsers(): Users" + users);
        return users;
    }

    @Override
    public void add(User user) {
        logger.info("in addUser(): Calling REST API " + userRestUrl);
        restTemplate.postForEntity(userRestUrl, user, String.class);

    }

    @Override
    public void addWithRolesID(User user) {
        logger.info("in addUser(): Calling REST API " + userRestUrl);
        //Задать вопрос Где добовлять роли из списка тут или на сервере?
        restTemplate.postForEntity(userRestUrl, user, String.class);

    }

    @Override
    public void delete(Integer id) {
        logger.info("in deleteUser(): Calling  REST API " + userRestUrl);
        restTemplate.delete(userRestUrl +"//"+id);
        logger.info("in deleteByIdUser(): theUserId=" + id);
    }

    @Override
    public void edit(User user) {
        logger.info("in editUser(): Calling REST API " + userRestUrl);
        restTemplate.put(userRestUrl, user);
    }

    @Override
    public void editWithRolesID(User user) {
        logger.info("in editUser(): Calling REST API " + userRestUrl);
        //Задать вопрос Где добовлять роли из списка тут или на сервере?
        restTemplate.put(userRestUrl, user);
    }

    @Override
    public User getById(Integer id) {
        logger.info("in getUser(): Calling  REST API " + userRestUrl);
        User theUser = restTemplate.getForObject(userRestUrl + "/" + id, User.class);
        logger.info("in getByIdUser(): theUser=" + theUser);
        return theUser;
    }

    @Override
    public User getByLogin(String login) {
        return null;
    }


}
