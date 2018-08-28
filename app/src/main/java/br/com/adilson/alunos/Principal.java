package br.com.adilson.alunos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class Principal extends AppCompatActivity {

    Button btnSend;
    TextView txtResp;
    EditText edtCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnSend = (Button) findViewById(R.id.btnSend);
        txtResp = (TextView)findViewById(R.id.txtResp);
        edtCep = (EditText)findViewById(R.id.edtCep);

        this.setTitle("Buscar CEP");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResp.setText("Carregando.. !");
                try {
                    CEP retorno;
                    String vcep  = edtCep.getText().toString();
                    retorno = new HttpService(vcep).execute().get();
                    txtResp.setText(retorno.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
       //         txtResp.setText("Concluido.. !");
            }
        });



    }
}

//  http://localhost:8080/Login/alunosj.php