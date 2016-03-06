package com.ifpb.AppAndroid.textwatcher.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.ifpb.AppAndroid.textwatcher.R;
import com.ifpb.AppAndroid.textwatcher.adapter.PessoasAdapter;
import com.ifpb.AppAndroid.textwatcher.asynctask.BuscarNome;
import com.ifpb.AppAndroid.textwatcher.callback.BuscarPessoa;
import com.ifpb.AppAndroid.textwatcher.entity.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements TextWatcher, OnItemClickListener, BuscarPessoa {

    private static int MIN = 3;

    private EditText nameEditText;
    List<Pessoa> pessoas;
    PessoasAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nomesEditText);
        nameEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.namesListView);
        pessoas = new ArrayList<Pessoa>();
        adapter = new PessoasAdapter(this, pessoas);
        nomesListView.setAdapter(adapter);
        nomesListView.setOnItemClickListener(this);
    }

    @Override

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override

    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        Log.i("EditTextListener", "onTextChanged: " + charSequence);
        String nome = charSequence.toString();

        if (nome.length() >= MIN) {
            // JSON
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);

            BuscarNome buscarName = new BuscarNome(this);
            buscarName.execute(pessoa);
        }
        else{
            this.pessoas.clear();
        }


    }


    @Override

    public void afterTextChanged(Editable s) {

    }

    @Override
    public void backBuscarNome(List<Pessoa> pessoas) {

        this.pessoas.clear();
        this.pessoas.addAll(pessoas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorBuscarNome(String error) {

        pessoas.clear();
        adapter.notifyDataSetChanged();

        Toast.makeText(this, error, Toast.LENGTH_LONG);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Log.i("EditTextListener", "Position: " + position);

        Toast toast = Toast.makeText(this,
                "Item " + (position + 1) + ": " + pessoas.get(position),
                Toast.LENGTH_LONG);
        toast.show();

        Pessoa pessoa = pessoas.get(position);

        Intent intent = new Intent(this, PessoaActivity.class);
        intent.putExtra("pessoa",pessoa);
        this.startActivity(intent);
        this.finish();
    }
}
