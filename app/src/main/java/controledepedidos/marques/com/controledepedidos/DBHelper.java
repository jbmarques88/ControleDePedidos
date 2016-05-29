package controledepedidos.marques.com.controledepedidos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Marques on 22/05/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "dbProdutos";
    private static final int VERSION_BANCO = 1;

    public DBHelper(Context context) {
        super(context, DATABASE, null, VERSION_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabproduto = "CREATE TABLE produto ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome TEXT NOT NULL, descricao TEXT NOT NULL );";
        db.execSQL(tabproduto);


        String tabfornecedor = "CREATE TABLE fornecedor ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome TEXT NOT NULL, endereco TEXT NOT NULL, telefone TEXT NOT NULL );";
        db.execSQL(tabfornecedor);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarForncedor(Fornecedor fornecedor){

        ContentValues values = new ContentValues();
        values.put("nome", fornecedor.getNome());
        values.put("endereco", fornecedor.getEndereco());
        values.put("telefone", fornecedor.getTelefone());
        getWritableDatabase().insert("fornecedor", null, values);
    }


    public void salvarProduto(Produto produto) {

        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome());
        valores.put("descricao", produto.getDescricao());
        getWritableDatabase().insert("produto", null, valores);
    }

    public ArrayList<Produto> getProdutos(){

        String[] colunas = {"id", "nome", "descricao"};
        Cursor cursor = getWritableDatabase().query("produto", colunas,null,null,null,null,null);

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        while (cursor.moveToNext()){
            Produto produto = new Produto();
            produto.set_id(cursor.getInt(0));
            produto.setNome(cursor.getString(1));
            produto.setDescricao(cursor.getString(2));

            listaProdutos.add(produto);
        }
        return listaProdutos;
    }

    public ArrayList<Fornecedor> getFornecedor(){

        String[] columns = {"id", "nome", "endereco", "telefone"};
        Cursor cursor = getWritableDatabase().query("fornecedor", columns, null, null, null, null, null, null);

        ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();

        while (cursor.moveToNext()){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(cursor.getInt(0));
            fornecedor.setNome(cursor.getString(1));
            fornecedor.setEndereco(cursor.getString(2));
            fornecedor.setTelefone(Integer.parseInt(cursor.getString(3)));

            listaFornecedor.add(fornecedor);
        }
        return listaFornecedor;
    }
}
