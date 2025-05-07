/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author DAM110
 */
public class Teclado {

    public String email() {
        boolean validado = false;
        String email = "";
        do {
            try {
                email = new Scanner(System.in).nextLine();
                validado = email.matches("^[^@\\s]+@[^@\\s]+\\.(es|com)$");
            } catch (InputMismatchException e) {
                System.out.println("Email no válido");
            }
        } while (!validado);
        return email;
    }

    public String nombre() { //valida nombre o apellido
        boolean validado = false;
        String nombre = "";
        do {
            try {
                nombre= new Scanner(System.in).nextLine();
                validado = nombre.matches("[A-Za-z]{2,}");
            } catch (InputMismatchException e) {
                System.out.println("Nombre no válido");
            }
        } while (!validado);
        return nombre;
    }
    
    public LocalDate fechaNac(){
        boolean validado = false;
        
    }
}
