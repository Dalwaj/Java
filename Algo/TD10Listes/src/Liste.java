
public class Liste {

    private Maillon tete; 

    /** Constructeur d'une liste vide
     */
    public Liste () {
		this.tete = null;
    }

    /** Constructeur d'une liste a un seul element
     */
    public Liste (int x) { 
    	this.tete = new Maillon(x);
    }
    
  /** @param tabListe est un tableau contenant les elements de la liste
     * Pre-requis : aucun
     */
    public Liste (int[] tabListe) {
		this(); // Liste()
		if (tabListe.length > 0) {
			this.tete = new Maillon (tabListe[0]);
			Maillon curThis = this.tete;
			for (int i = 1 ; i < tabListe.length ; i++) {
			curThis.setSuiv (new Maillon(tabListe[i])); // creation et accrochage du maillon suivant
			curThis = curThis.getSuiv();
			}
	}
    }

   /**
     * Prerequis: aucun
     * construit une liste completement disjointe de la liste l 
     */
    public Liste (Liste l) { // constructeur par recopie profonde
	this(); 
	if (! l.estVide()) {

	    this.tete = new Maillon (l.tete.getVal());
	    Maillon curThis = this.tete;
	    Maillon curL = l.tete.getSuiv();

	    while (curL != null) {
		curThis.setSuiv (new Maillon(curL.getVal())); // creation et accrochage du maillon suivant
		curThis = curThis.getSuiv();
		curL = curL.getSuiv();
	    }
	}
    }

    public boolean estVide() {
	return (this.tete == null) ;
    }

    public void ajoutTete (int x) {
	Maillon m = new Maillon(x);
	m.setSuiv(this.tete);
	this.tete=m;
    }

    public boolean contient (int x) {
	Maillon courant = this.tete;
	while (courant != null && courant.getVal() != x) {
	    courant = courant.getSuiv(); 
	}
	return courant != null;
    }

    public String toString() {
	String s = "(";
	Maillon courant = this.tete;
	while (courant != null) {
	    s = s + (courant.getVal()) + ((courant.getSuiv() != null)?", ":"");
	    courant = courant.getSuiv();
	}
	return s + ")";
    }

	public int longueur(){
		Maillon curThis = this.tete;
		int count = 0;

		if (curThis != null){
			count = 1;
			while (curThis.getSuiv() != null){
				count++;
				curThis = curThis.getSuiv();
			}
		}

		return count;
	}

	public int somme(){
		Maillon curThis = this.tete;
		int somme = 0;

		for(int i = 0; i < this.longueur(); i++){
			somme += curThis.getVal();
			curThis = curThis.getSuiv();
		}

		return somme;
	}

	public int dernierElt(){
		Maillon curThis = this.tete;
		int value = 0, iMax = this.longueur()-1;

		if (this.tete != null){
			for(int i = 0; i < iMax; i++){
				curThis = curThis.getSuiv();
			}

			value = curThis.getVal();
		}

		return value;
	}

	public boolean estSupK(int k){
		return this.longueur() >= k;
	}

	public boolean aLgPaire(){
		return this.longueur()%2 == 0;
	}

	public int count(int n){
		Maillon curThis = this.tete;
		int length = this.longueur(), c = 0;

		for(int i = 0; i < length; i++){
			c = curThis.getVal() == n ? c+1 : c;
			curThis = curThis.getSuiv();
		}

		return c;
	}

	public void add(int n){
		Maillon curThis = this.tete;
		int length = this.longueur()-1;

		for(int i = 0; i < length; i++){
			curThis = curThis.getSuiv();
		}

		curThis.setSuiv(new Maillon(n));
	}

	public void ajoutFinSiAbsent(int n){
		Maillon curThis = this.tete;
		int length = this.longueur()-1;
		boolean exist = false;

		if (!this.estVide()){
			for(int i = 0; !exist && i < length; i++){
				exist = curThis.getVal() == n;
				curThis = curThis.getSuiv();
			}

			if (!exist){
				curThis.setSuiv(new Maillon(n));
			}
		} else {
			this.ajoutTete(n);
		}
	}

	public Liste extractionImpairs(){
		Liste liste = new Liste();
		Maillon curThis = this.tete;
		Maillon curListe = liste.tete;

		while (curThis != null){
			if ((!liste.estVide()) && curThis.getVal()%2 != 0){
				curListe.setSuiv(new Maillon(curThis.getVal()));
				curListe = curListe.getSuiv();
			} else if(liste.estVide() && curThis.getVal()%2 != 0) {
				liste.ajoutTete(curThis.getVal());
				curListe = liste.tete;
			}

			curThis = curThis.getSuiv();
		}

		return liste;
	}

	public void suppressionElt(int n){
		if (this.contient(n)){
			Maillon curThis = this.tete;

			while (curThis != null){
				if (this.tete.getVal() == n){
					this.tete = this.tete.getSuiv();
				} else if (curThis.getSuiv() != null && curThis.getSuiv().getVal() == n){
					curThis.setSuiv(curThis.getSuiv().getSuiv());
				}

				curThis = curThis.getSuiv();
			}
		}
	}


	public void tronquerK(int k){
		if (this.estSupK(k)){
			Maillon curThis = this.tete;

			for (int i = 0; i < k; i++){
				curThis = curThis.getSuiv();
			}

			curThis.setSuiv(null);
		}
	}

	public boolean estClone(Liste l){
		boolean areClones = true;
		Maillon curThis = this.tete;
		Maillon curListe = l.tete;

		if (this.longueur() == l.longueur()){
			while (curThis != null && areClones){
				areClones = curThis.getVal() == curListe.getVal();
				curThis = curThis.getSuiv();
				curListe = curListe.getSuiv();
			}
		} else {
			areClones = false;
		}

		return areClones;
	}

	public Liste reverse() {
		Liste l = new Liste();
		Maillon curThis = this.tete, prevThis = this.tete;

		for (int length = this.longueur(); length > 1; length--){
			for (int i = 1; i < (length-1); i++){
				prevThis = prevThis.getSuiv();
				curThis = prevThis.getSuiv();
			}
				if(l.estVide()){
					l.ajoutTete(curThis.getVal());
				}
				l.add(prevThis.getVal());
				prevThis = this.tete;
				curThis = prevThis.getSuiv();
		}

		return l;
	}

	public void suppToutesOcc(int n){
		if (!this.estVide()){
			int length = this.longueur()-1;
			Maillon curThis = this.tete;

			for(int i = 0; i < length; i++){
				if (this.tete.getVal() == n){
					this.tete = this.tete.getSuiv();
					curThis = this.tete;
				} else if (curThis.getSuiv().getVal() == n){
					curThis.setSuiv(curThis.getSuiv().getSuiv());
				} else {
					curThis = curThis.getSuiv();
				}
			}
		}
	}
} // end class
