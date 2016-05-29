package controledepedidos.marques.com.controledepedidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;


public class ListaProdutos extends Activity {

    private ListView lstProdutos;
    private ImageButton btnCadastrarProduto;
    private Button btnVoltaInicio;
    DBHelper dbHelper;
    ArrayList<Produto> listProdutos;
    Produto produto;
    ArrayAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        lstProdutos = (ListView) findViewById(R.id.lstProdutos);
        btnCadastrarProduto = (ImageButton) findViewById(R.id.btnCadastrarProduto);
        btnVoltaInicio = (Button) findViewById(R.id.btnVoltarInicio);

        btnVoltaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaInicio = new Intent(ListaProdutos.this, Principal.class);
                startActivity(itTelaInicio);
            }
        });


        btnCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ListaProdutos.this,TelaCadastroProduto.class);
                startActivity(it);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarProdutos();
    }

    public void carregarProdutos(){
        dbHelper = new DBHelper(this);
        listProdutos = dbHelper.getProdutos();
        dbHelper.close();

        if (listProdutos != null){
            adp = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1,listProdutos);
            lstProdutos.setAdapter(adp);
        }
    }

}
