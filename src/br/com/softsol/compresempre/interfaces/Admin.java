package br.com.softsol.compresempre.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
// Disponivel em tempo de execu��o
@Retention(RetentionPolicy.RUNTIME)
// Anota��o para m�todos
@Target(ElementType.METHOD)
public @interface Admin {
}
