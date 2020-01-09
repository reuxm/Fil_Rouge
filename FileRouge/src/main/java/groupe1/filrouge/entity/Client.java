package groupe1.filrouge.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@NamedQueries(value = { @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
		@NamedQuery(name = "Client.findByName", query = "SELECT CLI FROM Client AS CLI WHERE CLI.name like ?1") })
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nom", length = 50, nullable = false)
	private String name;

	@Column(name = "prenom", length = 50, nullable = false)
	private String firstname;

	@Column(name = "adresse", length = 50, nullable = false)
	private String adresse;

	@Column(name = "code_postal", length = 50, nullable = false)
	private String codepostal;

	@Column(name = "ville", length = 50, nullable = false)
	private String ville;

	@Column(name = "telephone", length = 50, nullable = false)
	private String telephone;

	@Column(name = "mobile", length = 50, nullable = false)
	private String mobile;

	@Column(name = "portable", length = 50, nullable = false)
	private String portable;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Devis> listeDevis;

	public List<Devis> getListeDevis() {
		return listeDevis;
	}

	public void setListeDevis(List<Devis> listeDevis) {
		this.listeDevis = listeDevis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPortable() {
		return portable;
	}

	public void setPortable(String portable) {
		this.portable = portable;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", firstname=" + firstname + ", adresse=" + adresse
				+ ", codepostal=" + codepostal + ", ville=" + ville + ", telephone=" + telephone + ", mobile=" + mobile
				+ ", portable=" + portable + "]";
	}

}
