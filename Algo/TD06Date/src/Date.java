public class Date {
    public int jour, mois, annee;

    private static String moisLettre[] = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet",
            "aout", "septembre", "octobre", "novembre", "decembre"};
    int nbJours[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int jour, int mois, int annee){
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        nbJours[1] = this.estBissextile()? 29 : 28;
    }

    public boolean estBissextile(){
        if (this.annee%4 == 0 && this.annee%100 == 0 || this.annee%400 == 0){
            return true;
        } else {
            return false;
        }
    }

    public int nbJoursMois(){
        return nbJours[mois-1];
    }

    public void incrementerDate(){
        jour++;

        if (jour > nbJours[mois-1]){
            jour = 1;
            mois++;
            if (mois > 12){
                mois = 1;
                annee++;
            }
        }
    }

    public Date lendemain(){
        Date d1 = new Date(this.jour, this.mois, this.annee);
        d1.incrementerDate();
        return d1;
    }

    public void print(){
        System.out.print(jour + " " + moisLettre[mois-1] + " " + annee);
    }

    public boolean isEquals(Date date){
        return this.annee == date.annee && this.mois == date.mois && this.jour == date.jour;
    }

    public boolean isAnterior(Date date){
        boolean isAnterior = true;

        if (this.annee > date.annee){
            isAnterior = false;
        } else if (this.mois > date.mois){
            isAnterior = false;
        } else if (this.jour >= date.jour){
            isAnterior = false;
        }

        return isAnterior;
    }

    public boolean isPosterior(Date date){
        boolean isPosterior = true;

        if (this.annee < date.annee){
            isPosterior = false;
        } else if (this.mois < date.mois){
            isPosterior = false;
        } else if (this.jour <= date.jour){
            isPosterior = false;
        }

        return isPosterior;
    }

    public int nbJoursEcart(Date date){
        int n = 0;
        boolean estAnterior = this.isAnterior(date);

        if (estAnterior){
            while(!this.isEquals(date)){
                this.incrementerDate();
                n++;
            }
        } else {
            while(!date.isEquals(this)){
                date.incrementerDate();
                n++;
            }
        }

        System.out.println(n);
        return n;
    }


}
