package com.securin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather_data")
public class WeatherModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datetime;
    private String conds;
    private Double dewptm;
    private Integer fog;
    private Integer hail;
    private Double hum;
    private Double pressurem;
    private Double tempm;
    private Double wspdm;

    public WeatherModel() {}

    public WeatherModel(String datetime, String conds, Double dewptm,
                       Integer fog, Integer hail,
                       Double hum, Double pressurem,
                       Double tempm, Double wspdm) {

        this.setDatetime(datetime);
        this.setConds(conds);
        this.setDewptm(dewptm);
        this.setFog(fog);
        this.setHail(hail);
        this.setHum(hum);
        this.setPressurem(pressurem);
        this.setTempm(tempm);
        this.setWspdm(wspdm);
    }

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getConds() {
		return conds;
	}

	public void setConds(String conds) {
		this.conds = conds;
	}

	public Double getDewptm() {
		return dewptm;
	}

	public void setDewptm(Double dewptm) {
		this.dewptm = dewptm;
	}

	public Integer getFog() {
		return fog;
	}

	public void setFog(Integer fog) {
		this.fog = fog;
	}

	public Integer getHail() {
		return hail;
	}

	public void setHail(Integer hail) {
		this.hail = hail;
	}

	public Double getWspdm() {
		return wspdm;
	}

	public void setWspdm(Double wspdm) {
		this.wspdm = wspdm;
	}

	public Double getTempm() {
		return tempm;
	}

	public void setTempm(Double tempm) {
		this.tempm = tempm;
	}

	public Double getPressurem() {
		return pressurem;
	}

	public void setPressurem(Double pressurem) {
		this.pressurem = pressurem;
	}

	public Double getHum() {
		return hum;
	}

	public void setHum(Double hum) {
		this.hum = hum;
	}

}