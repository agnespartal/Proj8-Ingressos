package com.example.proj8_ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proj8_ingressos.model.Ingresso;

public class MainActivity extends AppCompatActivity {

    private EditText txtQtdIngresso;
    private CheckBox cbVIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtQtdIngresso = findViewById(R.id.txtQtdIngresso);
        cbVIP = findViewById(R.id.cbVIP);
        Button btnComprar = findViewById(R.id.btnComprar);

        btnComprar.setOnClickListener(op -> CalculaIngresso());
    }

    private void CalculaIngresso() {
        Ingresso ing = new Ingresso();
        int quantidade =Integer.parseInt(txtQtdIngresso.getText().toString());
        float taxa = 20;
        float ingresso = ing.ValorIngresso(taxa);
        float valorTaxa = ingresso - 150;
        if (cbVIP.isChecked()){
            ingresso *= 1.18;
        }
        float valorFinal = ingresso * quantidade;

        Bundle bundle = new Bundle();
        bundle.putFloat("valorFinal",valorFinal);
        bundle.putFloat("valortaxa", valorTaxa);
        bundle.putFloat("ingresso", ingresso);
        bundle.putInt("quantidade", quantidade);

        TrocarTela(bundle);
    }

    private void TrocarTela(Bundle bundle) {
        Intent i = new Intent(this, MostraDados.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();

    }


}