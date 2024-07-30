/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.utils;

/**
 *
 * @author nicsondev
 */
public class UtilCrm {

    public static String formatCrm(String crm) {
        if (crm == null || crm.length() < 8) {
            throw new IllegalArgumentException("A String deve ter pelo menos 8 caracteres.");
        }

        String estado = crm.substring(0, 2).toUpperCase(); // Extrai os primeiros dois caracteres
        String numero = crm.substring(5); // Extrai os caracteres após os 5 primeiros (ignorando o prefixo 'crmsp')

        // Formata a string no formato "CRM-SP 12345"
        return "CRM-" + estado + " " + numero;
    }

}
