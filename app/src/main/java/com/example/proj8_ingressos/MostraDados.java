package com.example.proj8_ingressos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MostraDados extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostra_dados);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtMostraDados = findViewById(R.id.txtMostraDados);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        assert bundle != null;
        float valorFinal = bundle.getFloat("valorFinal");
        float ingresso = bundle.getFloat("ingresso");
        float valorTaxa = bundle.getFloat("valortaxa");
        int quantidade = bundle.getInt("quantidade");

        txtMostraDados.setText(quantidade + " Ingressos Comprados!!\nValor Ingresso: " + ingresso + "\nTaxa Conveniência: " + valorTaxa + "\nTotal Pago: " + valorFinal);

        btnVoltar.setOnClickListener(op -> Voltar());
    }

    private void Voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}