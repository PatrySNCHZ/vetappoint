package es.vetappoint.dao.service;

public interface EncryptService {

    //Para encriptar la contraseña
    String encryptClave(String clave);

    //Para verificar si clave original es igual a la encriptada
    boolean verifyClave(String originalClave, String hashClave);
}
