package com.edralabs.tokenOrchestrator.repository;

import com.edralabs.tokenOrchestrator.model.Token;

import java.util.*;

public class TokenRepository {

                        /* ublocked tokesns*/
    Map<Integer, Token> tokenDb = new TreeMap<>(),  /*n^2*/
            blockedTokenDb= new TreeMap<>() ;


    public int save(Token token){
        final int generatedId=tokenDb.size()+1;
        tokenDb.put(generatedId,token);
        return generatedId;
    }

    public Set<Map.Entry<Integer, Token>> findAll(){
        return  tokenDb.entrySet();
    }

    public  Boolean isTokenExistsTokenDb(final Integer key) {
        return tokenDb.containsKey(key);
    }



    public  Token  findOne(final Integer key){
        return tokenDb.get(key);
    }

    public void remove(final  Integer id){
        tokenDb.remove(id);
    }






    public int saveToBlockedTokenDb(Token token){
        final int generatedId=blockedTokenDb.size()+1;
        blockedTokenDb.put(generatedId,token);
        return generatedId;
    }

    public Set<Map.Entry<Integer, Token>> findAllBlockedDb(){
        return  blockedTokenDb.entrySet();
    }
    public void removeFromBlockedTokenDb(final  Integer id) {
        blockedTokenDb.remove(id);
    }

    public  Boolean isTokenExistsBlockedTokenDb(final Integer key) {
        return blockedTokenDb.containsKey(key);
    }


    public Token findOneBlockedToken(Integer id) {
        return blockedTokenDb.get(id);
    }
}
