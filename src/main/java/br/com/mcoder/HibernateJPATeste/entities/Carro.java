package br.com.mcoder.HibernateJPATeste.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "modelo", length = 50)
	private String modelo;
	
	@Column(name = "placa", length = 50)
	private String placa;
	
	@OneToMany(mappedBy = "carro")
	private List<Acessorio> acessorios;
	
	@ManyToOne
	@JoinColumn(name = "id_marca_fk", 
	foreignKey = @ForeignKey(name = "fk_marca_carro"),
	referencedColumnName = "id", nullable = false)
	private Marca marca;

	public Carro() {
		super();
	}

	public Carro(Long id, String modelo, String placa) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

	

	public List<Acessorio> getAcessorio() {
		return acessorios;
	}

	public void setAcessorio(List<Acessorio> acessorio) {
		this.acessorios = acessorio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
