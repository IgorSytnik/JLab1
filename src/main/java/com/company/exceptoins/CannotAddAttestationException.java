package com.company.exceptoins;

public class CannotAddAttestationException
        extends RuntimeException {
    public CannotAddAttestationException() {
        super("Can't add attestation to subject");
    }
}
