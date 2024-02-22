package pl.milionerzy.demo;

public enum Tabela_Kwota {

    PIECSET_ZLOTYCH("500"),
    TYSIAC_ZLOTYCH("10000"),
    DWA_TYSIACE_ZLOTYCH("2000"),
    PIEC_TYSIECY_ZLOTYCH("5000"),
    DZIESIEC_TYSIECY_ZLOTYCH("10000"),
    DWADZIESCIA_TYSIECY_ZLOTYCH("20000"),
    CZTERDZIESCI_TYSIECY_ZLOTYCH("40000"),
    SIEDEMDZIESIAT_TYSIECY_ZLOTYCH("75000"),
    STO_DWADZIESCIA_PIEC_TYSIECY_ZLOTYCH("125000"),
    DWIESCIE_PIECDZIESIAT_TYSIECY_ZLOWYCH("250000"),
    PIECSET_TYSIECY_ZLOTYCH("500000"),
    MILION("1000000");
    private String kwota;

    Tabela_Kwota(String kwota) {
        this.kwota = kwota;
    }

    public String getKwota() {
        return kwota;
    }

    @Override
    public String toString() {
        return "Tabela_Kwota{" +
                "kwota='" + kwota + '\'' +
                '}';
    }
}
