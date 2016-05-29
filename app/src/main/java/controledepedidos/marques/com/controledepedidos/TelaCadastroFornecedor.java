package controledepedidos.marques.com.controledepedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroFornecedor extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEndereco;
    private EditText edtTelefone;
    private Button btnCadastrarFornecedor;
    private Button btnVoltarInicio;
    Fornecedor fornecedor;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_fornecedor);

        fornecedor = new Fornecedor();
        dbHelper = new DBHelper(this);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        btnCadastrarFornecedor = (Button) findViewById(R.id.btnCadastrarFornecedor);
        btnVoltarInicio = (Button) findViewById(R.id.btnVoltarInicio);

        btnVoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itInicio = new Intent(TelaCadastroFornecedor.this, Principal.class);
                startActivity(itInicio);
            }
        });

        btnCadastrarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fornecedor.setNome(edtNome.getText().toString());
                fornecedor.setEndereco(edtEndereco.getText().toString());
                fornecedor.setTelefone(Integer.parseInt(edtTelefone.getText().toString()));
                dbHelper.salvarForncedor(fornecedor);
                dbHelper.close();
                Toast.makeText(TelaCadastroFornecedor.this, "Fornecedor cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                edtNome.setText("");
                edtEndereco.setText("");
                edtTelefone.setText("");
                edtNome.requestFocus();
            }
        });


    }
}
