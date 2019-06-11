/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "praticien", catalog = "ppegsb", schema = "")
@NamedQueries({
	@NamedQuery(name = "Praticien.findAll", query = "SELECT p FROM Praticien p")
	, @NamedQuery(name = "Praticien.findByPraNumPraticien", query = "SELECT p FROM Praticien p WHERE p.praNumPraticien = :praNumPraticien")
	, @NamedQuery(name = "Praticien.findByPraNomPraticien", query = "SELECT p FROM Praticien p WHERE p.praNomPraticien = :praNomPraticien")
	, @NamedQuery(name = "Praticien.findByPraPrenomPraticien", query = "SELECT p FROM Praticien p WHERE p.praPrenomPraticien = :praPrenomPraticien")
	, @NamedQuery(name = "Praticien.findByPraAdressePraticien", query = "SELECT p FROM Praticien p WHERE p.praAdressePraticien = :praAdressePraticien")
	, @NamedQuery(name = "Praticien.findByPraCpPraticien", query = "SELECT p FROM Praticien p WHERE p.praCpPraticien = :praCpPraticien")
	, @NamedQuery(name = "Praticien.findByPraVillePraticien", query = "SELECT p FROM Praticien p WHERE p.praVillePraticien = :praVillePraticien")
	, @NamedQuery(name = "Praticien.findByPraCoefnotorietePraticien", query = "SELECT p FROM Praticien p WHERE p.praCoefnotorietePraticien = :praCoefnotorietePraticien")
	, @NamedQuery(name = "Praticien.findByTypCodeTypePraticien", query = "SELECT p FROM Praticien p WHERE p.typCodeTypePraticien = :typCodeTypePraticien")})
public class Praticien implements Serializable {

	@Transient
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @Column(name = "PRA_NUM_PRATICIEN")
	private Short praNumPraticien;
	@Column(name = "PRA_NOM_PRATICIEN")
	private String praNomPraticien;
	@Column(name = "PRA_PRENOM_PRATICIEN")
	private String praPrenomPraticien;
	@Column(name = "PRA_ADRESSE_PRATICIEN")
	private String praAdressePraticien;
	@Column(name = "PRA_CP_PRATICIEN")
	private String praCpPraticien;
	@Column(name = "PRA_VILLE_PRATICIEN")
	private String praVillePraticien;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "PRA_COEFNOTORIETE_PRATICIEN")
	private Float praCoefnotorietePraticien;
	@Column(name = "TYP_CODE_TYPE_PRATICIEN")
	private Short typCodeTypePraticien;

	public Praticien() {
	}

	public Praticien(Short praNumPraticien) {
		this.praNumPraticien = praNumPraticien;
	}

	public Short getPraNumPraticien() {
		return praNumPraticien;
	}

	public void setPraNumPraticien(Short praNumPraticien) {
		Short oldPraNumPraticien = this.praNumPraticien;
		this.praNumPraticien = praNumPraticien;
		changeSupport.firePropertyChange("praNumPraticien", oldPraNumPraticien, praNumPraticien);
	}

	public String getPraNomPraticien() {
		return praNomPraticien;
	}

	public void setPraNomPraticien(String praNomPraticien) {
		String oldPraNomPraticien = this.praNomPraticien;
		this.praNomPraticien = praNomPraticien;
		changeSupport.firePropertyChange("praNomPraticien", oldPraNomPraticien, praNomPraticien);
	}

	public String getPraPrenomPraticien() {
		return praPrenomPraticien;
	}

	public void setPraPrenomPraticien(String praPrenomPraticien) {
		String oldPraPrenomPraticien = this.praPrenomPraticien;
		this.praPrenomPraticien = praPrenomPraticien;
		changeSupport.firePropertyChange("praPrenomPraticien", oldPraPrenomPraticien, praPrenomPraticien);
	}

	public String getPraAdressePraticien() {
		return praAdressePraticien;
	}

	public void setPraAdressePraticien(String praAdressePraticien) {
		String oldPraAdressePraticien = this.praAdressePraticien;
		this.praAdressePraticien = praAdressePraticien;
		changeSupport.firePropertyChange("praAdressePraticien", oldPraAdressePraticien, praAdressePraticien);
	}

	public String getPraCpPraticien() {
		return praCpPraticien;
	}

	public void setPraCpPraticien(String praCpPraticien) {
		String oldPraCpPraticien = this.praCpPraticien;
		this.praCpPraticien = praCpPraticien;
		changeSupport.firePropertyChange("praCpPraticien", oldPraCpPraticien, praCpPraticien);
	}

	public String getPraVillePraticien() {
		return praVillePraticien;
	}

	public void setPraVillePraticien(String praVillePraticien) {
		String oldPraVillePraticien = this.praVillePraticien;
		this.praVillePraticien = praVillePraticien;
		changeSupport.firePropertyChange("praVillePraticien", oldPraVillePraticien, praVillePraticien);
	}

	public Float getPraCoefnotorietePraticien() {
		return praCoefnotorietePraticien;
	}

	public void setPraCoefnotorietePraticien(Float praCoefnotorietePraticien) {
		Float oldPraCoefnotorietePraticien = this.praCoefnotorietePraticien;
		this.praCoefnotorietePraticien = praCoefnotorietePraticien;
		changeSupport.firePropertyChange("praCoefnotorietePraticien", oldPraCoefnotorietePraticien, praCoefnotorietePraticien);
	}

	public Short getTypCodeTypePraticien() {
		return typCodeTypePraticien;
	}

	public void setTypCodeTypePraticien(Short typCodeTypePraticien) {
		Short oldTypCodeTypePraticien = this.typCodeTypePraticien;
		this.typCodeTypePraticien = typCodeTypePraticien;
		changeSupport.firePropertyChange("typCodeTypePraticien", oldTypCodeTypePraticien, typCodeTypePraticien);
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (praNumPraticien != null ? praNumPraticien.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Praticien)) {
			return false;
		}
		Praticien other = (Praticien) object;
		if ((this.praNumPraticien == null && other.praNumPraticien != null) || (this.praNumPraticien != null && !this.praNumPraticien.equals(other.praNumPraticien))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "IHM.Praticien[ praNumPraticien=" + praNumPraticien + " ]";
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}
	
}
