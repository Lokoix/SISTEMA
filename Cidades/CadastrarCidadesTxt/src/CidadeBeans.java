
/**
 *
 * @author rafae
 */
public class CidadeBeans {
    private int codigo;
    private String nome;
    private String uf;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public void exibe(){
        System.out.println(this.getCodigo() +"-"+ this.getNome() +"-"+ this.getUf());
    }
    
    
}
