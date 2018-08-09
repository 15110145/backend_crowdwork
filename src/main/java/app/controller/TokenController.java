package app.controller;

import app.model.Token;
import app.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TokenController {

    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/findalltoken", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Token> findAllToken(){
        return tokenService.findAllToken();
    }

    @RequestMapping(value = "/findtoken/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Token> findToken(@PathVariable Integer id){
        return tokenService.findToken(id);
    }

    @RequestMapping(value = "/savetoken", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String saveToken(@RequestBody Token token){
        tokenService.save(token);
        return "Token Saved!";
    }

    @RequestMapping(value = "/updatetoken", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateToken(@RequestBody Token token){
        tokenService.update(token);
        return "Token Updated!";
    }

    @RequestMapping(value = "/deletetoken/{id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteToken(@PathVariable Integer id){
        tokenService.delete(id);
        return "Token deleted!";
    }

}
