package com.techymeet.vo;

	import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

	@Entity
	@Table(name="image")
	
	public class ImageEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    

	    @Lob
	    private byte[] image;
	    @Column(name = "name")
		private String name;
		@Column(name = "type")
		private String type;
	    
	    public ImageEntity() {
	    }

	    public ImageEntity(String name, String type, byte[] image) {
	        this.name = name;
	        this.type = type;
	        this.image = image;
	    }
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}


