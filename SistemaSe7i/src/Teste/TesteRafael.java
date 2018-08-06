package Teste;

import Beans.LeilaoBeans;
import GUI.Leilao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael Piedade
 */
public class TesteRafael {

    public static void main(String[] args) {
        LeilaoBeans leilao = new LeilaoBeans();
        List<File> arquivosEntrada = new ArrayList<>();
        List<File> arquivosBase = new ArrayList<>();

        leilao.setDescricao("Assis Fase 3");

        String destino = "C:\\Users\\rafae\\Desktop\\interface\\Saida\\";
        String local = "C:\\Users\\rafae\\Desktop\\interface\\Entrada\\";

        listaDeArquivos(local, arquivosEntrada);
        listaDeArquivos(destino, arquivosBase);

        System.out.println("arquivos entrada: " + arquivosEntrada.size());
        System.out.println("arquivos base:" + arquivosBase.size());

        for (int i = 0; i < arquivosEntrada.size(); i++) {
            System.out.println("Item " + i + ": " + arquivosEntrada.get(i).getName());

            if (arquivosBase.indexOf(arquivosEntrada.get(i)) == -1) {
                System.out.println("    arquivo copiado");
                arquivosBase.add(arquivosEntrada.get(i));
            } else {
                System.out.println("    ñ arquivo ja existe");
            }

        }

        /*
        if (new File(destino).mkdirs()) {
            System.out.println("DIRETORIO CRIADO");
        }

        
        File src = new File(local+"1CAD.txt");
        File dst = new File(destino+"1CAD.txt");
       
        try {
            copy(src, dst);
        } catch (Exception e) {
            System.out.println("Erro ao copiar: "+e);
        }
        System.out.println("FIM");
         */
    }

    static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);           // Transferindo bytes de entrada para saída
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    static void listaDeArquivos(String local, List<File> lista) {
        File dir = new File(local);
        for (File f : dir.listFiles()) {// lista o que possui no diretorio dir
            if (f.isFile()) {//se for um arquivo true;
                lista.add(f);
            }
        }
    }
}
