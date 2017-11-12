package com.marc.excelTransformer;

import com.opencsv.bean.CsvBindByName;

public class DataSetOrigin {

	/*
	 * Spalten:
	 * 
	 * Tec_ID; Marke; Modell; Ausfuehrung; Aufbauart; Typ 1; Modell BJ; FHZ BJ;
	 * Motor; KW; PS; Hubraum; HSN_TSN; Motorcode; Antrieb; Zusatz;
	 * Artikelnummer; Einbauort; Zulassung; ; Preis Brutto; Kurzbeschreibung;
	 * Langbeschreibung; Bildpfad Zeichnung; Bildpfad Kategorie;
	 * Verschleisswarnkontakt; EAN
	 */

	@CsvBindByName(column = "Tec_ID", required = true)
	private String tec_ID;

	@CsvBindByName(column = "Marke", required = false)
	private String marke;

	@CsvBindByName(column = "Modell", required = false)
	private String modell;

	@CsvBindByName(column = "Ausfuehrung", required = false)
	private String ausfuehrung;

	@CsvBindByName(column = "Aufbauart", required = false)
	private String aufbauart;

	@CsvBindByName(column = "Typ 1", required = false)
	private String typ1;

	@CsvBindByName(column = "Modell BJ", required = false)
	private String modell_BJ;

	@CsvBindByName(column = "FHZ BJ", required = false)
	private String fhz_BJ;

	@CsvBindByName(column = "Motor", required = false)
	private String motor;

	@CsvBindByName(column = "KW", required = false)
	private String kw;

	@CsvBindByName(column = "PS", required = false)
	private String ps;

	@CsvBindByName(column = "Hubraum", required = false)
	private String hubraum;

	@CsvBindByName(column = "HSN_TSN", required = false)
	private String hsn_tsn;

	@CsvBindByName(column = "Motorcode", required = false)
	private String motorcode;

	@CsvBindByName(column = "Antrieb", required = false)
	private String antrieb;

	@CsvBindByName(column = "Zusatz", required = false)
	private String zusatz;

	@CsvBindByName(column = "Artikelnummer", required = false)
	private String artikelnummer;

	@CsvBindByName(column = "Einbauort", required = false)
	private String einbauort;

	@CsvBindByName(column = "Zulassung", required = false)
	private String zulassung;

	@CsvBindByName(column = "", required = false)
	private String _;

	@CsvBindByName(column = "Preis Brutto", required = false)
	private String preis_brutto;

	@CsvBindByName(column = "Kurzbeschreibung", required = false)
	private String kurzbeschreibung;

	@CsvBindByName(column = "Langbeschreibung", required = false)
	private String langbeschreibung;

	@CsvBindByName(column = "Bildpfad Zeichnung", required = false)
	private String bildpfad_zeichnung;

	@CsvBindByName(column = "Bildpfad Kategorie", required = false)
	private String bildpfad_kategorie;

	@CsvBindByName(column = "Verschleisswarnkontakt", required = false)
	private String verschleisswarnkontakt;

	@CsvBindByName(column = "EAN", required = false)
	private String ean;

	/**
	 * @return the tec_ID
	 */
	public String getTec_ID() {
		return tec_ID;
	}

	/**
	 * @param tec_ID
	 *            the tec_ID to set
	 */
	public void setTec_ID(String tec_ID) {
		this.tec_ID = tec_ID;
	}

	/**
	 * @return the marke
	 */
	public String getMarke() {
		return marke;
	}

	/**
	 * @param marke
	 *            the marke to set
	 */
	public void setMarke(String marke) {
		this.marke = marke;
	}

	/**
	 * @return the modell
	 */
	public String getModell() {
		return modell;
	}

	/**
	 * @param modell
	 *            the modell to set
	 */
	public void setModell(String modell) {
		this.modell = modell;
	}

	/**
	 * @return the ausfuehrung
	 */
	public String getAusfuehrung() {
		return ausfuehrung;
	}

