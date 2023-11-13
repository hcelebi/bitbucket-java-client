package io.github.hcelebi.bitbucket.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;

@Getter
@AllArgsConstructor
public class BitbucketRunTimeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3829641624015437540L;

    public BitbucketRunTimeException(String message) {
        super(message);
    }
}
