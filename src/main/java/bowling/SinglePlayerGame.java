package bowling;
import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        
	/**
	 * Constructeur
	 */
         
         //ArrayList<Integer> Liste = new ArrayList()<Integer>;
         int score[] = new int[22];
         int numeroLancer = 0 ;
         
	public SinglePlayerGame() {
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            score[numeroLancer] = nombreDeQuillesAbattues;
            numeroLancer ++;
            if(nombreDeQuillesAbattues == 10 && numeroLancer <= 19){numeroLancer ++; score[numeroLancer] = -1;}
            
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            int res = 0;
            boolean secondeBoule = false;
            for(int i =0 ; i < 20 ; i++){
                if (score[i] == 10 && !(secondeBoule)){if(score[i+3] == -1){res+=score[i]+score[i+2]+score[i+4];} else{res+=score[i]+score[i+2]+score[i+3];}
                }
                else{
                    if(secondeBoule && score[i]+score[i-1]==10){
                        res+=score[i]+score[i+1];
                        secondeBoule = false;
                    }
                    else{res+=score[i];secondeBoule = !(secondeBoule);}
                }
            }
                return res;
	}
}
