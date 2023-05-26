package classes;

import java.sql.Blob;

public class Plante {
    private int id;
    private String nom;
    private String categorie;
    private String sel_min;
    private String virus;
    private Blob image;
    private String saison;
    private String arrosage;
    private String qte_eau;
    private String description;
    private String florison;    
   

 
	public Plante(int id, String nom, String categorie, String sel_min, String virus, Blob image, String saison, String arrosage, String qte_eau, String description, String florison) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.sel_min = sel_min;
        this.virus = virus;
        this.image = image;
        this.saison = saison;
        this.arrosage = arrosage;
        this.qte_eau = qte_eau;
        this.description = description;
        this.florison = florison;
    }
    
    public Plante(String nom, String categorie, String saison) {
    	this.nom = nom;
        this.categorie = categorie;
        this.saison = saison;
    }

    public String getFlorison() {
		return florison;
	}

	public void setFlorison(String florison) {
		this.florison = florison;
	}

	public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setSelMin(String sel_min) {
        this.sel_min = sel_min;
    }

    public String getSel_min() {
		return sel_min;
	}

	public void setSel_min(String sel_min) {
		this.sel_min = sel_min;
	}

	public String getQte_eau() {
		return qte_eau;
	}

	public void setQte_eau(String qte_eau) {
		this.qte_eau = qte_eau;
	}

	public void setVirus(String virus) {
        this.virus = virus;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public void setArrosage(String arrosage) {
        this.arrosage = arrosage;
    }

    public void setQteEau(String qte_eau) {
        this.qte_eau = qte_eau;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getSelMin() {
        return sel_min;
    }

    public String getVirus() {
        return virus;
    }

    public Blob getImage() {
        return image;
    }

    public String getSaison() {
        return saison;
    }

    public String getArrosage() {
        return arrosage;
    }

    public String getQteEau() {
        return qte_eau;
    }

    public String getDescription() {
        return description;
    }
    
}
