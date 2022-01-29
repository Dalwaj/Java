
public class MainListe {

    public static void main (String args[]) {

	/*Liste L1 = new Liste(3);
	L1.ajoutTete(2);
	L1.ajoutTete(6);
	
	System.out.println("2 appartient L1 ? " + L1.contient(2));

	int[] tab = {-3, -8, 5, 6, 8, 2, 6};
	Liste L2 = new Liste (tab);

	Liste Lvide = new Liste();
	System.out.println("1 appartient Lvide ? " + Lvide.contient(1));

	Liste L2copie = new Liste(L2);

	System.out.println("L1 = " + L1); 
	System.out.println("L2 = " + L2);
	System.out.println("Lvide = " + Lvide);
	System.out.println("L2copie = " + L2copie);

	System.out.println("Longueur de L1 = " + L1.longueur());
	//System.out.println("Longueur de L2 = " + L2.longueurR());

	System.out.println("Somme de L1 = " + L1.somme());
	System.out.println("Somme de L2 = " + L2.somme());

	System.out.println("Dernier de L1 = " + L1.dernierElt());
	
	System.out.println("L1 lg paire = " + L1.aLgPaire());
	System.out.println("L2 lg paire = " + L2.aLgPaire());

	System.out.println("Longueur L1 > 2 ? = " + L1.estSupK(2));
	//System.out.println("Longueur L1 > 2 ? = " + L1.estSupK2(2));
	System.out.println("Longueur L1 > 3 ? = " + L1.estSupK(3));
	//System.out.println("Longueur L1 > 3 ? = " + L1.estSupK2(3));

	System.out.println("Max L1 = " + L1.max());
	System.out.println("Max L2 = " + L2.max());

	System.out.println("Occurrences de 3 dans L1 = " + L1.count(3));
	System.out.println("Occurrences de 6 dans L2 = " + L2.count(6));

	L1.add(-7);
	System.out.println("Ajout de -7 en fin de L1 = " + L1);

	L1.ajoutFinSiAbsent(4);
	System.out.println("Ajout de 4 dans L1 car absent = " + L1);
	L1.ajoutFinSiAbsent(4); 
	System.out.println("Non ajout de 4 dans L1 car present = " + L1);
	L2.ajoutFinSiAbsent(2);
	System.out.println("Non ajout de 2 dans L2 car present " + L2);
	Lvide.ajoutFinSiAbsent(1); 
	System.out.println("Ajout de 1 a une liste vide = " + Lvide);

	System.out.println("Extraire impairs de L1 = " + L1.extractionImpairs());
	System.out.println("Extraire impairs de L2 = " + L2.extractionImpairs());

	L1.suppressionElt(3);
	System.out.println("Suppr first 3 de L1 = " + L1);
        L2.suppressionElt(6);
	System.out.println("Suppr first 6 de L2 = " + L2);
	L2.suppressionElt(6);
	System.out.println("Suppr first 6 de L2 = " + L2);
	L2.suppressionElt(-3);
	System.out.println("Suppr first -3 de L2 = " + L2);

	L2.tronquerK(2);
	System.out.println("Tronque L2 indice 2 = " + L2);

	int[] tab4 = {1, 2, 3, 4};
	Liste L4 = new Liste (tab4);

	int[] tab5 = {0, 1, 2, 3, 4}; 
	Liste L5 = new Liste (tab5);

	System.out.println("L4 = " + L4 + " L5 = " + L5);
	System.out.println("L4 clone de L5 = " + L4.estClone(L5));
	Liste L4clone = new Liste(L4);
	System.out.println("L4clone clone de L4 = " + L4.estClone(L4clone));

	int[] tab3 = {-3, -3, -8, -3, -3, 6, -3, 5, -3, 8, -3}; 
	Liste L3 = new Liste (tab3);
	System.out.println("L3 = " + L3);

	L3.suppToutesOcc(-3);
	System.out.println("SuppToutesOcc de L3 = " + L3);

	
	System.out.print("L4 a l'envers = " + L4.reverse());
	System.out.println("");

	/*System.out.print("Inversion en place de L4 = ");
	L4.inverseRec(); 
	System.out.println(L4);
	
	int[] tab6 = {8, 8, 6}; 
	Liste L6 = new Liste (tab6);
	int[] tab7 = {1, 5, 8, 8, 4, 6, 8, 6, 4}; 
	Liste L7 = new Liste (tab7);

	System.out.println("L6 = " + L6 + " L7 = " + L7 + " Sous Liste ? " 
			   + L6.sousListe(L7));

	System.out.println("L6 = " + L6 + " L7 = " + L7 + " Sous Liste une boucle ? " 
			   + L6.sousListeUneBoucle(L7));
	
	//System.out.println("L6 = " + L6 + " L7 = " + L7 + " Sous Liste recursif ? " 
	//		   + L6.sousListeRec(L7));
	
	int[] tab8 = {8, 8, 6}; 
	Liste L8 = new Liste (tab8);

	int[] tab9 = {1, 5, 8, 8, 4, 6, 8, 8, 6, 4}; 
	Liste L9 = new Liste (tab9);

	System.out.println("L8 = " + L8 + " L9 = " + L9 + " Sous Liste ? " 
			   + L8.sousListe(L9));

	System.out.println("L8 = " + L8 + " L9 = " + L9 + " Sous Liste une boucle ? " 
			   + L8.sousListeUneBoucle(L9));

	//System.out.println("L8 = " + L8 + " L9 = " + L9 + " Sous Liste recursif ? " 
	//		   + L8.sousListeRec(L9));

	int[] tab10 = {10}; 
	Liste L10 = new Liste (tab10);
	L10.ajoutFinSiAbsent2(10);
	System.out.println("Ajout de 10 à (10) si 10 absent : L10 = " + L10);
	L10.ajoutFinSiAbsent2(11);
	System.out.println("Ajout de 11 à (10) si 11 absent : L10 = " + L10);*/

		int[] tab = new int[] {1, 2, 3, 4};
		displayTab(0, tab);
		reverseArray(0, tab);
		displayTab(0, tab);
    }

	public static void displayTab(int i, int[] tab){
		if (i == 0){
			System.out.print("Tableau de " + tab.length + " entiers : { ");
		} else if (i >= tab.length){
			return;
		} else if (i < 0){
			System.out.println("Insert index >= 0");
		}

		System.out.print(tab[i]);
		i++;

		if (i != tab.length){
			System.out.print(", ");
		} else {
			System.out.println(" }");
		}

		displayTab(i, tab);
	}

	public static void reverseArray(int i, int[] tab){
		if (i >= tab.length/2){
			return;
		} else if (i < 0){
			System.out.println("Insert index >= 0");
		}

		int n = tab[i];
		tab[i] = tab[tab.length-1-i];
		tab[tab.length-1-i] = n;

		i++;

		reverseArray(i, tab);
	}
}