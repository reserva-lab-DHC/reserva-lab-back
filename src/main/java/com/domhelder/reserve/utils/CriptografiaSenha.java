package com.domhelder.reserve.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CriptografiaSenha {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String criptografarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }

    public static boolean verificarSenha(String senhaDigitada, String senhaCriptografada) {
        return passwordEncoder.matches(senhaDigitada, senhaCriptografada);
    }
}
