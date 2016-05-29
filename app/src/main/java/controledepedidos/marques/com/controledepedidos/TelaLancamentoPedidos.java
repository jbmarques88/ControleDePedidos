package controledepedidos.marques.com.controledepedidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class TelaLancamentoPedidos extends Activity {

    private Spinner spnFornecedor;
    private Spinner spnProdutos;
    private Spinner spnQtd;
    private Button btnSalvarLanProduto;
    private Button btnListaLanProduto;
    private Button btnVoltarInicio;
    ArrayList<Produto> listaProdutos;
    ArrayList<Fornecedor> listaFornecedor;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lancamento_pedidos);

        dbHelper = new DBHelper(this);

        spnFornecedor = (Spinner) findViewById(R.id.spnFornecedor);
        spnProdutos = (Spinner) findViewById(R.id.spnProduto);
        spnQtd = (Spinner) findViewById(R.id.spnQtn);
        btnSalvarLanProduto = (Button) findViewById(R.id.btnSalvarLanPedido);
        btnListaLanProduto = (Button) findViewById(R.id.btn_lanPedidos);
        btnVoltarInicio = (Button) findViewById(R.id.btn_TelaInicial);

        btnSalvarLanProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnListaLanProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnVoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itInicio = new Intent(TelaLancamentoPedidos.this, Principal.class);
                startActivity(itInicio);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarPedidosNospn();
        carregarFornecedorNospn();
    }

    public void carregarPedidosNospn(){

        listaProdutos = dbHelper.getProdutos();
        dbHelper.close();

        if(listaProdutos != null){
            ArrayAdapter adp = new ArrayAdapter<Produto>(this,android.R.layout.simple_spinner_dropdown_item,listaProdutos);
            spnProdutos.setAdapter(adp);
        }
    }

    public void carregarFornecedorNospn() {

        listaFornecedor = dbHelper.getFornecedor();
        dbHelper.close();

        if (listaFornecedor != null) {
            ArrayAdapter adpFor = new ArrayAdapter<Fornecedor>(this, android.R.layout.simple_spinner_dropdown_item, listaFornecedor);
            spnFornecedor.setAdapter(adpFor);
        }

    }


}