	/**
	 * @param ausfuehrung
	 *            the ausfuehrung to set
	 */
	public void setAusfuehrung(String ausfuehrung) {
		this.ausfuehrung = ausfuehrung;
	}

	/**
	 * @return the aufbauart
	 */
	public String getAufbauart() {
		return aufbauart;
	}

	/**
	 * @param aufbauart
	 *            the aufbauart to set
	 */
	public void setAufbauart(String aufbauart) {
		this.aufbauart = aufbauart;
	}

	/**
	 * @return the typ1
	 */
	public String getTyp1() {
		return typ1;
	}

	/**
	 * @param typ1
	 *            the typ1 to set
	 */
	public void setTyp1(String typ1) {
		this.typ1 = typ1;
	}

	/**
	 * @return the modell_BJ
	 */
	public String getModell_BJ() {
		return modell_BJ;
	}

	/**
	 * @param modell_BJ
	 *            the modell_BJ to set
	 */
	public void setModell_BJ(String modell_BJ) {
		this.modell_BJ = modell_BJ;
	}

	/**
	 * @return the fhz_BJ
	 */
	public String getFhz_BJ() {
		return fhz_BJ;
	}

	/**
	 * @param fhz_BJ
	 *            the fhz_BJ to set
	 */
	public void setFhz_BJ(String fhz_BJ) {
		this.fhz_BJ = fhz_BJ;
	}

	/**
	 * @return the motor
	 */
	public String getMotor() {
		return motor;
	}

	/**
	 * @param motor
	 *            the motor to set
	 */
	public void setMotor(String motor) {
		this.motor = motor;
	}

	/**
	 * @return the kw
	 */
	public String getKw() {
		return kw;
	}

	/**
	 * @param kw
	 *            the kw to set
	 */
	public void setKw(String kw) {
		this.kw = kw;
	}

	/**
	 * @return the ps
	 */
	public String getPs() {
		return ps;
	}

	/**
	 * @param ps
	 *            the ps to set
	 */
	public void setPs(String ps) {
		this.ps = ps;
	}

	/**
	 * @return the hubraum
	 */
	public String getHubraum() {
		return hubraum;
	}

	/**
	 * @param hubraum
	 *            the hubraum to set
	 */
	public void setHubraum(String hubraum) {
		this.hubraum = hubraum;
	}

	/**
	 * @return the hsn_tsn
	 */
	public String getHsn_tsn() {
		return hsn_tsn;
	}

	/**
	 * @param hsn_tsn
	 *            the hsn_tsn to set
	 */
	public void setHsn_tsn(String hsn_tsn) {
		this.hsn_tsn = hsn_tsn;
	}

	/**
	 * @return the motorcode
	 */
	public String getMotorcode() {
		return motorcode;
	}

	/**
	 * @param motorcode
	 *            the motorcode to set
	 */
	public void setMotorcode(String motorcode) {
		this.motorcode = motorcode;
	}

	/**
	 * @return the antrieb
	 */
	public String getAntrieb() {
		return antrieb;
	}

	/**
	 * @param antrieb
	 *            the antrieb to set
	 */
	public void setAntrieb(String antrieb) {
		this.antrieb = antrieb;
	}

	/**
	 * @return the zusatz
	 */
	public String getZusatz() {
		return zusatz;
	}

	/**
	 * @param zusatz
	 *            the zusatz to set
	 */
	public void setZusatz(String zusatz) {
		this.zusatz = zusatz;
	}

	/**
	 * @return the artikelnummer
	 */
	public String getArtikelnummer() {
		return artikelnummer;
	}

	/**
	 * @param artikelnummer
	 *            the artikelnummer to set
	 */
	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	/**
	 * @return the einbauort
	 */
	public String getEinbauort() {
		return einbauort;
	}

	/**
	 * @param einbauort
	 *            the einbauort to set
	 */
	public void setEinbauort(String einbauort) {
		this.einbauort = einbauort;
	}

	/**
	 * @return the zulassung
	 */
	public String getZulassung() {
		return zulassung;
	}

