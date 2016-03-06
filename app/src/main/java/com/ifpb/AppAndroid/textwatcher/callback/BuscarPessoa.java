package com.ifpb.AppAndroid.textwatcher.callback;

import com.ifpb.AppAndroid.textwatcher.entity.Pessoa;

import java.util.List;

public interface BuscarPessoa {

    void backBuscarNome(List<Pessoa> names);

    void errorBuscarNome(String error);
}
