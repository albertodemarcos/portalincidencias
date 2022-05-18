package es.incidence.ms.domain.embebbed;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Location {

	private Long longitude;
	private Long latitude;

	public Location() {
		super();
	}

	public Location(Long longitude, Long latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Size(max = 255)
	@Column(name = "longitude", nullable = true)
	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	@Size(max = 255)
	@Column(name = "latitude", nullable = true)
	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

}
