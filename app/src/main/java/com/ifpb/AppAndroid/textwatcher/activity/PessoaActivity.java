package com.ifpb.AppAndroid.textwatcher.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.ifpb.AppAndroid.textwatcher.R;
import com.ifpb.AppAndroid.textwatcher.entity.Pessoa;


public class PessoaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Intent intent = getIntent();
        Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

        TextView txtInscription = (TextView) findViewById(R.id.inscription);
        TextView txtName = (TextView) findViewById(R.id.fullName);
        TextView txtId = (TextView) findViewById(R.id.id);
        TextView txtEmail = (TextView) findViewById(R.id.email);
        TextView txtIsDelivered = (TextView) findViewById(R.id.isDelivered);

        txtInscription.setText(pessoa.getDescricao());
        txtName.setText(pessoa.getNome());
        txtId.setText("ID: " + pessoa.getId());
        txtEmail.setText(pessoa.getEmail());
        if(pessoa.isOk()){
            txtIsDelivered.setText("Status: OK");
        }
        else
            txtIsDelivered.setText("Status: Error");

    }

}
