package com.booksgames.loja.documents;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Imposto implements Serializable {

    @Id
    private Integer id;

    private Integer orig;

    private BigDecimal alqcred;

    private Integer modbc;

    private BigDecimal percredbc;

    private Integer modbcst;

    private BigDecimal mva;

    @Column(precision = 21, scale = 10)
    private BigDecimal alqicmsst;

    private BigDecimal percredbcst;

    private String ufst;

    private Integer motdesicms;

    private BigDecimal percbcop;

    private String descricao;

    private String cfopent;

    private String cfopsai;

    private String cfopsaiest;

    private String cfopsaif;

    private String cfopentf;

    private String aliquota;

    @Column(precision = 21, scale = 10)
    private BigDecimal aliqicms;

    @Column(length = 2)
    private String cstpis;

    @Column(precision = 21, scale = 10)
    private BigDecimal alqpis;

    @Column(length = 2)
    private String cstcofins;

    @Column(precision = 21, scale = 10)
    private BigDecimal alqcofins;

    private Integer ipitipcalc;

    @Column(length = 2)
    private String cstipi;

    @Column(precision = 21, scale = 10)
    private BigDecimal alqipi;

    @Column(nullable = false)
    private boolean cstuf;

    private Integer piscalc;

    @Column(precision = 21, scale = 10)
    private BigDecimal pisalqprod;

    private Integer pisstcalc;

     private BigDecimal pisstalqprod;

    private BigDecimal alqpisst;

    private Integer cofinscalc;

    private BigDecimal cofinsalqprod;

    private Integer cofinsstcalc;

    private BigDecimal cofinsstalqprod;

    private BigDecimal alqcofinsst;

    private String clenqipi;

    private String cnpjprodipi;

    private String codseloipi;

    private Integer qtdseloipi;

    private String codenqipi;

    private BigDecimal qtdunidipi;

    private BigDecimal valunidipi;

    private String cst;

    private String csosn;

    @Column(nullable = false)
    private boolean defaultz;

    private String cest;

    private String cbenef;

    private BigDecimal pfcp;

    private BigDecimal pfcpst;

    private Ncm ncm;

    public Imposto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrig() {
        return orig;
    }

    public void setOrig(Integer orig) {
        this.orig = orig;
    }

    public BigDecimal getAlqcred() {
        return alqcred;
    }

    public void setAlqcred(BigDecimal alqcred) {
        this.alqcred = alqcred;
    }

    public Integer getModbc() {
        return modbc;
    }

    public void setModbc(Integer modbc) {
        this.modbc = modbc;
    }

    public BigDecimal getPercredbc() {
        return percredbc;
    }

    public void setPercredbc(BigDecimal percredbc) {
        this.percredbc = percredbc;
    }

    public Integer getModbcst() {
        return modbcst;
    }

    public void setModbcst(Integer modbcst) {
        this.modbcst = modbcst;
    }

    public BigDecimal getMva() {
        return mva;
    }

    public void setMva(BigDecimal mva) {
        this.mva = mva;
    }

    public BigDecimal getAlqicmsst() {
        return alqicmsst;
    }

    public void setAlqicmsst(BigDecimal alqicmsst) {
        this.alqicmsst = alqicmsst;
    }

    public BigDecimal getPercredbcst() {
        return percredbcst;
    }

    public void setPercredbcst(BigDecimal percredbcst) {
        this.percredbcst = percredbcst;
    }

    public String getUfst() {
        return ufst;
    }

    public void setUfst(String ufst) {
        this.ufst = ufst;
    }

    public Integer getMotdesicms() {
        return motdesicms;
    }

    public void setMotdesicms(Integer motdesicms) {
        this.motdesicms = motdesicms;
    }

    public BigDecimal getPercbcop() {
        return percbcop;
    }

    public void setPercbcop(BigDecimal percbcop) {
        this.percbcop = percbcop;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCfopent() {
        return cfopent;
    }

    public void setCfopent(String cfopent) {
        this.cfopent = cfopent;
    }

    public String getCfopsai() {
        return cfopsai;
    }

    public void setCfopsai(String cfopsai) {
        this.cfopsai = cfopsai;
    }

    public String getCfopsaiest() {
        return cfopsaiest;
    }

    public void setCfopsaiest(String cfopsaiest) {
        this.cfopsaiest = cfopsaiest;
    }

    public String getCfopsaif() {
        return cfopsaif;
    }

    public void setCfopsaif(String cfopsaif) {
        this.cfopsaif = cfopsaif;
    }

    public String getCfopentf() {
        return cfopentf;
    }

    public void setCfopentf(String cfopentf) {
        this.cfopentf = cfopentf;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public BigDecimal getAlqpis() {
        return alqpis;
    }

    public void setAlqpis(BigDecimal alqpis) {
        this.alqpis = alqpis;
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public BigDecimal getAlqcofins() {
        return alqcofins;
    }

    public void setAlqcofins(BigDecimal alqcofins) {
        this.alqcofins = alqcofins;
    }

    public Integer getIpitipcalc() {
        return ipitipcalc;
    }

    public void setIpitipcalc(Integer ipitipcalc) {
        this.ipitipcalc = ipitipcalc;
    }

    public String getCstipi() {
        return cstipi;
    }

    public void setCstipi(String cstipi) {
        this.cstipi = cstipi;
    }

    public BigDecimal getAlqipi() {
        return alqipi;
    }

    public void setAlqipi(BigDecimal alqipi) {
        this.alqipi = alqipi;
    }

    public boolean isCstuf() {
        return cstuf;
    }

    public void setCstuf(boolean cstuf) {
        this.cstuf = cstuf;
    }

    public Integer getPiscalc() {
        return piscalc;
    }

    public void setPiscalc(Integer piscalc) {
        this.piscalc = piscalc;
    }

    public BigDecimal getPisalqprod() {
        return pisalqprod;
    }

    public void setPisalqprod(BigDecimal pisalqprod) {
        this.pisalqprod = pisalqprod;
    }

    public Integer getPisstcalc() {
        return pisstcalc;
    }

    public void setPisstcalc(Integer pisstcalc) {
        this.pisstcalc = pisstcalc;
    }

    public BigDecimal getPisstalqprod() {
        return pisstalqprod;
    }

    public void setPisstalqprod(BigDecimal pisstalqprod) {
        this.pisstalqprod = pisstalqprod;
    }

    public BigDecimal getAlqpisst() {
        return alqpisst;
    }

    public void setAlqpisst(BigDecimal alqpisst) {
        this.alqpisst = alqpisst;
    }

    public Integer getCofinscalc() {
        return cofinscalc;
    }

    public void setCofinscalc(Integer cofinscalc) {
        this.cofinscalc = cofinscalc;
    }

    public BigDecimal getCofinsalqprod() {
        return cofinsalqprod;
    }

    public void setCofinsalqprod(BigDecimal cofinsalqprod) {
        this.cofinsalqprod = cofinsalqprod;
    }

    public Integer getCofinsstcalc() {
        return cofinsstcalc;
    }

    public void setCofinsstcalc(Integer cofinsstcalc) {
        this.cofinsstcalc = cofinsstcalc;
    }

    public BigDecimal getCofinsstalqprod() {
        return cofinsstalqprod;
    }

    public void setCofinsstalqprod(BigDecimal cofinsstalqprod) {
        this.cofinsstalqprod = cofinsstalqprod;
    }

    public BigDecimal getAlqcofinsst() {
        return alqcofinsst;
    }

    public void setAlqcofinsst(BigDecimal alqcofinsst) {
        this.alqcofinsst = alqcofinsst;
    }

    public String getClenqipi() {
        return clenqipi;
    }

    public void setClenqipi(String clenqipi) {
        this.clenqipi = clenqipi;
    }

    public String getCnpjprodipi() {
        return cnpjprodipi;
    }

    public void setCnpjprodipi(String cnpjprodipi) {
        this.cnpjprodipi = cnpjprodipi;
    }

    public String getCodseloipi() {
        return codseloipi;
    }

    public void setCodseloipi(String codseloipi) {
        this.codseloipi = codseloipi;
    }

    public Integer getQtdseloipi() {
        return qtdseloipi;
    }

    public void setQtdseloipi(Integer qtdseloipi) {
        this.qtdseloipi = qtdseloipi;
    }

    public String getCodenqipi() {
        return codenqipi;
    }

    public void setCodenqipi(String codenqipi) {
        this.codenqipi = codenqipi;
    }

    public BigDecimal getQtdunidipi() {
        return qtdunidipi;
    }

    public void setQtdunidipi(BigDecimal qtdunidipi) {
        this.qtdunidipi = qtdunidipi;
    }

    public BigDecimal getValunidipi() {
        return valunidipi;
    }

    public void setValunidipi(BigDecimal valunidipi) {
        this.valunidipi = valunidipi;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public boolean isDefaultz() {
        return defaultz;
    }

    public void setDefaultz(boolean defaultz) {
        this.defaultz = defaultz;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getCbenef() {
        return cbenef;
    }

    public void setCbenef(String cbenef) {
        this.cbenef = cbenef;
    }

    public BigDecimal getPfcp() {
        return pfcp;
    }

    public void setPfcp(BigDecimal pfcp) {
        this.pfcp = pfcp;
    }

    public BigDecimal getPfcpst() {
        return pfcpst;
    }

    public void setPfcpst(BigDecimal pfcpst) {
        this.pfcpst = pfcpst;
    }

    public Ncm getNcm() {
        return ncm;
    }

    public void setNcm(Ncm ncm) {
        this.ncm = ncm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imposto imposto = (Imposto) o;
        return Objects.equals(id, imposto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Imposto{" +
                "id=" + id +
                ", orig=" + orig +
                ", alqcred=" + alqcred +
                ", modbc=" + modbc +
                ", percredbc=" + percredbc +
                ", modbcst=" + modbcst +
                ", mva=" + mva +
                ", alqicmsst=" + alqicmsst +
                ", percredbcst=" + percredbcst +
                ", ufst='" + ufst + '\'' +
                ", motdesicms=" + motdesicms +
                ", percbcop=" + percbcop +
                ", descricao='" + descricao + '\'' +
                ", cfopent='" + cfopent + '\'' +
                ", cfopsai='" + cfopsai + '\'' +
                ", cfopsaiest='" + cfopsaiest + '\'' +
                ", cfopsaif='" + cfopsaif + '\'' +
                ", cfopentf='" + cfopentf + '\'' +
                ", aliquota='" + aliquota + '\'' +
                ", aliqicms=" + aliqicms +
                ", cstpis=" + cstpis +
                ", alqpis=" + alqpis +
                ", cstcofins='" + cstcofins + '\'' +
                ", alqcofins=" + alqcofins +
                ", ipitipcalc=" + ipitipcalc +
                ", cstipi='" + cstipi + '\'' +
                ", alqipi=" + alqipi +
                ", cstuf=" + cstuf +
                ", piscalc=" + piscalc +
                ", pisalqprod=" + pisalqprod +
                ", pisstcalc=" + pisstcalc +
                ", pisstalqprod=" + pisstalqprod +
                ", alqpisst=" + alqpisst +
                ", cofinscalc=" + cofinscalc +
                ", cofinsalqprod=" + cofinsalqprod +
                ", cofinsstcalc=" + cofinsstcalc +
                ", cofinsstalqprod=" + cofinsstalqprod +
                ", alqcofinsst=" + alqcofinsst +
                ", clenqipi='" + clenqipi + '\'' +
                ", cnpjprodipi='" + cnpjprodipi + '\'' +
                ", codseloipi=" + codseloipi +
                ", qtdseloipi=" + qtdseloipi +
                ", codenqipi=" + codenqipi +
                ", qtdunidipi=" + qtdunidipi +
                ", valunidipi=" + valunidipi +
                ", cst='" + cst + '\'' +
                ", csosn='" + csosn + '\'' +
                ", defaultz=" + defaultz +
                ", cest='" + cest + '\'' +
                ", cbenef='" + cbenef + '\'' +
                ", pfcp=" + pfcp +
                ", pfcpst=" + pfcpst +
                ", ncm=" + ncm +
                '}';
    }
}