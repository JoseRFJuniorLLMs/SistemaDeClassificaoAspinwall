package com.booksgames.loja.responses;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 15 02 2019
 */

public class Response<T> {

    private T data;
    private List<String> erros;

    public Response(T data) {
        this.data = data;
    }

    public Response(List<String> erros) {
        this.erros = erros;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

}
