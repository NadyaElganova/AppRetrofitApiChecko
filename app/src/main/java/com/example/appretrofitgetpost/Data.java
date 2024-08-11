package com.example.appretrofitgetpost;

public class Data {
    private String ОГРН;
    private String ИНН;
    private String КПП;
    private String ОКПО;
    private String ДатаРег;
    private String ДатаОГРН;
    private String НаимСокр;
    private String НаимАнгл;
    private String НаимПолн;

    public String getOGRN() {
        return ОГРН;
    }

    public void setOGRN(String OGRN) {
        this.ОГРН = OGRN;
    }

    public String getINN() {
        return ИНН;
    }

    public void setINN(String INN) {
        this.ИНН = INN;
    }

    public String getKPP() {
        return КПП;
    }

    public void setKPP(String KPP) {
        this.КПП = KPP;
    }

    public String getOKPO() {
        return ОКПО;
    }

    public void setOKPO(String OKPO) {
        this.ОКПО = OKPO;
    }

    public String getDataReg() {
        return ДатаРег;
    }

    public void setDataReg(String DataReg) {
        this.ДатаРег = DataReg;
    }

    public String getDataOGRN() {
        return ДатаОГРН;
    }

    public void setDataOGRN(String DataOGRN) {
        this.ДатаОГРН = DataOGRN;
    }

    public String getName() {
        return НаимСокр;
    }

    public void setName(String NameShort) {
        this.НаимСокр = NameShort;
    }

    public String getNameEnglish() {
        return НаимАнгл;
    }

    public void setNameEnglish(String NameEnglish) {
        this.НаимАнгл = NameEnglish;
    }

    public String getNameFull() {
        return НаимПолн;
    }

    public void setNameFull(String NameFull) {
        this.НаимПолн = NameFull;
    }
}
