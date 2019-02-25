package com.booksgames.loja.documents;

import com.booksgames.loja.documents.enums.FlagNFCe;
import com.booksgames.loja.documents.enums.FlagPgto;
import com.booksgames.loja.documents.enums.FlagUtilizacao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Document(collection = "meiopgto")
public class Meiopgto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;

    private String forma;

    private int flagpgto;

    @Column(nullable = false)
    private boolean ativo = true;

    private Integer gp;

    private FlagUtilizacao flagUtilizacao;

    private int flagNFCe;

    private Long cnpjcartao;

    private Integer bandeiracartao;

    private String dc;

    @Column(precision = 21, scale = 2)
    private BigDecimal comissao;

    public Meiopgto() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getFlagpgto() {
        return flagpgto;
    }

    public void setFlagpgto(int flagpgto) {
        this.flagpgto = flagpgto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getGp() {
        return gp;
    }

    public void setGp(Integer gp) {
        this.gp = gp;
    }

    public FlagUtilizacao getFlagUtilizacao() {
        return flagUtilizacao;
    }

    public void setFlagUtilizacao(FlagUtilizacao flagUtilizacao) {
        this.flagUtilizacao = flagUtilizacao;
    }

    public int getFlagNFCe() {
        return flagNFCe;
    }

    public void setFlagNFCe(int flagNFCe) {
        this.flagNFCe = flagNFCe;
    }

    public Long getCnpjcartao() {
        return cnpjcartao;
    }

    public void setCnpjcartao(Long cnpjcartao) {
        this.cnpjcartao = cnpjcartao;
    }

    public Integer getBandeiracartao() {
        return bandeiracartao;
    }

    public void setBandeiracartao(Integer bandeiracartao) {
        this.bandeiracartao = bandeiracartao;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return "Meiopgto{" +

                ", forma='" + forma + '\'' +
                ", flagpgto=" + flagpgto +
                ", ativo=" + ativo +
                ", gp=" + gp +
                ", flagUtilizacao=" + flagUtilizacao +
                ", FlagNFCe=" + flagNFCe +
                ", cnpjcartao=" + cnpjcartao +
                ", bandeiracartao=" + bandeiracartao +
                ", dc='" + dc + '\'' +
                ", comissao=" + comissao +
                '}';
    }

    public static final class MeiopgtoBuilder {
        private Integer id;
        private String forma;
        private FlagPgto flagpgto;
        private boolean ativo = true;
        private Integer gp;
        private FlagUtilizacao flagUtilizacao;
        private FlagNFCe flagNFCe;
        private Long cnpjcartao;
        private Integer bandeiracartao;
        private String dc;
        private BigDecimal comissao;

        private MeiopgtoBuilder() {
        }

        public static MeiopgtoBuilder oMeiopgto() {
            return new MeiopgtoBuilder();
        }

        public MeiopgtoBuilder comId(Integer id) {
            this.id = id;
            return this;
        }

        public MeiopgtoBuilder comForma(String forma) {
            this.forma = forma;
            return this;
        }

        public MeiopgtoBuilder comFlagpgto(FlagPgto flagpgto) {
            this.flagpgto = flagpgto;
            return this;
        }

        public MeiopgtoBuilder comAtivo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public MeiopgtoBuilder comGp(Integer gp) {
            this.gp = gp;
            return this;
        }

        public MeiopgtoBuilder comFlagUtilizacao(FlagUtilizacao flagUtilizacao) {
            this.flagUtilizacao = flagUtilizacao;
            return this;
        }

        public MeiopgtoBuilder comFlagNFCe(FlagNFCe flagNFCe) {
            this.flagNFCe = flagNFCe;
            return this;
        }

        public MeiopgtoBuilder comCnpjcartao(Long cnpjcartao) {
            this.cnpjcartao = cnpjcartao;
            return this;
        }

        public MeiopgtoBuilder comBandeiracartao(Integer bandeiracartao) {
            this.bandeiracartao = bandeiracartao;
            return this;
        }

        public MeiopgtoBuilder comDc(String dc) {
            this.dc = dc;
            return this;
        }

        public MeiopgtoBuilder comComissao(BigDecimal comissao) {
            this.comissao = comissao;
            return this;
        }

        public Meiopgto build() {
            Meiopgto meiopgto = new Meiopgto();
            meiopgto.setForma(forma);
            meiopgto.setAtivo(ativo);
            meiopgto.setGp(gp);
            meiopgto.setFlagUtilizacao(flagUtilizacao);
            meiopgto.setCnpjcartao(cnpjcartao);
            meiopgto.setBandeiracartao(bandeiracartao);
            meiopgto.setDc(dc);
            meiopgto.setComissao(comissao);
            return meiopgto;
        }
    }
}
