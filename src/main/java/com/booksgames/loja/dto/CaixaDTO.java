package com.booksgames.loja.dto;

import com.booksgames.loja.documents.Caixa;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 04 03 2019
 */

public class CaixaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String _id;
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", columnDefinition = "VARCHAR(255)")
    private UUID uuid;
    private String descricao;
    private String datahora;
    private String temperatura;
    private String longitude;
    private String latitude;
    private String arduino;
    private String sensorinerno;
    private String sensorexterno;
    private String inicio;
    private String fim;
    private String orirgem;
    private String destino;
    private String tempogasto;
    private String pessoa;
    private String veiculo;
    private String materialcoletado;
    private String status;

    public CaixaDTO() {
    }

    public CaixaDTO(Caixa obj) {
        _id = obj.get_id();
        uuid = obj.getUuid();
        descricao = obj.getDescricao();
        datahora = obj.getDatahora();
        temperatura = obj.getTemperatura();
        longitude = obj.getLongitude();
        latitude = obj.getLatitude();
        arduino = obj.getArduino();
        sensorinerno = obj.getSensorinerno();
        sensorexterno =  obj.getSensorexterno();
        inicio = obj.getInicio();
        fim = obj.getFim();
        orirgem = obj.getOrirgem();
        destino = obj.getDestino();
        tempogasto = obj.getTempogasto();
        pessoa = obj.getPessoa();
        veiculo = obj.getMaterialcoletado();
        status = obj.getStatus();
       
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getArduino() {
        return arduino;
    }

    public void setArduino(String arduino) {
        this.arduino = arduino;
    }

    public String getSensorinerno() {
        return sensorinerno;
    }

    public void setSensorinerno(String sensorinerno) {
        this.sensorinerno = sensorinerno;
    }

    public String getSensorexterno() {
        return sensorexterno;
    }

    public void setSensorexterno(String sensorexterno) {
        this.sensorexterno = sensorexterno;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getOrirgem() {
        return orirgem;
    }

    public void setOrirgem(String orirgem) {
        this.orirgem = orirgem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTempogasto() {
        return tempogasto;
    }

    public void setTempogasto(String tempogasto) {
        this.tempogasto = tempogasto;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getMaterialcoletado() {
        return materialcoletado;
    }

    public void setMaterialcoletado(String materialcoletado) {
        this.materialcoletado = materialcoletado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
