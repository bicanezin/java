package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ControleTexto {

    private File arquivo;

    public ControleTexto(File arq) {
        arquivo = arq;
    }

    public boolean Escreve(String aux, boolean append) {
        boolean r = false;

        try {
            BufferedWriter escritabuffer
                    = new BufferedWriter(new FileWriter(
                            getArquivo(), append));
            escritabuffer.write(aux + "\n");
            escritabuffer.flush();
            escritabuffer.close();
            r = true;

        } catch (IOException erro) {
            System.err.println("Erro na escrita do arquivo");
        }

        return r;
    }

    public String Le() {
        StringBuffer aux = new StringBuffer();

        try {
            FileReader leitor = new FileReader(getArquivo());
            BufferedReader leitorbuffer = new BufferedReader(leitor);
            while (leitorbuffer.ready()) {
                aux.append(leitorbuffer.readLine()).append("\n");
            }
            leitorbuffer.close();

        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo " + erro);
        }

        return aux.toString();
    }

    public ArrayList<String> LeTextInput() {
        ArrayList<String> vetor = new ArrayList<String>();

        try {
            FileReader leitor = new FileReader(getArquivo());
            BufferedReader leitorbuffer = new BufferedReader(leitor);
            String linha = "";

            while ((linha = leitorbuffer.readLine()) != null) {
                vetor.add(linha);
            }

            leitor.close();
            leitorbuffer.close();

        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo " + erro);
        }

        return vetor;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
}
