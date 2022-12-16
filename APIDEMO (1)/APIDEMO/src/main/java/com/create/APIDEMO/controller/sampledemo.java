package com.create.APIDEMO.controller;

import com.create.APIDEMO.model.Rest;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

    @RestController
    @RequestMapping("/user")
    public class sampledemo{
        Map<String , Rest> allUsers = new HashMap<>();

        @GetMapping
        public Collection<Rest> getCall(){
            return allUsers.values();

        }
        @PostMapping
        public String postCall(@RequestBody Rest userDetails){
            Rest addValue = new Rest();
            addValue.setUserID(userDetails.getUserID());
            addValue.setUserFirstName(userDetails.getUserFirstName());
            addValue.setUserLastName(userDetails.getUserLastName());
            addValue.setUserEmail(userDetails.getUserEmail());
            allUsers.put(userDetails.getUserID(),addValue);
            return "Added!!";
        }
        @DeleteMapping(path = "/{userID}" )
        public String deleteCall(@PathVariable String userID){
            if(allUsers.containsKey(userID)){
                allUsers.remove(userID);
                return "User Has Been Removed !! ";
            }else {
                return "Invalid UserID";
            }
        }
        @PutMapping(path = "/{userID}" )
        public String putCall(@PathVariable String userID , @RequestBody Rest userDetails){
            if(allUsers.containsKey(userID)){
                Rest addValue = new Rest();
                addValue.setUserID(userDetails.getUserID());
                addValue.setUserFirstName(userDetails.getUserFirstName());
                addValue.setUserLastName(userDetails.getUserLastName());
                addValue.setUserEmail(userDetails.getUserEmail());
                allUsers.put(userID,addValue);
                return "Modified Successfully";
            }else {
                return "Invalid UserID";
            }
        }
    }





