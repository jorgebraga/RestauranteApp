package com.restaurante.atividade.restauranteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private EditText consumoTotal;
    private EditText couvert;
    private Button botaoCalcular;
    private EditText valorTotal;
    private EditText divididoPor;
    private EditText taxa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumoTotal =(EditText)findViewById(R.id.edt_consumo);
        couvert = (EditText)findViewById(R.id.edt_couvert_artistico);
        botaoCalcular = (Button) findViewById(R.id.bt_calcular);
        valorTotal = (EditText)findViewById(R.id.edt_conta_total);
        divididoPor = (EditText)findViewById(R.id.edt_valor_pessoa);
        taxa = (EditText)findViewById(R.id.edt_servico);

        botaoCalcular.setOnClickListener(botaoCalcularListener);

    }

    OnClickListener botaoCalcularListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            double consumo = Double.parseDouble(consumoTotal.getText().toString());
            double couvertEdt = Double.parseDouble(couvert.getText().toString());
            double dividir = Double.parseDouble(divididoPor.getText().toString());
            double contaTotal = consumo + couvertEdt;
            double servico = (contaTotal) * 0.1;
            double totalFinal = contaTotal + servico;
            double dividirPessoa = totalFinal / dividir;


            valorTotal.setText(String.valueOf(totalFinal));
            divididoPor.setText(String.valueOf(dividirPessoa));
            taxa.setText(String.valueOf(servico));
        }
    };
}
