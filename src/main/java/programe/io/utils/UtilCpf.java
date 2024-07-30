/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programe.io.utils;


public class UtilCpf {

    /**
     * Formata um CPF no formato "XXX.XXX.XXX-XX".
     * @param cpf O CPF em formato numérico, sem pontos ou hífen.
     * @return O CPF formatado no formato "XXX.XXX.XXX-XX".
     */
    public static String formatarCpf(String cpf) {
        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos numéricos.");
        }
        
        // Adiciona a formatação ao CPF
        return cpf.substring(0, 3) + "." +
               cpf.substring(3, 6) + "." +
               cpf.substring(6, 9) + "-" +
               cpf.substring(9);
    }

}
