package com.booksgames.loja.documents;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 04 03 2019
 */

@Document(collection = "caixa")
public class Caixa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", columnDefinition = "VARCHAR(255)")
    public UUID uuid;
    public String descricao;
    public String datahora;
    public String temperatura;
    public String longitude;
    public String latitude;
    public String arduino;
    public String sensorinerno;
    public String sensorexterno;
    public String inicio;
    public String fim;
    public String orirgem;
    public String destino;
    public String tempogasto;
    public String pessoa;
    public String veiculo;
    public String materialcoletado;
    public String status;

    // Constructors
    public Caixa() {}

    public Caixa(
            String _id,
            UUID uuid,
            String descricao,
            String datahora,
            String temperatura,
            String longitude,
            String latitude,
            String arduino,
            String sensorinerno,
            String sensorexterno,
            String inicio,
            String fim,
            String origem,
            String destino,
            String tempogasto,
            String pessoa,
            String veiculo,
            String materialcoletado,
            String status
    ){
        this._id = _id;
        this.uuid = uuid;
        this.descricao = descricao;
        this.datahora = datahora;
        this.temperatura = temperatura;
        this.longitude = longitude;
        this.latitude = latitude;
        this.arduino = arduino;
        this.sensorinerno = sensorinerno;
        this.sensorexterno = sensorexterno;
        this.inicio = inicio;
        this.fim = fim;
        this.orirgem = origem;
        this.destino = destino;
        this.tempogasto = tempogasto;
        this.pessoa = pessoa;
        this.veiculo = veiculo;
        this.materialcoletado = materialcoletado;
        this.materialcoletado = status;

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