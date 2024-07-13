package com.edralabs.tokenOrchestrator.controller;

import com.edralabs.tokenOrchestrator.model.Token;
import com.edralabs.tokenOrchestrator.model.response.TokenInfoResponse;
import com.edralabs.tokenOrchestrator.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class TokenOrchestrator {
        TokenService tokenService= new TokenService();

        @PostMapping("/create-key")  /*  T : O(1) */
        public ResponseEntity<TokenInfoResponse> createNewKey(){
            return ResponseEntity.ok(tokenService.addToken());
        }

        @GetMapping("/available-key")  /*  T : O(1) */
        public ResponseEntity<Token> getAvailableKey(){
            return ResponseEntity.ok(tokenService.getAvailableKey());
        }

    @GetMapping("/info-key/{id}")
    public ResponseEntity<TokenInfoResponse> getAvailableKey(@PathVariable Integer id){
        return ResponseEntity.ok(tokenService.getKeyInfo(id));
    }

    @DeleteMapping("remove-key/{id}")
    public ResponseEntity<String> removeKey(@PathVariable Integer id){
            tokenService.removeKey(id);
            return ResponseEntity.ok("token deleted");
    }

    @PutMapping("unblock-key/{id}")
    public ResponseEntity<String> unBlockToken(@PathVariable Integer id){
            tokenService.unBlockToken(id);
            return  ResponseEntity.ok("toke un blocked");
    }


    /* cron job for auto operations jobs*/
    @DeleteMapping("/remove-expired-keys")
    public ResponseEntity<String> removeExpiredTokensFromDBCron(){
          final long expiredKeys= tokenService.removeExpiredTokensFromDB();
        return ResponseEntity.ok("remove expired keys operations sucessful, total expired keys are :" + expiredKeys);
    }

    @PutMapping("/auto-unblock-keys")
    public ResponseEntity<String> autoUnblockKeysCron(){
        final  long unblockedKeys =tokenService.unblockKeys();
        return ResponseEntity.ok("operation auto unblock keys are successfull , total unblocked keys are : "+unblockedKeys );
    }

}
