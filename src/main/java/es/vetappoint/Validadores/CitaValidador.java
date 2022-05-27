package es.vetappoint.Validadores;

import es.vetappoint.entities.Cita;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CitaValidador implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // Verificamos que la clase Cita se puede validar vía clazz
        return Cita.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 1 - Recibimos el objeto fecha (de la cita)

        // 2 - 
    }
}
