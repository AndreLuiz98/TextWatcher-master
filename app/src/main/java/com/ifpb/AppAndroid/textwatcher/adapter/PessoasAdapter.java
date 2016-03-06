package com.ifpb.AppAndroid.textwatcher.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import  com.ifpb.AppAndroid.textwatcher.R;
import com.ifpb.AppAndroid.textwatcher.entity.Pessoa;
import java.util.List;


public class PessoasAdapter extends BaseAdapter {

    Context context;

    List<Pessoa> namesPessoas;

    public PessoasAdapter(Context context, List<Pessoa> pessoas) {
        this.context = context;
        this.namesPessoas = pessoas;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)  context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.list, null);

            holder = new ViewHolder();
            holder.txtInscription = (TextView) convertView.findViewById(R.id.inscription);
            holder.txtName = (TextView) convertView.findViewById(R.id.fullName);
            holder.txtId = (TextView) convertView.findViewById(R.id.id);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.email);
            holder.txtIsDelivered = (TextView) convertView.findViewById(R.id.isDelivered);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        Pessoa pessoaItem = (Pessoa) getItem(position);

        holder.txtName.setText(pessoaItem.getNome());
        holder.txtInscription.setText(pessoaItem.getDescricao());
        holder.txtEmail.setText(pessoaItem.getEmail());
        holder.txtId.setText("ID: "+ pessoaItem.getId());
        if(pessoaItem.isOk()){
            holder.txtIsDelivered.setText("Status: OK");
        }
        else
            holder.txtIsDelivered.setText("Status: Não entregue");

        return convertView;
    }

    @Override
    public int getCount() {
        return namesPessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return namesPessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return namesPessoas.indexOf(getItem(position));
    }

    /*private view holder class*/
    private class ViewHolder {

        TextView txtName;
        TextView txtInscription;
        TextView txtId;
        TextView txtEmail;
        TextView txtIsDelivered;
    }
}