	/**
	 * @param zulassung
	 *            the zulassung to set
	 */
	public void setZulassung(String zulassung) {
		this.zulassung = zulassung;
	}

	/**
	 * @return the _
	 */
	public String get_() {
		return _;
	}

	/**
	 * @param _
	 *            the _ to set
	 */
	public void set_(String _) {
		this._ = _;
	}

	/**
	 * @return the preis_brutto
	 */
	public String getPreis_brutto() {
		return preis_brutto;
	}

	/**
	 * @param preis_brutto
	 *            the preis_brutto to set
	 */
	public void setPreis_brutto(String preis_brutto) {
		this.preis_brutto = preis_brutto;
	}

	/**
	 * @return the jurzbeschreibung
	 */
	public String getKurzbeschreibung() {
		return kurzbeschreibung;
	}

	/**
	 * @param jurzbeschreibung
	 *            the jurzbeschreibung to set
	 */
	public void setKurzbeschreibung(String kurzbeschreibung) {
		this.kurzbeschreibung = kurzbeschreibung;
	}

	/**
	 * @return the langbeschreibung
	 */
	public String getLangbeschreibung() {
		return langbeschreibung;
	}

	/**
	 * @param langbeschreibung
	 *            the langbeschreibung to set
	 */
	public void setLangbeschreibung(String langbeschreibung) {
		this.langbeschreibung = langbeschreibung;
	}

	/**
	 * @return the bildpfad_zeichnung
	 */
	public String getBildpfad_zeichnung() {
		return bildpfad_zeichnung;
	}

	/**
	 * @param bildpfad_zeichnung
	 *            the bildpfad_zeichnung to set
	 */
	public void setBildpfad_zeichnung(String bildpfad_zeichnung) {
		this.bildpfad_zeichnung = bildpfad_zeichnung;
	}

	/**
	 * @return the bildpfad_kategorie
	 */
	public String getBildpfad_kategorie() {
		return bildpfad_kategorie;
	}

	/**
	 * @param bildpfad_kategorie
	 *            the bildpfad_kategorie to set
	 */
	public void setBildpfad_kategorie(String bildpfad_kategorie) {
		this.bildpfad_kategorie = bildpfad_kategorie;
	}

	/**
	 * @return the verschleisswarnkontakt
	 */
	public String getVerschleisswarnkontakt() {
		return verschleisswarnkontakt;
	}

	/**
	 * @param verschleisswarnkontakt
	 *            the verschleisswarnkontakt to set
	 */
	public void setVerschleisswarnkontakt(String verschleisswarnkontakt) {
		this.verschleisswarnkontakt = verschleisswarnkontakt;
	}

	/**
	 * @return the ean
	 */
	public String getEan() {
		return ean;
	}

	/**
	 * @param ean
	 *            the ean to set
	 */
	public void setEan(String ean) {
		this.ean = ean;
	}

	public DataSetOrigin() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataSetOrigin [tec_ID=" + tec_ID + ", marke=" + marke + ", modell=" + modell + ", ausfuehrung="
				+ ausfuehrung + ", aufbauart=" + aufbauart + ", typ1=" + typ1 + ", modell_BJ=" + modell_BJ + ", fhz_BJ="
				+ fhz_BJ + ", motor=" + motor + ", kw=" + kw + ", ps=" + ps + ", hubraum=" + hubraum + ", hsn_tsn="
				+ hsn_tsn + ", motorcode=" + motorcode + ", antrieb=" + antrieb + ", zusatz=" + zusatz
				+ ", artikelnummer=" + artikelnummer + ", einbauort=" + einbauort + ", zulassung=" + zulassung + ", _="
				+ _ + ", preis_brutto=" + preis_brutto + ", jurzbeschreibung=" + kurzbeschreibung
				+ ", langbeschreibung=" + langbeschreibung + ", bildpfad_zeichnung=" + bildpfad_zeichnung
				+ ", bildpfad_kategorie=" + bildpfad_kategorie + ", verschleisswarnkontakt=" + verschleisswarnkontakt
				+ ", ean=" + ean + "]";
	}

}
