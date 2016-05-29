package controledepedidos.marques.com.controledepedidos;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaCadastroProduto extends Activity {

    private EditText edtNome;
    private EditText edtDescricao;
    private Button btnSalvar;
    private Button btnListaProdutos;
    private Button btnVoltarInicial;
    Produto produto;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_produto);

        dbHelper = new DBHelper(TelaCadastroProduto.this);
        produto = new Produto();

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnListaProdutos = (Button) findViewById(R.id.btnListaProdutos);
        btnVoltarInicial = (Button) findViewById(R.id.btnVoltaInicial);

        btnVoltarInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itInicial = new Intent(TelaCadastroProduto.this, Principal.class);
                startActivity(itInicial);
            }
        });


        btnListaProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itListaProdutos = new Intent(TelaCadastroProduto.this, ListaProdutos.class);
                startActivity(itListaProdutos);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Produto produto = new Produto();
                produto.setNome(edtNome.getText().toString());
                produto.setDescricao(edtDescricao.getText().toString());
                dbHelper.salvarProduto(produto);
                dbHelper.close();
                Toast.makeText(TelaCadastroProduto.this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                edtNome.setText("");
                edtDescricao.setText("");
                edtNome.requestFocus();
            }
        });
    }
}
