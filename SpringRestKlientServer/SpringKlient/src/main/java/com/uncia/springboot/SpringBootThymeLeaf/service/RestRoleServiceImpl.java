package com.uncia.springboot.SpringBootThymeLeaf.service;

import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
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
public class RestRoleServiceImpl implements RestRoleService {

    private RestTemplate restTemplate;

    private String RestUrl;
    private String allRolesRestUrl;
    private String roleRestUrl;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public RestRoleServiceImpl(RestTemplate theRestTemplate,
                               @Value("${crm.rest.url}") String theUrl) {
        restTemplate = theRestTemplate;
        RestUrl = theUrl;
        allRolesRestUrl = theUrl + "/roles";
        roleRestUrl = theUrl + "/role";

        logger.info("Loaded property:  crm.rest.url=" + RestUrl);
    }




    @Override
    public void addRole(Role role) {
        logger.info("in addRole(): Calling REST API " + roleRestUrl);
        restTemplate.postForEntity(roleRestUrl, role, String.class);
    }

    @Override
    public void delete(Integer id) {
        logger.info("in deleteRole(): Calling  REST API " + roleRestUrl);
        restTemplate.delete(roleRestUrl + "/" + id);
        logger.info("in deleteByIdRole(): theRoleId=" + id);

    }

    @Override
    public Role getById(Integer id) {
        logger.info("in getRole(): Calling  REST API " + roleRestUrl);
        Role theRole = restTemplate.getForObject(roleRestUrl + "/" + id, Role.class);
        logger.info("in getByIdRole(): theRole=" + theRole);
        return theRole;
    }

    @Override
    public void editRole(Role role) {
        logger.info("in editRole(): Calling REST API " + roleRestUrl);
        restTemplate.put(roleRestUrl, role);
    }

    @Override
    public List<Role> getAll() {
        logger.info("in getRoles(): Calling REST API " + allRolesRestUrl);
        ResponseEntity<List<Role>> responseEntity =
                restTemplate.exchange(allRolesRestUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Role>>() {
                        });
        List<Role> roles = responseEntity.getBody();
        logger.info("in getRoles(): Roles" + roles);
        return roles;
    }
}
