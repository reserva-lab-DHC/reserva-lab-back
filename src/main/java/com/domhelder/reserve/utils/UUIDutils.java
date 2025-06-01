package com.domhelder.reserve.utils;

import java.util.UUID;

public class UUIDutils {

    public static UUID convertStringtoUUID(String uuidString) {
        try {
            return UUID.fromString(uuidString);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Formato de UUID inválido: " + uuidString, e);
        }
    }
    public static String convertUUIDtoString(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("UUID não pode ser nulo");
        }
        return uuid.toString();
    }
}
