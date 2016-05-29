package controledepedidos.marques.com.controledepedidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity{

    private Button btnProdutos;
    private Button btnTelaCadastroFornecedor;
    private Button btnLancamentoPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnProdutos = (Button) findViewById(R.id.btnProdutos);
        btnTelaCadastroFornecedor = (Button) findViewById(R.id.btnTelaCadastroFornecedor);
        btnLancamentoPedidos = (Button) findViewById(R.id.btnLancamentoPedidos);

        btnProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Principal.this, ListaProdutos.class);
                startActivity(it);
            }
        });

        btnTelaCadastroFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaFornecedor = new Intent(Principal.this, TelaCadastroFornecedor.class);
                startActivity(itTelaFornecedor);
            }
        });

        btnLancamentoPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaLancamentoPedido = new Intent(Principal.this,TelaLancamentoPedidos.class);
                startActivity(itTelaLancamentoPedido);
            }
        });
    }


}
