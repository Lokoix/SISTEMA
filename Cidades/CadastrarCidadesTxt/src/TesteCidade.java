/*
 *  Sistema para realizar o cadastro do txt de cidades no banco de dados, 
arrume os dados de:
    Banco de dados em: conexao.java;
    Local dos arquivos em: TesteCidade.java
    Adicionar BIBLIOTECA: mysql-connector

se necessário comente as linhas do codigo de cada arquivo
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Rafael Piedade
 * @since 2018-05-30
 */
public class TesteCidade {

    public static void main(String[] args) {

        CidadesDAO d = new CidadesDAO();
        CidadeBeans cidade = new CidadeBeans();
        String uf = "SP";// ele sera usado apenas no aruivo: Cidades SP.txt
        int marcacao; // usado para marcar posição de ";"

        String dir = "C:\\Users\\rafae\\Desktop\\SISTEMA\\Cidades\\"; // diretorio dos arquivos txt
        File arq = new File(dir, "Cidades SP.txt"); //nome do arquivo txt

        //leitura do arquivo
        ArrayList<String> result = new ArrayList();
        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";
            while ((linha = bufferedReader.readLine()) != null) {
                if (linha != null && !linha.isEmpty()) {
                    result.add(linha);

                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error ao ler arquivo txt: " + e);
        }

        // ----------Usado apenas no arquivo: CIT.txt----------------
        /*
        for (int i = 0; i < result.size(); i++) {
            marcacao = result.get(i).indexOf(";");
            cidade.setNome(result.get(i).substring(0, marcacao));

            if (result.get(i).substring(result.get(i).indexOf(";") + 1, result.get(i).indexOf(";") + 3).equals("  ")) {
                cidade.setCodigo(Integer.parseInt(result.get(i).substring((marcacao + 3), result.get(i).lastIndexOf(";") - 1)));
            } else {
                cidade.setCodigo(Integer.parseInt(result.get(i).substring((marcacao + 2), result.get(i).lastIndexOf(";"))));
            }

            
            //cidade.setUf(result.get(i).substring(result.get(i).lastIndexOf(";") + 2));
            cidade.exibe();
            d.Cadastrar(cidade);
        }
         */
        
        //----------Usado apenas no arquivo: Cidades SP.txt--------------
        for (int i = 0; i < result.size(); i++) {
            marcacao = result.get(i).indexOf(";");
            cidade.setNome(result.get(i).substring(0, marcacao));
            cidade.setCodigo(Integer.parseInt(result.get(i).substring(marcacao + 2)));
            cidade.setUf(uf);
            cidade.exibe();
            d.Cadastrar(cidade);
        }
    }

}
