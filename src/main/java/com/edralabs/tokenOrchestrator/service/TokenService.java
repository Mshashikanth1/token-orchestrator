package com.edralabs.tokenOrchestrator.service;

import com.edralabs.tokenOrchestrator.exception.TokenOrchestationServiceException;
import com.edralabs.tokenOrchestrator.model.Token;
import com.edralabs.tokenOrchestrator.model.response.TokenInfoResponse;
import com.edralabs.tokenOrchestrator.repository.TokenRepository;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class TokenService {
    TokenRepository tokenRepository=new TokenRepository();
    public TokenInfoResponse addToken(){
        final Token token =new Token(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now().plusMinutes(5));
        final int tokenId=tokenRepository.save(token);
        return convertToResponse(tokenId,token);
    }

    public Token getAvailableKey() {
       final Map.Entry<Integer, Token> entry= tokenRepository.findAll()
                       .stream()
                       .findFirst()
                       .orElseThrow( ()-> new TokenOrchestationServiceException(HttpStatus.NOT_FOUND,"no token found plz create a new one"));


       /*block the used token for 1 min*/
        tokenRepository.remove(entry.getKey());
        Token token= entry.getValue();


        token.setBlocked(true);
        token.setNextAutoUnBlockAt(LocalDateTime.now().plusMinutes(1));
        tokenRepository.saveToBlockedTokenDb(token);

        return  token;

    }

    public TokenInfoResponse getKeyInfo(final Integer id) {
           if( tokenRepository.isTokenExistsTokenDb(id))
           return  Optional.of(tokenRepository.findOne(id))
                   .map( token -> convertToResponse(id, token))
                   .orElseThrow( ()-> new TokenOrchestationServiceException(HttpStatus.INTERNAL_SERVER_ERROR,"Intenal Error : not able to map to token info response"));

           else if( tokenRepository.isTokenExistsBlockedTokenDb(id) )
            return  Optional.of(tokenRepository.findOneBlockedToken(id))
                    .map( token -> convertToResponse(id, token))
                    .orElseThrow( ()-> new TokenOrchestationServiceException(HttpStatus.INTERNAL_SERVER_ERROR,"Intenal Error : not able to map to token info response"));

           else throw  new TokenOrchestationServiceException(HttpStatus.NOT_FOUND,"NOT FOUND : plz create a new one");
    }

    private TokenInfoResponse convertToResponse(final Integer id,final  Token token) {

        return new TokenInfoResponse(
                id,
                token.getCreatedAt(),
                token.getExpiresAt(),
                token.getBlocked(),
                token.getNextAutoUnBlockAt()
           );
    }

    public void removeKey(final Integer id) {
            if (tokenRepository.isTokenExistsBlockedTokenDb(id ) ) { tokenRepository.removeFromBlockedTokenDb(id); }
            else if( tokenRepository.isTokenExistsTokenDb(id)) tokenRepository.remove(id);
            else throw  new TokenOrchestationServiceException(HttpStatus.NOT_FOUND,"NOT FOUND : token not found");
    }

    public int removeExpiredTokensFromDB() {
        Set<Integer> expriedTokenIds = tokenRepository.findAll()
                  .stream()
                  .filter( entry -> LocalDateTime.now().isAfter(entry.getValue().getExpiresAt()))
                  .map(Map.Entry::getKey)
                  .collect(Collectors.toSet());
        expriedTokenIds.forEach(id -> tokenRepository.remove(id));
        return expriedTokenIds.size();

    }

    public long unblockKeys() {
        Set<Integer> unblockedTokens = tokenRepository.findAllBlockedDb()
                    .stream()
                    .filter(entrySet -> LocalDateTime.now().isAfter(entrySet.getValue().getNextAutoUnBlockAt()))
                    .map(tokenEntry -> {
                        Token token= tokenEntry.getValue();
                        token.setBlocked(false);
                        token.setNextAutoUnBlockAt(null);
                        tokenRepository.save(token);
                        return tokenEntry.getKey();
                    }).collect(Collectors.toSet());


        unblockedTokens.forEach(id-> tokenRepository.removeFromBlockedTokenDb(id));
        return unblockedTokens.size();
    }

    public void unBlockToken(Integer id) {
        Token token= tokenRepository.findOneBlockedToken(id);
        token.setBlocked(false);
        token.setNextAutoUnBlockAt(null);

        tokenRepository.removeFromBlockedTokenDb(id);
        tokenRepository.save(token);
    }
}
