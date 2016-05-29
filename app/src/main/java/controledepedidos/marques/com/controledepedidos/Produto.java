package controledepedidos.marques.com.controledepedidos;

/**
 * Created by Marques on 20/05/2016.
 */
public class Produto {
    int _id;
    String nome;
    String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome.toString();
    }
}