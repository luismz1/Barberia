/*Elaborado por:
Daniel Alemán Ruiz (2023051957)
Luis Meza Chavarría (2023800023)
David Matamoros Jiménez (2023800039)*/
package barberia.control;

// Paquetes utilizados
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// DataVerification: Clase encargada de controlar los datos y ver si estos son válidos así también como obtener
// información relevante para el control.
public class DataVerification {    
    
    /*Función sacada de:
    Mark Rotteveel. (2014, 24 de Setiembre). Get Week Number of LocalDate (Java 8) [duplicate].
    Stack Overflow. https://stackoverflow.com/questions/26012434/get-week-number-of-localdate-java-8*/
    public static int getWeekNumber(LocalDate fecha){
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
        return fecha.get(woy);
    }
    
    // Método que convierte un día en formato String a formato Integer.
   public static int stringDayToInt(String dia){
       return switch (dia) {
           case "Lunes" -> 0;
           case "Martes" -> 1;
           case "Miercoles" -> 2;
           case "Jueves" -> 3;
           case "Viernes" -> 4;
           case "Sabado" -> 5;
           default -> 6;
       };
   }
 
   // Método que convierte un día en formato Integer a formato String.
   public static String IntToStringDay(int dia){
       return switch (dia) {
           case 0 -> "Lunes";
           case 1 -> "Martes";
           case 2 -> "Miercoles";
           case 3 -> "Jueves";
           case 4 -> "Viernes";
           case 5 -> "Sabado";
           default -> "Domingo";
       };
   }
   
    /*Función sacada de:
    meetmavani.(2021, 23 de diciembre). Java Program to Check For a Valid Mobile Number. GeeksForGeeks.
    https://www.geeksforgeeks.org/java-program-to-check-for-a-valid-mobile-number/*/
    public static boolean validatePhoneNumber(String mobNumber){  
        //validates phone numbers having 10 digits (9998887776)
        return mobNumber.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
    }
    /*Función sacada de: 
    Johathan Cook.(2024, 8 de enero). Email Validation in Java. Baeldung.
    https://www.baeldung.com/java-email-validation-regex*/
    public static boolean validateEmail(String email){
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
