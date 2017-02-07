package br.com.softsol.compresempre.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
// Disponivel em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
// Anotação para métodos
@Target(ElementType.METHOD)
public @interface Admin {
}
