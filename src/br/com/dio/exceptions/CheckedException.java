package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

//Imprimir um arquivo no console.
public class CheckedException {
    public static void main(String[] args) {
        String nomeDoArquivo = "romances-blake-crouch.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do arquivo que você deseja imprimir! " + e.getCause());
            e.printStackTrace();
        } catch (IOException e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getCause());
        } finally {
            System.out.println("Chegou no finally!");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    // imprimir conteudo de um arquivo  | se a funcao nao for chamada, o programa retornara IOException
    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName())); // obter o nome do arquivo
        String line = br.readLine(); // ler a primeira linha

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // imprimir no console

        do{
            bw.write(line); // escrever na a primeira linha
            bw.newLine(); // quebra de linha
            line=br.readLine(); // ler a proxima linha
        } while(line != null);
        bw.flush(); // limpar o buffer
        br.close(); // fechar o buffer
    }
}
